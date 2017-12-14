package ro.app.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import ro.app.model.Coin;

public interface ChangeCoinService {
	Collection<Coin> getChangeFor(int pence);
	void buildChangeCoinStashForInput(int input, List<Coin> coins);
	Map<Coin,Integer> groupCoins(List<Coin> coins);
}
