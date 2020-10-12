package guru.springframework;

public class Money implements Expression {

	protected final int amount;
	protected final String currency;


	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}
	
	public static Money dollar(int amount) {
		return new Money(amount, "USD");
	}
	
	public static Money franc(int amount) {
		return new Money(amount, "CHF");
	}
	
	public String currency() {
		return this.currency;
	}
	
	public Expression times(int multiplier) {
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
	public Money reduce(Bank bank, String to) {
		return new Money(amount / bank.rate(currency, to), to);
	}

	@Override
	public String toString() {
		return "Money [amount=" + amount + ", currency=" + currency + "]";
	}

	@Override
	public Expression plus(Expression addend) {
		return new Sum(this, addend);
	}
}
