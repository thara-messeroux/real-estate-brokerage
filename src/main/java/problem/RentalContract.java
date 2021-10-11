package problem;

import java.util.Objects;

/**
 * Represents a Rental contract
 */
public class RentalContract extends AbstractContract {

  private static final Integer ZERO = 0;
  private Integer termMonths;


  /**
   * Constructor for a Rental contract class
   *
   * @param askingPrice  - Double representing the contract's asking price
   * @param isNegotiable - Boolean, represents whether or not the asking price is negotiable
   * @param termMonths   - Integer, representing the length of the contract
   * @throws IllegalArgumentException if negative term is parsed
   */
  public RentalContract(Double askingPrice, Boolean isNegotiable, Integer termMonths)
      throws IllegalArgumentException {
    super(askingPrice, isNegotiable);
    this.termMonths = this.validTerm(termMonths);
  }

  /**
   * @return - Integer, representing the length of the contract
   */
  public Integer getTermMonths() {
    return this.termMonths;
  }

  /**
   * Sets termMonths - Integer, representing the length of the contract
   *
   * @param termMonths - Integer, representing the length of the contract
   */
  public void setTermMonths(Integer termMonths) {
    this.termMonths = this.validTerm(termMonths);
  }

  /**
   * validates if given term is non-negative
   *
   * @param term - Integer, term to validate
   * @return - Integer, term if valid
   * @throws IllegalArgumentException - Exception, thrown if term is negative
   */
  private Integer validTerm(Integer term) throws IllegalArgumentException {
    if (term < ZERO) {
      throw new IllegalArgumentException("Invalid term. Please enter a non-negative number!");
    }
    return term;
  }

  /**
   * Returns the commission value
   *
   * @return - Double, the commission value
   */
  @Override
  protected Double getCommissionValue() {
    return super.getCommissionValue() * this.termMonths;
  }

  /**
   * Evaluates whether an object is the same as a rental contract.
   *
   * @param o the object being compared to the rental contract.
   * @return true if the object is the same as the rental contract, false, otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RentalContract)) {
      return false;
    }
    RentalContract rental = (RentalContract) o;
    return getTermMonths().equals(rental.getTermMonths());
  }

  /**
   * Returns the integer hashcode representation of a rental contract.
   *
   * @return the integer hashcode representation of a rental contract.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getTermMonths());
  }

  /**
   * Returns a string describing a rental contract, with information about the asking price, whether
   * or not the price is negotiable and the terms in months.
   *
   * @return a string describing a rental contract.
   */
  @Override
  public String toString() {
    return "Rental{" +
        "askingPrice=" + askingPrice +
        ", isNegotiable=" + isNegotiable +
        ", termMonths=" + termMonths +
        '}';
  }
}
