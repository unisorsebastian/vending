package ro.app.model;

import java.util.Comparator;

public class CoinComparator implements Comparator<Coin>{

	@Override
	public int compare(Coin o1, Coin o2) {
		return o1.getDenomination()-o2.getDenomination();
	}
	
}
