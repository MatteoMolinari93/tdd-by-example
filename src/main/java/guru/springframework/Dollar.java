package guru.springframework;

public class Dollar extends Money {
	
	protected Dollar(int amount, String currency) {
		super(amount, currency);
	}

	public Money times(int multiplier) {
		return new Money(amount * multiplier, "USD");
	}
}
