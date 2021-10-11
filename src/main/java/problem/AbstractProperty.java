package problem;

import java.util.Objects;

/**
 * Abstract class AbstractProperty, that holds address and the size of the property.
 */
public abstract class AbstractProperty {

  protected static final int ZERO = 0;
  private String address;
  private Integer size;

  /**
   * Constructor of the AbstractProperty class
   *
   * @param address - String, address of the property
   * @param size    - Integer, the size of the property
   */
  public AbstractProperty(String address, Integer size) {
    this.address = address;
    this.size = this.validSize(size);
  }

  /**
   * Returns the address - String, address of the property
   *
   * @return address - String, address of the property
   */
  public String getAddress() {
    return this.address;
  }

  /**
   * Sets the address - String, address of the property
   *
   * @param address - String, address of the property
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * Returns the size - Integer, the size of the property
   *
   * @return size - Integer, the size of the property
   */
  public Integer getSize() {
    return this.size;
  }

  /**
   * Sets the size - Integer, the size of the property
   *
   * @param size - Integer, the size of the property
   */
  public void setSize(Integer size) {
    this.size = this.validSize(size);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractProperty)) {
      return false;
    }
    AbstractProperty that = (AbstractProperty) o;
    return getAddress().equals(that.getAddress()) && getSize().equals(that.getSize());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getAddress(), getSize());
  }

  @Override
  public String toString() {
    return "AbstractProperty{" +
        "Address='" + address + '\'' +
        ", Size=" + size +
        '}';
  }

  /**
   * Method that checks if the size is non-negative, throws the IllegalArgumentException otherwise.
   *
   * @param size - Integer, the size of the property
   * @return the size, Integer the size of the property if the size is greater than zero
   * @throws IllegalArgumentException if the parsed size is negative
   */
  private Integer validSize(Integer size) throws IllegalArgumentException {
    if (size < ZERO) {
      throw new IllegalArgumentException("Invalid size. Please enter a non-negative number!");
    }
    return size;
  }
}

