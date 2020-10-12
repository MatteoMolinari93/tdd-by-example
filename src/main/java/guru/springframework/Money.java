package guru.springframework;

public abstract class Money {

	protected final int amount;
	protected final String currency;
	
	public abstract Money times(int multiplier);

	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}
	
	public static Dollar dollar(int amount) {
		return new Dollar(amount);
	}
	
	public static Franc frank(int amount) {
		return new Franc(amount);
	}
	
	public String currency() {
		return this.currency;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Money) {
			return ((Money) obj).amount == this.amount && getClass().equals(obj.getClass());
		}
		return super.equals(obj);
	}

}
