package problem;

import java.util.Objects;

/**
 * represent a generic Listing containing a contract and property
 * @param <C> - Contract, a contract class object
 * @param <P> - AbstractProperty, a property class object
 */
public class Listing<C extends AbstractContract, P extends AbstractProperty> {

  private C contract;
  private P property;

  /**
   * Constructor for a Listing
   *
   * @param contract - Contract, represent listing's contract
   * @param property - AbstractProperty, represents listing's property
   */
  public Listing(C contract, P property) {
    this.contract = contract;
    this.property = property;
  }

  /**
   * @return - Contract,
   */
  public C getContract() {
    return this.contract;
  }

  /**
   * @return - Property
   */
  public P getProperty() {
    return this.property;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Listing)) {
      return false;
    }
    Listing<?, ?> listing = (Listing<?, ?>) o;
    return getContract().equals(listing.getContract()) && getProperty()
        .equals(listing.getProperty());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getContract(), getProperty());
  }

  @Override
  public String toString() {
    return "Listing{" +
        "contract=" + contract +
        ", property=" + property +
        '}';
  }
}