package guru.springframework;

public class Money {

	protected final int amount;
	protected final String currency;


	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}
	
	public static Dollar dollar(int amount) {
		return new Dollar(amount, "USD");
	}
	
	public static Franc franc(int amount) {
		return new Franc(amount, "CHF");
	}
	
	public String currency() {
		return this.currency;
	}
	
	public Money times(int multiplier) {
		return new Money(amount * multiplier, this.currency);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Money) {
			Money money = (Money) obj;
			return money.amount == this.amount && currency == money.currency;
		}
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "Money [amount=" + amount + ", currency=" + currency + "]";
	}

}
