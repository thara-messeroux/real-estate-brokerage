package problem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SalesContractTest {

  SalesContract testSalesContract;
  Boolean isNegotiable;
  Double askingPrice;

  @Before
  public void setUp() throws Exception {
    isNegotiable = true;
    askingPrice = 200000.0;
    testSalesContract = new SalesContract(askingPrice, isNegotiable);
  }

  @Test
  public void testToString() {
    String toString = "Sales{" +
        "askingPrice=" + askingPrice +
        ", isNegotiable=" + isNegotiable +
        '}';
    assertEquals(toString, testSalesContract.toString());
  }
}