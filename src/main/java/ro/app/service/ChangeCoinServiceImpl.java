package ro.app.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.springframework.stereotype.Service;

import ro.app.model.Coin;
import ro.app.model.CoinComparator;
import ro.app.model.NegativeAmountException;
import ro.app.model.PoorManException;
import ro.app.model.RichieRichException;

@Service
public class ChangeCoinServiceImpl implements ChangeCoinService {

	private CoinComparator coinComparator = new CoinComparator();

	@Override
	public Collection<Coin> getChangeFor(int pence) {
		Collection<Coin> result = Collections.<Coin> emptyList();

		handleNegativeCoinInput(pence);
		handleAmountTooBig(pence);

		/*
		 * 28 = 20+5+3*1
		 */

		return result;
	}

	private void handleNegativeCoinInput(int pence) {
		if (pence < 0) {
			throw new NegativeAmountException();
		} else if (pence == 0) {
			throw new PoorManException();
		}
	}

	private void handleAmountTooBig(int pence) {
		if (pence >= Integer.MAX_VALUE) {
			throw new RichieRichException();
		}
	}

	public Coin getHighestCoinForInput(int input) {
		Coin result = Coin.OnePenny;
		int coinValue = 0;
		Coin[] allCoins = Coin.values();
		Arrays.sort(allCoins, Collections.reverseOrder(coinComparator));
		for (Coin c : allCoins) {
			coinValue = c.getDenomination();
			result = c;
			if(input/coinValue>0){
				break;
			}
		}

		return result;
	}

}
