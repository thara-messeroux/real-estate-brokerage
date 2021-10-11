package problem;

import java.util.Objects;

public class ResidentialProperty extends AbstractProperty{

  private Integer numBedrooms; // non-negative integer
  private Double numBathrooms; // non-negative double

  public ResidentialProperty(String address, Integer size, Integer numBedrooms,
      Double numBathrooms) {
    super(address, size);
    this.numBedrooms = validInteger(numBedrooms);
    this.numBathrooms = validDouble(numBathrooms);
  }

  public Integer getNumBedrooms() {
    return this.numBedrooms;
  }

  public void setNumBedrooms(Integer numBedrooms) {
    this.numBedrooms = numBedrooms;
  }

  public Double getNumBathrooms() {
    return this.numBathrooms;
  }

  public void setNumBathrooms(Double numBathrooms) {
    this.numBathrooms = numBathrooms;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResidentialProperty that = (ResidentialProperty) o;
    return numBedrooms.equals(that.numBedrooms) && numBathrooms.equals(that.numBathrooms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numBedrooms, numBathrooms);
  }

  @Override
  public String toString() {
    return "ResidentialProperties{" +
        "numBedrooms=" + numBedrooms +
        ", numBathrooms=" + numBathrooms +
        '}';
  }

  private Double validDouble(Double number){
    if (number < ZERO) {
      throw new IllegalArgumentException("Invalid Number of Bathrooms. Please enter a non-negative number!");
    }
    return number;
  }
}
