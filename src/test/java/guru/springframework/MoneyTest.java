package guru.springframework;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class MoneyTest {
	
	@Test
	void testMultiplicationDollar() {
		Money five = Money.dollar(5);
		assertEquals(Money.dollar(10), five.times(2));
		assertEquals(Money.dollar(25), five.times(5));
	}
	
	@Test
	void testEqualityDollar() {
		assertEquals(Money.dollar(5), new Dollar(5));
		assertNotEquals(Money.dollar(5), new Dollar(7));
		assertNotEquals(Money.dollar(5), new Franc(5));
	}
	
	@Test
	void testMultiplicationFranc() {
		Money five = Money.frank(5);
		assertEquals(Money.frank(10), five.times(2));
		assertEquals(Money.frank(25), five.times(5));
	}
	
	@Test
	void testEqualityFranc() {
		assertEquals(Money.frank(5), new Franc(5));
		assertNotEquals(Money.frank(5), new Franc(7));
	}


}
