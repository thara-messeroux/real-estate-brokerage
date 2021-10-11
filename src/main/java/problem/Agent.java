package problem;

import java.util.ArrayList;

/**
 * Class Agent stores information about an agent. Agents are people responsible for adding listings to the company site.
 * @param <C> - Abstract Contract class generic extension.
 * @param <P> - Abstract Property class generic extension.
 */
public class Agent<C extends AbstractContract, P extends AbstractProperty> implements IAgent<C,P>{

  private static final Double ZERO = 0.0;
  private static final Double ONE = 1.0;

  private String name;
  private ArrayList<Listing<C, P>> collectionOfTheirCurrentListing;
  private Double commissionRate;
  private Double totalEarnings;

  /**
   * Constructor for the class Agent.
   * @param name - String, representing the agent's name.
   * @param collectionOfTheirCurrentListing - Array List, representing the collection of the agent's current listing.
   * @param commissionRate - Double, representing the agent's commission rate, represented as a double between 0 and 1 (inclusive).
   * @param totalEarnings - Double, non-negative, representing the total amount the Agent has earned from their sales / rentals.
   */
  public Agent(String name, ArrayList<Listing<C, P>> collectionOfTheirCurrentListing, Double commissionRate, Double totalEarnings) {
    this.name = name;
    this.collectionOfTheirCurrentListing = collectionOfTheirCurrentListing;
    this.commissionRate = this.validCommissionRate(commissionRate);
    this.totalEarnings = this.validTotalEarnings(totalEarnings);
  }

  /**
   * This method validates the agent's commission rate, which is represented as a double between 0 and 1 (inclusive).
   * @param validCommissionRate - Double, representing the agent's commission rate.
   * @return a valid commission rate.
   */
  private Double validCommissionRate(Double validCommissionRate) {
  if (validCommissionRate < ZERO || validCommissionRate > ONE) {
    throw new IllegalArgumentException(
        "Invalid commission rate, please enter a number between 0 and 1");
  }
  return validCommissionRate;
  }

  /**
   * This method validates the agent's total earnings which is represented as a non-negative double. This is the total
   * amount the Agent has earned from their sales / rentals.
   * @param validTotalEarnings - Double, representing the agent's valid total earnings.
   * @return a valid total earnings.
   */
  private Double validTotalEarnings(Double validTotalEarnings){
    if (validTotalEarnings < ZERO) {
      throw new IllegalArgumentException("Invalid Earning Amount. Please enter a non-negative number!");
    }
    return validTotalEarnings;
  }

  /**
   * This method Adds an (appropriate) listing to the Agent’s current listing collection.
   * @param listing - Generic Listing class, the agent's (appropriate) listing.
   */
  @Override
  public void addListing(Listing<C, P> listing) {
    this.collectionOfTheirCurrentListing.add(listing);
  }

  /**
   * This method will be called when an Agent successfully makes a sale / rental of one of their listings.
   * Assuming the listing is part of their collection, this method should remove the Listing from their
   * collection and add their commission earnings to their total earnings amount.
   * @param listing - Generic Listing class, the agent's (appropriate) listing.
   * @throws ListingDoesNotExistException - exception to handle the case where the listing passed to method is not
   * present in the Agent’s collection
   */
  @Override
  public void completeListing(Listing listing) throws ListingDoesNotExistException {
    if (!this.collectionOfTheirCurrentListing.contains(listing)) {
      throw new ListingDoesNotExistException("The listing is not included in the collection");
    }
    this.totalEarnings += this.getListingCommissionValue(listing);
    this.dropListing(listing);
  }

  /**
   * This method drops a listing from the Agent’s collection without adjusting their earnings. You may
   * decide how to handle the case where the listing passed to method is not present in the Agent’s collection.
   * @param listing - Generic Listing class, the agent's (appropriate) listing.
   * @throws ListingDoesNotExistException - exception to handle the case where the listing passed to method is not
   *  present in the Agent’s collection
   */
  @Override
  public void dropListing(Listing listing) throws ListingDoesNotExistException {
    if (this.collectionOfTheirCurrentListing.contains(listing))
      this.collectionOfTheirCurrentListing.remove(listing);
    else
      throw new ListingDoesNotExistException("The listing to be removed is not included in the collection");
  }

  /**
   * This method returns the amount of money the Agent would make if they successfully completed all
   * listings in their collection.
   * @return - returns the total value of the portfolio.
   */
  @Override
  public double getTotalPortfolioValue() {
    double totalValue = 0.0;
    for (Listing<C, P> listing: this.collectionOfTheirCurrentListing)
      totalValue += this.getListingCommissionValue(listing);
    return totalValue;
  }

  /**
   * Calculates the value of a listing commission.
   * @param listing - Generic Listing class, the agent's (appropriate) listing.
   * @return - returns the value of a listing commission.
   */
  private Double getListingCommissionValue(Listing listing) {
    return listing.getContract().getCommissionValue() * this.commissionRate;
  }

  /**
   * Gives the agent's name.
   * @return the name of the agent.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Gives the agent's current collection of listing.
   * @return - the agent's current collection of listing.
   */
  public ArrayList<Listing<C, P>> getCollectionOfTheirCurrentListing() {
    return this.collectionOfTheirCurrentListing;
  }

  /**
   * Gives the agent's commission rate.
   * @return - the agent's commission rate.
   */
  public Double getCommissionRate() {
    return this.commissionRate;
  }

  /**
   * Gives the agent's total earnings.
   * @return - the agent's total earnings.
   */
  public Double getTotalEarnings() {
    return this.totalEarnings;
  }
}

