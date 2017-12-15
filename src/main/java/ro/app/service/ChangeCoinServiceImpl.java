package ro.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		List<Coin> coins = new ArrayList<>();
		buildChangeCoinStashForInput(pence, coins);

		result = coins;
		
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

	public Map<Coin, Integer> groupCoins(List<Coin> coins) {
		Map<Coin, Integer> result = new HashMap<>();
		Collections.sort(coins, Collections.reverseOrder(coinComparator));
		for (Coin coin : coins) {
			Integer count = result.get(coin);
			if (count == null) {
				result.put(coin, 1);
			} else {
				result.put(coin, result.get(coin) + 1);
			}
		}

		return result;
	}

	public void buildChangeCoinStashForInput(int input, List<Coin> coins) {
		if (input == 0) {
			return;
		}

		if (coins == null) {
			coins = new ArrayList<Coin>();
		}

		int coinValue = 0;
		Coin[] allCoins = Coin.values();
		Arrays.sort(allCoins, Collections.reverseOrder(coinComparator));

		for (Coin coin : allCoins) {
			coinValue = coin.getDenomination();
			int catul = input / coinValue;
			int restul = input % coinValue;
			if (catul == 0 && restul > 0) {
				continue;

			} else if (catul > 0 && restul >= 0) {
				while (catul > 0) {
					coins.add(coin);
					catul--;
				}
				if (restul == 0) {
					break;
				}
				buildChangeCoinStashForInput(restul, coins);
				break;
			}
		}
	}

}
