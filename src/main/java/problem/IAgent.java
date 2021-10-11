package problem;

public interface IAgent<C extends AbstractContract, P extends AbstractProperty> {

  void addListing(Listing<C, P> listing);

  void completeListing(Listing<C, P> listing) throws ListingDoesNotExistException;

  void dropListing(Listing<C, P> listing) throws ListingDoesNotExistException;

  double getTotalPortfolioValue();

}
