package ro.app.model;

public enum Coin {
	FiftyPence(50, 'p', "Fifty pence"), 
	TenPence(10, 'p', "Ten pence"), 
	OnePound(100, 'p', "One pound"), 
	TwentyPence(20, 'p', "Twenty pence"), 
	FivePence(5, 'p', "Five pence"), 
	OnePenny(1, 'p', "One penny");
	
	Coin(int denomination, char symbol, String name) {
		this.denomination = denomination;
		this.symbol = symbol;
		this.name = name;
	}
	
	public static final String COIN_DESCRIPTION = "%s means %d%s"; 
	
	private final int denomination;
	private final char symbol;
	private final String name;

	public int getDenomination() {
		return denomination;
	}

	@Override
	public String toString() {
		return String.format(COIN_DESCRIPTION, name, denomination, symbol);
	}

}


