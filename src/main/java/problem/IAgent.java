package problem;

/**
 * IAgent is the interface that holds of the agent methods.
 *
 * @param <C> - Abstract Contract class generic extension.
 * @param <P> - Abstract Property class generic extension.
 */
public interface IAgent<C extends AbstractContract, P extends AbstractProperty> {

  /**
   * This method adds an (appropriate) listing to the Agent’s current listing collection.
   *
   * @param listing - Generic Listing class, the agent's (appropriate) listing.
   */
  void addListing(Listing<C, P> listing) throws ListingDoesNotExistException;

  /**
   * This method will be called when an Agent successfully makes a sale / rental of one of their
   * listings. Assuming the listing is part of their collection, this method should remove the
   * Listing from their collection and add their commission earnings to their total earnings
   * amount.
   *
   * @param listing - Generic Listing class, the agent's (appropriate) listing.
   * @throws ListingDoesNotExistException - exception to handle the case where the listing passed to
   *                                      method is not present in the Agent’s collection
   */
  void completeListing(Listing<C, P> listing) throws ListingDoesNotExistException;

  /**
   * This method drops a listing from the Agent’s collection without adjusting their earnings. You
   * may decide how to handle the case where the listing passed to method is not present in the
   * Agent’s collection.
   *
   * @param listing - Generic Listing class, the agent's (appropriate) listing.
   * @throws ListingDoesNotExistException - exception to handle the case where the listing passed to
   *                                      method is not present in the Agent’s collection
   */
  void dropListing(Listing<C, P> listing) throws ListingDoesNotExistException;

  /**
   * This method returns the amount of money the Agent would make if they successfully completed all
   * listings in their collection.
   *
   * @return - returns the total value of the portfolio.
   */
  Double getTotalPortfolioValue();

}
