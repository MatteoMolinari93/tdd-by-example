package guru.springframework;

public class Franc {

	private final int amount;

	public Franc(int amount) {
		this.amount = amount;
	}

	public Franc times(int multiplier) {
		return new Franc(amount * multiplier);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Franc) {
			return ((Franc) obj).amount == this.amount;
		}
		return super.equals(obj);
	}
	
	
	
	

}
