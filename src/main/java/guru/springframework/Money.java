package guru.springframework;

public abstract class Money {

	protected final int amount;
	
	public abstract Money times(int multiplier);

	public Money(int amount) {
		this.amount = amount;
	}
	
	public static Dollar dollar(int amount) {
		return new Dollar(amount);
	}
	
	public static Franc frank(int amount) {
		return new Franc(amount);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Money) {
			return ((Money) obj).amount == this.amount && getClass().equals(obj.getClass());
		}
		return super.equals(obj);
	}

}
