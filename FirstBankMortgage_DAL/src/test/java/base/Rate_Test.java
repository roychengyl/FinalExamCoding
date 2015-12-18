package base;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Rate_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

		assertEquals(5.0, RateDAL.getRate(600), 0);
		assertEquals(4.5, RateDAL.getRate(650), 0);
		assertEquals(4.0, RateDAL.getRate(700), 0);
		assertEquals(3.75, RateDAL.getRate(750), 0);
		assertEquals(3.5, RateDAL.getRate(800), 0);
	}

}
