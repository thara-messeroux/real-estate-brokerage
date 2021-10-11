package problem;

import java.util.Objects;

/**
 * Abstract Class Contract
 */
public abstract class AbstractContract {

  private static final Double ZERO = 0.0;
  protected Double askingPrice;
  protected Boolean isNegotiable;

  /**
   * Constructor for class AbstractContract
   *
   * @param askingPrice  - Double representing the contract's asking price
   * @param isNegotiable - Boolean, representing whether or not the asking price is negotiable
   * @throws IllegalArgumentException if negative asking price is parsed
   */
  public AbstractContract(Double askingPrice, Boolean isNegotiable)
      throws IllegalArgumentException {
    this.isNegotiable = isNegotiable;
    this.askingPrice = this.validAskingPrice(askingPrice);
  }

  /**
   * @return - Double representing the contract's asking price
   */
  public Double getAskingPrice() {
    return this.askingPrice;
  }

  /**
   * @return - Boolean, indicating whether or not the asking price is negotiable
   */
  public Boolean getNegotiable() {
    return this.isNegotiable;
  }

  /**
   * Validates if the given askingPrice is non-zero
   *
   * @param askingPrice - Double, asking price to validate
   * @return Double - asking price if valid
   */
  private Double validAskingPrice(Double askingPrice) throws IllegalArgumentException {
    if (askingPrice < ZERO) {
      throw new IllegalArgumentException("Invalid Price. Please enter a non-negative number!");
    }
    return askingPrice;
  }

  /**
   * Returns the commission value which is equal to the asking price
   *
   * @return commission value - Double, the commission value
   */
  protected Double getCommissionValue() {
    return this.askingPrice;
  }

  /**
   * Sets the askingPrice - Double representing the contract's asking price
   *
   * @param askingPrice - Double representing the contract's asking price
   */
  public void setAskingPrice(Double askingPrice) {
    this.askingPrice = this.validAskingPrice(askingPrice);
  }

  /**
   * Sets the isNegotiable - Boolean, representing whether or not the asking price is negotiable
   *
   * @param negotiable - Boolean, representing whether or not the asking price is negotiable
   */
  public void setNegotiable(Boolean negotiable) {
    this.isNegotiable = negotiable;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof AbstractContract)) return false;
    AbstractContract that = (AbstractContract) o;
    return getAskingPrice().equals(that.getAskingPrice()) && isNegotiable.equals(that.isNegotiable);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getAskingPrice(), isNegotiable);
  }

  @Override
  public String toString() {
    return "AbstractContract{" +
        "askingPrice=" + askingPrice +
        ", isNegotiable=" + isNegotiable +
        '}';
  }
}
