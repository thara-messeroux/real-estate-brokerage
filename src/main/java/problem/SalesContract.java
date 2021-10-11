package problem;

/**
 * represents a Sales contract
 */
public class SalesContract extends AbstractContract{

  /**
   * Constructor for a Sales contract class
   *
   * @param askingPrice  - Double representing the contract's asking price
   * @param isNegotiable - Boolean, representing whether or not the asking price is negotiable
   * @throws IllegalArgumentException if negative asking price is parsed
   */
  public SalesContract(Double askingPrice, Boolean isNegotiable) throws IllegalArgumentException {
    super(askingPrice, isNegotiable);
  }

  @Override
  protected Double getCommissionValue() {
    return super.getCommissionValue();
  }

  /**
   * Returns a string describing a sales contract, with information about the asking price, and whether or not the price is negotiable.
   * @return a string describing a sales contract.
   */
  @Override
  public String toString() {
    return "Sales{" +
        "askingPrice=" + askingPrice +
        ", isNegotiable=" + isNegotiable +
        '}';
  }
}
