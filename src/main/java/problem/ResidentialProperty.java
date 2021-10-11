package problem;

import java.util.Objects;

/**
 * Simple class ResidentialProperty that holds non-negative Integer - number of bedrooms and
 * non-negative Double, number of bathrooms. Also inherits from the class AbstractProperty.
 */
public class ResidentialProperty extends AbstractProperty {

  private Integer numBedrooms;
  private Double numBathrooms;

  /**
   * Constructor of the ResidentialProperty object.
   *
   * @param address      - String, address of the property
   * @param size         - Integer, the size of the property
   * @param numBedrooms  - Integer(non-negative), the number of bedrooms
   * @param numBathrooms - Double(non-negative), the number of bathrooms
   */
  public ResidentialProperty(String address, Integer size, Integer numBedrooms,
      Double numBathrooms) {
    super(address, size);
    this.numBedrooms = this.validBedrooms(numBedrooms);
    this.numBathrooms = this.validBathrooms(numBathrooms);
  }

  /**
   * Returns the numBedrooms - Integer(non-negative), the number of bedrooms
   *
   * @return numBedrooms - Integer(non-negative), the number of bedrooms
   */
  public Integer getNumBedrooms() {
    return this.numBedrooms;
  }

  /**
   * Sets the numBedrooms - Integer(non-negative), the number of bedrooms
   *
   * @param numBedrooms - Integer(non-negative), the number of bedrooms
   */
  public void setNumBedrooms(Integer numBedrooms) {
    this.numBedrooms = this.validBedrooms(numBedrooms);
  }

  /**
   * Returns the numBathrooms - Double(non-negative), the number of bathrooms
   *
   * @return numBathrooms - Double(non-negative), the number of bathrooms
   */
  public Double getNumBathrooms() {
    return this.numBathrooms;
  }

  /**
   * Sets the numBathrooms - Double(non-negative), the number of bathrooms
   *
   * @param numBathrooms - Double(non-negative), the number of bathrooms
   */
  public void setNumBathrooms(Double numBathrooms) {
    this.numBathrooms = this.validBathrooms(numBathrooms);
  }

  /**
   * Evaluates whether an object is the same as a residential property.
   *
   * @param o the object being compared to the residential property.
   * @return true if the object is the same as the residential property, false, otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ResidentialProperty)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    ResidentialProperty that = (ResidentialProperty) o;
    return getNumBedrooms().equals(that.getNumBedrooms()) && getNumBathrooms()
        .equals(that.getNumBathrooms());
  }

  /**
   * Returns the integer hashcode representation of a residential property.
   *
   * @return the integer hashcode representation of a residential property.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getNumBedrooms(), getNumBathrooms());
  }

  /**
   * Returns a string describing a residential property, with information about the number of
   * bedrooms and bathrooms.
   *
   * @return a string describing a residential property.
   */
  @Override
  public String toString() {
    return "ResidentialProperty{" +
        "numBedrooms=" + numBedrooms +
        ", numBathrooms=" + numBathrooms +
        "} " + super.toString();
  }

  /**
   * Method that checks if the number of bathrooms is non-negative, throws the
   * IllegalArgumentException otherwise.
   *
   * @param bathrooms - Double(non-negative), the number of bathrooms
   * @return bathrooms - Double(non-negative), the number of bathrooms
   * @throws IllegalArgumentException if the parsed number of bathrooms is negative
   */
  private Double validBathrooms(Double bathrooms) throws IllegalArgumentException {
    if (bathrooms < ZERO) {
      throw new IllegalArgumentException(
          "Invalid Number of bathrooms. Please enter a non-negative number!");
    }
    return bathrooms;
  }

  /**
   * Method that checks if the number of bedrooms is non-negative, throws the
   * IllegalArgumentException otherwise.
   *
   * @param bedrooms - Integer(non-negative), the number of bedrooms
   * @return bedrooms - Integer(non-negative), the number of bedrooms
   * @throws IllegalArgumentException if the parsed number of bedrooms is negative
   */
  private Integer validBedrooms(Integer bedrooms) throws IllegalArgumentException {
    if (bedrooms < ZERO) {
      throw new IllegalArgumentException("Invalid number of bedrooms. Please enter a non-negative "
          + "number!");
    }
    return bedrooms;
  }
}
