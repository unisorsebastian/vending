package ro.app.service;

import java.util.Collection;

import ro.app.model.Coin;

public interface ChangeCoinService {
	public Collection<Coin> getChangeFor(int pence);
	public Coin getHighestCoinForInput(int pence);
}
