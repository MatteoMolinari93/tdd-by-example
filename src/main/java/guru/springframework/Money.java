package guru.springframework;

public class Money {

	protected final int amount;

	public Money(int amount) {
		this.amount = amount;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Money) {
			return ((Money) obj).amount == this.amount;
		}
		return super.equals(obj);
	}

}
