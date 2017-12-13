package ro.app.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import ro.app.model.Coin;
import ro.app.model.NegativeAmountException;

@RunWith(SpringRunner.class)
public class ChangeCoinServiceTest {

	private ChangeCoinService<Coin> changeCoinService;
	
	@Before
	public void setUp() throws Exception {
		changeCoinService = new ChangeCoinServiceImpl();
	}

	@Test(expected = NegativeAmountException.class)
	public void negativeAmountTest() throws Exception {
		changeCoinService.getChangeFor(-2);
	}

}
