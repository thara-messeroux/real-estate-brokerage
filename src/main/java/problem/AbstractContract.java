package problem;

/**
 * abstract class Contract
 */
public abstract class AbstractContract {

  private static final Double ZERO = 0.0;
  protected Double askingPrice; //non-negative double
  protected Boolean isNegotiable;

  /**
   * Constructor for class AbstractContract
   * @param askingPrice - Double representing the contract's asking price
   * @param isNegotiable - Boolean, representing whether or not the asking price is negotiable
   * @throws IllegalArgumentException
   */
  public AbstractContract(Double askingPrice, Boolean isNegotiable) throws IllegalArgumentException {
    this.isNegotiable = isNegotiable;
    this.askingPrice = validAskingPrice(askingPrice);

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
   * @param askingPrice - Double, asking price to validate
   * @return Double - asking price if valid
   */
  private Double validAskingPrice(Double askingPrice) throws IllegalArgumentException{
    if (askingPrice < ZERO) {
      throw new IllegalArgumentException("Invalid Price. Please enter a non-negative number!");
    }
    return askingPrice;
  }

  protected Double getCommissionValue() {
    return this.askingPrice;
  }

}
