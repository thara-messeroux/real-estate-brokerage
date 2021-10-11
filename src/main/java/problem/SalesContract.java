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
   * @throws IllegalArgumentException
   */
  public SalesContract(Double askingPrice, Boolean isNegotiable) throws IllegalArgumentException {
    super(askingPrice, isNegotiable);
  }

  @Override
  protected Double getCommissionValue() {
    return super.getCommissionValue();
  }

  @Override
  public String toString() {
    return "Sales{" +
        "askingPrice=" + askingPrice +
        ", isNegotiable=" + isNegotiable +
        '}';
  }
}
