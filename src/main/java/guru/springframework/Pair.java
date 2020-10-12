package guru.springframework;

import java.util.Objects;

public class Pair {
	
	private final String from;
	private final String to;
	
	public Pair(String from, String to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Pair) {
			Pair pair = (Pair) obj;
			return this.from == pair.from && this.to == pair.to;
		}
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return Objects.hash(from, to);
	}
	
	

}
