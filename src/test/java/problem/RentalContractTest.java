package problem;

import static org.junit.Assert.*;

import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class RentalContractTest {

  private RentalContract testRental;
  private RentalContract testRental2;
  private Integer term;
  private Integer term2;
  private Boolean isNegotiable;
  private Double askingPrice;
  private Boolean isNegotiable2;
  private Double askingPrice2;
  private Double expectedCommission;
  private String expectedString;

  @Before
  public void setUp() throws Exception {
    askingPrice = 75000.0;
    term = 6;
    term2 = 12;
    isNegotiable = false;
    isNegotiable2 = true;
    askingPrice2 = 100000.0;
    testRental = new RentalContract(askingPrice, isNegotiable, term);
    testRental2 = new RentalContract(askingPrice, isNegotiable, term);
  }

  @Test
  public void getTermMonths() {
    assertEquals(term, testRental.getTermMonths());
  }

  @Test
  public void setTermMonths() {
    testRental.setTermMonths(term2);
    assertEquals(term2, testRental.getTermMonths());
  }

  @Test
  public void getAskingPrice() {
    assertEquals(askingPrice, testRental.getAskingPrice());
  }

  @Test
  public void setAskingPrice() {
    testRental.setAskingPrice(askingPrice2);
    assertEquals(askingPrice2, testRental.getAskingPrice());
  }

  @Test (expected = IllegalArgumentException.class)
  public void setAskingPrice2() throws IllegalArgumentException {
    testRental.setAskingPrice(-2000.0);
  }

  @Test
  public void getIsNegotiable() {
    assertEquals(isNegotiable, testRental.getNegotiable());
  }

  @Test
  public void setIsNegotiable() {
    testRental.setNegotiable(isNegotiable2);
    assertEquals(isNegotiable2, testRental.getNegotiable());
  }

  @Test
  public void getCommissionValue() {
    expectedCommission = 450000.0;
    assertEquals(expectedCommission, testRental.getCommissionValue());
  }

  @Test (expected = IllegalArgumentException.class)
  public void validInteger() {
    testRental2 = new RentalContract(askingPrice, false, -1);
  }

  @Test
  public void testEquals() {
    assertTrue(testRental.equals(testRental));
    assertTrue(testRental.equals(testRental2));
    assertFalse(testRental.equals(term));
  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash(term);
    assertEquals(hash, testRental.hashCode());
  }

  @Test
  public void testToString() {
    expectedString = "Rental{" +
        "askingPrice=" + askingPrice +
        ", isNegotiable=" + isNegotiable +
        ", termMonths=" + term +
        '}';
    assertEquals(expectedString, testRental.toString());
  }
}