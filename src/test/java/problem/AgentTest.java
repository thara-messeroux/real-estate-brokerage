package problem;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class AgentTest {

  private Agent<RentalContract, ResidentialProperty> testAgent1;
  private String name1;
  private Double commissionRate1;
  private Double totalEarnings1;
  private Listing<RentalContract, ResidentialProperty> listing1;
  private ArrayList<Listing<RentalContract, ResidentialProperty>> collectionOfTheirCurrentListing1;
  private RentalContract rentalContract1;
  private ResidentialProperty residentialProperty1;

  private Agent<SalesContract, CommercialProperty> testAgent2;
  private String name2;
  private Double commissionRate2;
  private Double totalEarnings2;
  private Listing<SalesContract, CommercialProperty> listing2;
  private ArrayList<Listing<SalesContract, CommercialProperty>> collectionOfTheirCurrentListing2;
  private ArrayList<Listing<RentalContract, ResidentialProperty>> collectionOfTheirCurrentListing3;
  private ArrayList<Listing> collectionOfTheirCurrentListing4;
  private SalesContract saleContract2;
  private CommercialProperty commercialProperty2;

  private Agent testAgent3;
  private String expectedString;

  @Before
  public void setUp() throws Exception {
    name1 = "Kyle Cogswell";
    commissionRate1 = 0.2;
    totalEarnings1 = 75000.0;

    collectionOfTheirCurrentListing1 = new ArrayList<Listing<RentalContract, ResidentialProperty>>();
    rentalContract1 = new RentalContract(2000.0, true, 12);
    residentialProperty1 = new ResidentialProperty("Seattle", 100, 2, 1.5);
    listing1 = new Listing(rentalContract1, residentialProperty1);
    testAgent1 = new Agent(name1, collectionOfTheirCurrentListing1, commissionRate1,
        totalEarnings1);

    name2 = "Bill Thompson";
    commissionRate2 = 0.01;
    totalEarnings2 = 500.0;

    collectionOfTheirCurrentListing2 = new ArrayList<Listing<SalesContract, CommercialProperty>>();
    collectionOfTheirCurrentListing3 = new ArrayList<Listing<RentalContract, ResidentialProperty>>();
    collectionOfTheirCurrentListing3.add(listing1);
    collectionOfTheirCurrentListing4 = new ArrayList<Listing>();
    saleContract2 = new SalesContract(100000.0, false);
    commercialProperty2 = new CommercialProperty("Boston", 150, 5, true);
    listing2 = new Listing(saleContract2, commercialProperty2);
    testAgent2 = new Agent(name2, collectionOfTheirCurrentListing2, commissionRate2,
        totalEarnings2);

    testAgent3 = new Agent(name1, collectionOfTheirCurrentListing4, commissionRate1,
        totalEarnings2);
  }

  @Test
  public void addListing() {
    testAgent1.addListing(listing1);
    //System.out.println(testAgent1.getCollectionOfTheirCurrentListing());
    /*testAgent1.addListing(listing2); does not accept, Agent specializes on Rental Contracts and
    Residential properties. It is not possible to add other types of contracts and properties*/
    //System.out.println(testAgent1.getCollectionOfTheirCurrentListing());
    testAgent3.addListing(listing1);
    testAgent3.addListing(listing2);
    //System.out.println(testAgent3.getCollectionOfTheirCurrentListing());
  }

  @Test(expected = ListingDoesNotExistException.class)
  public void testCompleteListing1() throws ListingDoesNotExistException {
    testAgent1.completeListing(listing1);
    assertFalse(testAgent1.getCollectionOfTheirCurrentListing().contains(listing1));
  }

  @Test
  public void testCompleteListing2() throws ListingDoesNotExistException {
    Double expectedTotalEarnings = 79800.0;
    testAgent1.addListing(listing1);
    //System.out.println(testAgent1.getListingCommissionValue(listing1));  //Expected 4800.0
    testAgent1.completeListing(listing1);

    //System.out.println(testAgent1.getTotalEarnings());  // Expected 48000 + 75,000
    assertEquals(expectedTotalEarnings, testAgent1.getTotalEarnings());

    assertFalse(testAgent1.getCollectionOfTheirCurrentListing().contains(listing1));
  }

  @Test
  public void testDropListing1() throws ListingDoesNotExistException {
    testAgent1.addListing(listing1);
    testAgent1.dropListing(listing1);
    assertFalse(testAgent1.getCollectionOfTheirCurrentListing().contains(listing1));
  }

  @Test(expected = ListingDoesNotExistException.class)
  public void testDropListing2() throws ListingDoesNotExistException {
    testAgent1.addListing(listing1);
    testAgent1.dropListing(listing2);
  }

  @Test
  public void testGetTotalPortfolioValue() throws ListingDoesNotExistException {
    Double expectedPortfolioValue = 1000.0;
    testAgent2.addListing(listing2);
    assertEquals(expectedPortfolioValue, testAgent2.getTotalPortfolioValue());
    testAgent2.completeListing(listing2);
    expectedPortfolioValue = 0.0;
    assertEquals(expectedPortfolioValue, testAgent2.getTotalPortfolioValue());
  }

  @Test
  public void getListingCommissionValue() {
    Double expectedCommissionValue = 4800.0;
    testAgent1.addListing(listing1);
    assertEquals(expectedCommissionValue, testAgent1.getListingCommissionValue(listing1));
  }

  @Test
  public void getName() {
    assertEquals(name1, testAgent1.getName());
  }

  @Test
  public void setName() {
    testAgent1.setName(name2);
    assertEquals(name2, testAgent1.getName());
  }

  @Test
  public void getCollectionOfTheirCurrentListing() {
    assertEquals(collectionOfTheirCurrentListing1, testAgent1.getCollectionOfTheirCurrentListing());
  }

  @Test
  public void setCollectionOfTheirCurrentListing() {
    testAgent1.setCollectionOfTheirCurrentListing(collectionOfTheirCurrentListing3);
    assertEquals(collectionOfTheirCurrentListing3, testAgent1.getCollectionOfTheirCurrentListing());
  }

  @Test
  public void getCommissionRate() {
    assertEquals(commissionRate1, testAgent1.getCommissionRate());
  }

  @Test
  public void setCommissionRate() {
    testAgent1.setCommissionRate(commissionRate2);
    assertEquals(commissionRate2, testAgent1.getCommissionRate());
  }

  @Test(expected = IllegalArgumentException.class)
  public void setCommissionRate2() throws IllegalArgumentException {
    testAgent1.setCommissionRate(2.0);
  }

  @Test
  public void getTotalEarnings() {
    assertEquals(totalEarnings1, testAgent1.getTotalEarnings());
  }

  @Test
  public void setTotalEarnings() {
    testAgent1.setTotalEarnings(totalEarnings2);
    assertEquals(totalEarnings2, testAgent1.getTotalEarnings());
  }

  @Test(expected = IllegalArgumentException.class)
  public void setTotalEarnings2() throws IllegalArgumentException {
    testAgent1.setTotalEarnings(-500000.0);
  }

  @Test
  public void testEquals() {
    assertTrue(testAgent1.equals(testAgent1));
    assertFalse(testAgent1.equals(testAgent2));
    assertFalse(testAgent1.equals(listing1));
  }

  @Test
  public void testHashCode() {
    int hash = Objects
        .hash(name1, collectionOfTheirCurrentListing1, commissionRate1, totalEarnings1);
    assertEquals(hash, testAgent1.hashCode());
  }

  @Test
  public void testToString() {
    expectedString = "Agent{" +
        "name='" + name1 + '\'' +
        ", collectionOfTheirCurrentListing=" + collectionOfTheirCurrentListing1 +
        ", commissionRate=" + commissionRate1 +
        ", totalEarnings=" + totalEarnings1 +
        '}';

    assertEquals(expectedString, testAgent1.toString());
  }
}