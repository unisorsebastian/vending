package ro.app.service;

import java.util.Collection;

import ro.app.model.Coin;

public interface ChangeCoinService<T extends Coin> {
	public Collection<T> getChangeFor(int pence);
}
