package guru.springframework;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class MoneyTest {
	
	@Test
	void testMultiplication() {
		Money fiveD = Money.dollar(5);
		assertEquals(Money.dollar(10), fiveD.times(2));
		assertEquals(Money.dollar(25), fiveD.times(5));
		
		Money fiveF = Money.franc(5);
		assertEquals(Money.franc(10), fiveF.times(2));
	}
	
	@Test
	void testEquality() {
		assertEquals(Money.dollar(5), Money.dollar(5));
		assertNotEquals(Money.dollar(5), Money.dollar(7));
		assertNotEquals(Money.dollar(5), Money.franc(5));
		
		assertEquals(Money.franc(5), Money.franc(5));
		assertNotEquals(Money.franc(5), Money.franc(7));
	}
	
	@Test
	void testCurrency() {
		assertEquals("USD", Money.dollar(1).currency());
		assertEquals("CHF", Money.franc(1).currency());
	}
	
	@Test
    void testSimpleAddition() {
        Expression five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Expression reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }

    @Test
    void testPlusReturnsSum() {
        Expression five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five, sum.augmend);
        assertEquals(five, sum.addmend);
    }

    @Test
    void testReduceSum() {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Expression result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }

    @Test
    void testReduceMoney() {
        Bank bank = new Bank();
        Expression result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }
    
    @Test
    void testReduceDifferentCurrency() {
    	Bank bank = new Bank();
    	bank.addRate("CHF", "USD", 2);
    	Expression result = bank.reduce(Money.franc(2), "USD");
    	assertEquals(Money.dollar(1), result);
    }
    
    @Test
    void testIdentityRate() {
    	assertEquals(1, new Bank().rate("USD", "USD"));
    	assertEquals(1, new Bank().rate("CHF", "CHF"));
    }
    
    @Test
    void testMixedAddition() {
    	Expression fiveBucks = Money.dollar(5);
    	Expression tenFrancs = Money.franc(10);
    	
    	Bank bank = new Bank();
    	bank.addRate("CHF", "USD", 2);
    	Expression result = bank.reduce(fiveBucks.plus(tenFrancs), "USD");
    	assertEquals(Money.dollar(10), result);
    }
    
    @Test
    void testSumPlusMoney() {
    	Expression fiveDollars = Money.dollar(5);
    	Expression tenFrancs = Money.franc(10);
    	Bank bank = new Bank();
    	bank.addRate("CHF", "USD", 2);
    	Expression sum = new Sum(fiveDollars, tenFrancs).plus(fiveDollars);
    	Money result = bank.reduce(sum, "USD");
    	assertEquals(Money.dollar(15), result);
    }
    
    @Test
    void testSumTimes() {
    	Expression fiveDollars = Money.dollar(5);
    	Expression tenFrancs = Money.franc(10);
    	Bank bank = new Bank();
    	bank.addRate("CHF", "USD", 2);
    	Expression sum = new Sum(fiveDollars, tenFrancs).times(2);
    	Money result = bank.reduce(sum, "USD");
    	assertEquals(Money.dollar(20), result);
    }

}
