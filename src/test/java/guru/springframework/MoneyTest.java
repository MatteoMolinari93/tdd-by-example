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
	void addition() {
		Money fiveDollars = Money.dollar(5);
		Expression sum = fiveDollars.plus(fiveDollars);
		Bank bank = new Bank();
		Money reduced = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(10), reduced);
	}


}
