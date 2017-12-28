package ro.app.service;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	public void amountTooBigTest() throws Exception {
		changeCoinService.getChangeFor(Integer.MAX_VALUE);
	}

	@Test
	public void highestCoinForInputTest() throws Exception {
		List<Coin> change = new ArrayList<>();
		changeCoinService.buildChangeCoinStashForInput(7, change);
		assertTrue(change.size() == 3);
		change = new ArrayList<>();
		changeCoinService.buildChangeCoinStashForInput(207, change);
		assertTrue(change.size() == 5);
		
	}
	
	@Test
//	@Ignore
	public void groupCoinsForMaxIntTest() throws Exception{
		List<Coin> change = new ArrayList<>();
		//takes few seconds to group all the coins
		changeCoinService.buildChangeCoinStashForInput(Integer.MAX_VALUE-1, change);
		Map<Coin, Integer> groupCoins = changeCoinService.groupCoins(change);
		//{One pound means 100p=21474836, Five pence means 5p=1, Twenty pence means 20p=2, One penny means 1p=1}
		System.out.println(groupCoins);
		assertTrue(groupCoins.get(Coin.OnePound)==21474836);
		assertTrue(groupCoins.get(Coin.TwentyPence)==2);
		assertTrue(groupCoins.get(Coin.FivePence)==1);
		assertTrue(groupCoins.get(Coin.OnePenny)==1);
	}

}
