package problem;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class AgentTest {
  private Agent<RentalContract, ResidentialProperty> testAgent1;
  private String name1;
  private Double commissionRate1;
  private Double totalEarnings1;
  private Listing<RentalContract, ResidentialProperty> listing1;
  private ArrayList<Listing<RentalContract, ResidentialProperty>> collectionOfTheirCurrentListing1;
  private ArrayList<Listing> collection;
  private RentalContract rentalContract1;
  private ResidentialProperty residentialProperty1;

  private Agent<SalesContract, CommercialProperty> testAgent2;
  private String name2;
  private Double commissionRate2;
  private Double totalEarnings2;
  private Listing<SalesContract, CommercialProperty> listing2;
  private ArrayList<Listing<SalesContract, CommercialProperty>> collectionOfTheirCurrentListing2;
  private SalesContract saleContract2;
  private CommercialProperty commercialProperty2;

  @Before
  public void setUp() throws Exception {
    name1 = "Kyle Cogswell";
    commissionRate1 = 0.2;
    totalEarnings1 = 75000.0;
    listing1 = new Listing(rentalContract1, residentialProperty1);
    collectionOfTheirCurrentListing1 = new ArrayList<Listing<RentalContract, ResidentialProperty>>();
    rentalContract1 = new RentalContract(2000.0, true, 12);
    residentialProperty1 = new ResidentialProperty("Seattle", 100, 2,1.5);
    testAgent1 = new Agent(name1, collectionOfTheirCurrentListing1, commissionRate1,totalEarnings1);

    name2 = "Bill Thompson";
    commissionRate2 = 0.01;
    totalEarnings2 = 500.0;
    listing2 = new Listing(saleContract2, commercialProperty2);
    collectionOfTheirCurrentListing2 = new ArrayList<Listing<SalesContract, CommercialProperty>>();
    saleContract2 = new SalesContract(100000.0, false);
    commercialProperty2 = new CommercialProperty("X", 150, 5, true);
    testAgent2 = new Agent(name2, collectionOfTheirCurrentListing2, commissionRate2,totalEarnings2);
  }

  @Test
  public void addListing() {
    testAgent1.addListing(listing1);
    System.out.println("PRINT");
    System.out.println(testAgent1.getCollectionOfTheirCurrentListing());
//    testAgent1.addListing(listing2);
    System.out.println("PRINT2");
    System.out.println(testAgent1.getCollectionOfTheirCurrentListing());
  }

  @Test (expected = ListingDoesNotExistException.class)
  public void testCompleteListing1() throws ListingDoesNotExistException {
  testAgent1.completeListing(listing1);
    assertFalse(testAgent1.getCollectionOfTheirCurrentListing().contains(listing1));
  }

//  @Test (expected = ListingDoesNotExistException.class) //todo fix issue, how to fix NullPointerException ?
//  public void testCompleteListing2() throws ListingDoesNotExistException {
//    collectionOfTheirCurrentListing1.add(listing1);
//    testAgent1.completeListing(listing1);
//   assertEquals(0.0, testAgent1.getTotalPortfolioValue());
//  }

  @Test
  public void testDropListing1() throws ListingDoesNotExistException {
    testAgent1.addListing(listing1);
    testAgent1.dropListing(listing1);
    assertFalse(testAgent1.getCollectionOfTheirCurrentListing().contains(listing1));
  }

//  @Test //todo fix issue, how to fix NullPointerException ?
//  public void testGetTotalPortfolioValue() throws ListingDoesNotExistException {
//  Double expectedValue = 500.0;
//  collectionOfTheirCurrentListing2.add(listing2);
//  testAgent2.completeListing(listing2);
//  Double actualValue = testAgent2.getTotalPortfolioValue();
//  assertEquals(expectedValue, actualValue);
//  }

  @Test //todo How to test this or should we?
  public void getListingCommissionValue() {
  }

  @Test
  public void getCollectionOfTheirCurrentListing() {
  }

  @Test
  public void getCommissionRate() {
  }

  @Test
  public void getTotalEarnings() {
  }
}