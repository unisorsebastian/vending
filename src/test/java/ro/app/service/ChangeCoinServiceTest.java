package ro.app.service;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import ro.app.model.Coin;
import ro.app.model.NegativeAmountException;
import ro.app.model.PoorManException;
import ro.app.model.RichieRichException;

@RunWith(SpringRunner.class)
public class ChangeCoinServiceTest {

	private ChangeCoinService changeCoinService;
	
	@Before
	public void setUp() throws Exception {
		changeCoinService = new ChangeCoinServiceImpl();
	}

	@Test(expected = NegativeAmountException.class)
	public void negativeAmountTest() throws Exception {
		changeCoinService.getChangeFor(-2);
	}
	@Test(expected = PoorManException.class)
	public void zeroAmountTest() throws Exception {
		changeCoinService.getChangeFor(0);
	}
	
	@Test(expected = RichieRichException.class)
	public void amountTooBigTest() throws Exception{
		changeCoinService.getChangeFor(Integer.MAX_VALUE);
	}
	
	@Test
	public void highestCoinForInputTest() throws Exception{
		Coin onePenny = changeCoinService.getHighestCoinForInput(51);
		assertTrue(onePenny.equals(Coin.OnePenny));
	}

}
