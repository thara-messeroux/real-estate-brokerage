package problem;

import java.util.Objects;

public abstract class AbstractProperty {

  protected static final int ZERO = 0;
  private String address;
  private Integer size; // (non-negative)

  public AbstractProperty(String address, Integer size) {
    this.address = address;
    this.size = this.validInteger(size);
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Integer getSize() {
    return this.size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractProperty that = (AbstractProperty) o;
    return address.equals(that.address) && size.equals(that.size);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, size);
  }

  @Override
  public String toString() {
    return "AbstractProperty{" +
        "Address='" + address + '\'' +
        ", Size=" + size +
        '}';
  }

  protected Integer validInteger(Integer number) throws IllegalArgumentException{
    if (number < ZERO) {
      throw new IllegalArgumentException("Invalid Argument. Please enter a non-negative number!");
    }
    return number;
  }
}

