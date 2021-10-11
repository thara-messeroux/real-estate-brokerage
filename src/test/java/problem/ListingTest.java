package problem;

import static org.junit.Assert.*;

import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class ListingTest {

  private Listing testListing;
  private Listing testListing2;
  private RentalContract rentalContract;
  private ResidentialProperty residentialProperty;
  private RentalContract rentalContract2;
  private ResidentialProperty residentialProperty2;
  private  String expectedString;

  @Before
  public void setUp() throws Exception {
    rentalContract = new RentalContract(75000.0, true, 6);
    residentialProperty = new ResidentialProperty("Seattle", 100, 3,
        1.5);
    rentalContract2 = new RentalContract(100000.0, false, 12);
    residentialProperty2 = new ResidentialProperty("Boston", 70, 2,
        2.0);
    testListing = new Listing(rentalContract, residentialProperty);
    testListing2 = new Listing(rentalContract, residentialProperty);
  }

  @Test
  public void getContract() {
    assertEquals(rentalContract, testListing.getContract());
  }

  @Test
  public void setContract() {
    testListing.setContract(rentalContract2);
    assertEquals(rentalContract2, testListing.getContract());
  }

  @Test
  public void getProperty() {
    assertEquals(residentialProperty, testListing.getProperty());
  }

  @Test
  public void setProperty() {
    testListing.setProperty(residentialProperty2);
    assertEquals(residentialProperty2, testListing.getProperty());
  }

  @Test
  public void testEquals() {
    assertTrue(testListing.equals(testListing));
    assertFalse(testListing.equals(rentalContract));
    assertTrue(testListing.equals(testListing2));
  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash(rentalContract, residentialProperty);
    assertEquals(hash, testListing.hashCode());
  }

  @Test
  public void testToString() {
    expectedString = "Listing{" +
        "contract=" + rentalContract +
        ", property=" + residentialProperty +
        '}';

    assertEquals(expectedString, testListing.toString());
  }
}