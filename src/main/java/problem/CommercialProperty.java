package problem;

import java.util.Objects;

/**
 * Simple class CommercialProperty that holds non-negative number of offices and boolean flag
 * indicating whether or not the property is suitable for retail. Also inherits from the class
 * AbstractProperty.
 */
public class CommercialProperty extends AbstractProperty {

  private Integer numOffices;
  private Boolean isSuitableForRetail;

  /**
   * Constructor of the CommercialProperty object.
   *
   * @param address             - String, address of the property
   * @param size                - Integer, the size of the property
   * @param numOffices          - Integer (non-negative), number of offices in the commercial
   *                            property
   * @param isSuitableForRetail - Boolean, flag indicating whether or not the property is suitable
   *                            for retail
   */
  public CommercialProperty(String address, Integer size, Integer numOffices,
      Boolean isSuitableForRetail) {
    super(address, size);
    this.numOffices = this.validNumOffices(numOffices);
    this.isSuitableForRetail = isSuitableForRetail;
  }

  /**
   * Returns the numOffices - Integer (non-negative), number of offices in the commercial property
   *
   * @return numOffices - Integer (non-negative), number of offices in the commercial property
   */
  public Integer getNumOffices() {
    return this.numOffices;
  }

  /**
   * Sets the numOffices - Integer (non-negative), number of offices in the commercial property
   *
   * @param numOffices - Integer (non-negative), number of offices in the commercial property
   */
  public void setNumOffices(Integer numOffices) {
    this.numOffices = this.validNumOffices(numOffices);
  }

  /**
   * Returns isSuitableForRetail - Boolean, flag indicating whether or not the property is suitable
   * for retail
   *
   * @return isSuitableForRetail - Boolean, flag indicating whether or not the property is suitable
   * for retail
   */
  public Boolean getSuitableForRetail() {
    return this.isSuitableForRetail;
  }

  /**
   * Sets the isSuitableForRetail - Boolean, flag indicating whether or not the property is suitable
   * for retail
   *
   * @param suitableForRetail - Boolean, flag indicating whether or not the property is suitable for
   *                          retail
   */
  public void setSuitableForRetail(Boolean suitableForRetail) {
    isSuitableForRetail = suitableForRetail;
  }

  /**
   * Evaluates whether an object is the same as a commercial property.
   *
   * @param o the object being compared to the commercial property.
   * @return true if the object is the same as the commercial property, false, otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CommercialProperty)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    CommercialProperty that = (CommercialProperty) o;
    return getNumOffices().equals(that.getNumOffices()) && isSuitableForRetail
        .equals(that.isSuitableForRetail);
  }

  /**
   * Returns the integer hashcode representation of a commercial property.
   *
   * @return the integer hashcode representation of a commercial property.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getNumOffices(), isSuitableForRetail);
  }

  /**
   * Returns a string describing a commercial property, with information about the number of offices
   * and whether or not they are suitable for retail.
   *
   * @return a string describing a commercial property.
   */
  @Override
  public String toString() {
    return "CommercialProperties{" +
        "numOffices=" + numOffices +
        ", isSuitableForRetail=" + isSuitableForRetail +
        "} " + super.toString();
  }

  /**
   * Method that checks if the number of offices is non-negative, throws the
   * IllegalArgumentException otherwise.
   *
   * @param numOffices - Integer (non-negative), number of offices in the commercial property
   * @return numOffices - Integer (non-negative), number of offices in the commercial property
   * @throws IllegalArgumentException if the parsed number of offices is negative
   */
  private Integer validNumOffices(Integer numOffices) throws IllegalArgumentException {
    if (numOffices < ZERO) {
      throw new IllegalArgumentException("Invalid number of offices. Please enter a non-negative "
          + "number!");
    }
    return numOffices;
  }
}
