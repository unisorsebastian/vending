package ro.app.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.stereotype.Service;

import ro.app.model.Coin;
import ro.app.model.NegativeAmountException;
import ro.app.model.PoorManException;
import ro.app.model.RichieRichException;

@Service
public class ChangeCoinServiceImpl implements ChangeCoinService {

	@Override
	public Collection<Coin> getChangeFor(int pence) {
		Collection<Coin> result = Collections.<Coin> emptyList();

		handleNegativeCoinInput(pence);
		handleAmountTooBig(pence);

		return result;
	}

	private void handleNegativeCoinInput(int pence) {
		if (pence < 0) {
			throw new NegativeAmountException();
		} else if(pence==0){
			throw new PoorManException();
		}
	}

	private void handleAmountTooBig(int pence) {
		if (pence >= Integer.MAX_VALUE) {
			throw new RichieRichException();
		}
	}

}
