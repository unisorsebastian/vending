package ro.app.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import ro.app.model.Coin;
import ro.app.model.CoinComparator;

@RunWith(SpringRunner.class)
public class CoinValueTest {
	private CoinComparator coinComparator;
	
	@Before
	public void setUp() throws Exception {
		coinComparator = new CoinComparator();
	}

	@Test
	public void onePoundValueTest() throws Exception {
		assertTrue(Coin.OnePound.getDenomination()==100);
	}
	
	@Test
	public void allCoinsValueTest() throws Exception {
		Coin[] enumConstants = Coin.class.getEnumConstants();
		assertTrue(enumConstants.length==6);
	} 
	
	@Test
	public void coinComparatorTest() throws Exception {
		assertTrue(coinComparator.compare(Coin.OnePenny, Coin.OnePound)<0);
		assertFalse(coinComparator.compare(Coin.OnePenny, Coin.OnePenny)<0);
		assertTrue(coinComparator.compare(Coin.FiftyPence, Coin.FivePence)>0);
		assertTrue(coinComparator.compare(Coin.FiftyPence, Coin.FiftyPence)==0);
	}
	
	@Test
	public void coinDescriptionTest() throws Exception{
		assertTrue(Coin.FivePence.toString().equals("Five pence means 5p"));
		assertFalse(Coin.FivePence.toString().equals("Five pence means 50p"));
	}
	
	
	@Test
	public void sortCoinsTest() throws Exception{
		//natural order - 3rd coin is one pound 
		Coin[] sortedCoins = Coin.values();
		assertTrue(sortedCoins[2]==Coin.OnePound);
		
		Arrays.sort(sortedCoins, coinComparator);
		assertTrue(sortedCoins[0]==Coin.OnePenny);
		
		Arrays.sort(sortedCoins, Collections.reverseOrder(coinComparator));
		assertTrue(sortedCoins[0]==Coin.OnePound);
	}
}
