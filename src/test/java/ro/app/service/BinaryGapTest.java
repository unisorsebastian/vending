package ro.app.service;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class BinaryGapTest {
	private BinaryGapService binaryGapService;
	private int []elements= {9,3,9,3,9,7,9};
	
	@Before
	public void setUp() throws Exception {
		binaryGapService = new BinaryGapServiceImpl();
	}
	
	@Test
	public void binaryGap() throws Exception{
		assertTrue(binaryGapService.binaryGapNoTrail(6)==0);
		assertTrue(binaryGapService.binaryGapNoTrail(5)==1);
		assertTrue(binaryGapService.binaryGapNoTrail(51712)==2);
		assertTrue(binaryGapService.binaryGapNoTrail(1041)==5);
		assertTrue(binaryGapService.binaryGapNoTrail(9)==2);
		assertTrue(binaryGapService.binaryGapNoTrail(328)==2);
		assertTrue(binaryGapService.binaryGapNoTrail(19)==2);
		assertTrue(binaryGapService.binaryGapNoTrail(42)==1);
	}
	
	@Test
	public void firstOddElementTest() throws Exception{
		assertTrue(binaryGapService.oddElement(elements)==7);
	}
}