package ro.app.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.stereotype.Service;

import ro.app.model.Coin;
import ro.app.model.NegativeAmountException;

@Service
public class ChangeCoinServiceImpl implements ChangeCoinService<Coin>{

	@Override
	public Collection<Coin> getChangeFor(int pence) {
		Collection<Coin> result = Collections.<Coin>emptyList();
		
		handleNegativeCoinInput(pence);
		
		return result;
	}

	private void handleNegativeCoinInput(int pence){
		if(pence<0){
			throw new NegativeAmountException();
		}
	}
	

}
