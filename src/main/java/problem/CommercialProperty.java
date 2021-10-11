package problem;

import java.util.Objects;

public class CommercialProperty extends AbstractProperty{

  private Integer numOffices; // non-negative integer
  private Boolean isSuitableForRetail;

  public CommercialProperty(String address, Integer size, Integer numOffices,
      Boolean isSuitableForRetail) {
    super(address, size);
    this.numOffices = validInteger(numOffices);
    this.isSuitableForRetail = isSuitableForRetail;
  }

  public Integer getNumOffices() {
    return this.numOffices;
  }

  public void setNumOffices(Integer numOffices) {
    this.numOffices = numOffices;
  }

  public Boolean getSuitableForRetail() {
    return this.isSuitableForRetail;
  }

  public void setSuitableForRetail(Boolean suitableForRetail) {
    isSuitableForRetail = suitableForRetail;
  }

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

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getNumOffices(), isSuitableForRetail);
  }

  @Override
  public String toString() {
    return "CommercialProperties{" +
        "numOffices=" + numOffices +
        ", isSuitableForRetail=" + isSuitableForRetail +
        "} " + super.toString();
  }
}
