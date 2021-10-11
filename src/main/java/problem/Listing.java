package problem;

import java.util.Objects;

/**
 * Represents a generic Listing containing a contract and property.
 *
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
   * @return - Contract
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

  /**
   * Sets the contract - Contract, represent listing's contract
   *
   * @param contract - Contract, represent listing's contract
   */
  public void setContract(C contract) {
    this.contract = contract;
  }

  /**
   * Sets the property - AbstractProperty, represents listing's property
   *
   * @param property - AbstractProperty, represents listing's property
   */
  public void setProperty(P property) {
    this.property = property;
  }
  
  /**
   * Evaluates whether an object is the same as a listing.
   *
   * @param o the object being compared to the listing.
   * @return true if the object is the same as the listing, false, otherwise.
   */
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
  
  /**
   * Returns the integer hashcode representation of a listing.
   *
   * @return the integer hashcode representation of a listing.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getContract(), getProperty());
  }
  
  /**
   * Returns a string describing a listing, with information about the contract
   * and property.
   *
   * @return a string describing a listing.
   */
  @Override
  public String toString() {
    return "Listing{" +
        "contract=" + contract +
        ", property=" + property +
        '}';
  }
}