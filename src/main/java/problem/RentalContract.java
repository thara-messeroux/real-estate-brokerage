package problem;

import java.util.Objects;

/**
 * represents a Rental contract
 */
public class RentalContract extends AbstractContract{

  private static final Integer ZERO = 0;
  private Integer termMonths;


  /**
   * Constructor for a Rental contract class
   *
   * @param askingPrice  - Double representing the contract's asking price
   * @param isNegotiable - Boolean, represents whether or not the asking price is negotiable
   * @param termMonths - Integer, representing the length of the contract
   * @throws IllegalArgumentException
   */
  public RentalContract(Double askingPrice, Boolean isNegotiable, Integer termMonths) throws IllegalArgumentException {
    super(askingPrice, isNegotiable);
    this.termMonths = validTerm(termMonths);
  }

  /**
   * @return - Integer, representing the length of the contract
   */
  public Integer getTermMonths() {
    return this.termMonths;
  }

  /**
   * validates if given term is non-negative
   * @param term - Integer, term to validate
   * @return - Integer, term if valid
   * @throws IllegalArgumentException - Exception, thrown if term is negative
   */
  private Integer validTerm (Integer term) throws IllegalArgumentException{
    if (term < ZERO) {
      throw new IllegalArgumentException("Invalid term. Please enter a non-negative number!");
    }
    return term;
  }

  @Override
  protected Double getCommissionValue() {
    return super.getCommissionValue() * this.termMonths;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof RentalContract)) return false;
    RentalContract rental = (RentalContract) o;
    return getTermMonths().equals(rental.getTermMonths());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getTermMonths());
  }

  @Override
  public String toString() {
    return "Rental{" +
        "askingPrice=" + askingPrice +
        ", isNegotiable=" + isNegotiable +
        ", termMonths=" + termMonths +
        '}';
  }
}
