package problem;

import static org.junit.Assert.*;

import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class CommercialPropertyTest {

  CommercialProperty testCommercialProperty;
  Integer numOffices;
  Boolean isSuitableForRetail;
  String address;
  Integer size;

  CommercialProperty testCommercialProperty2;
  Integer numOffices2;
  Boolean isSuitableForRetail2;
  String address2;
  Integer size2;

  @Before
  public void setUp() throws Exception {
    numOffices = 5;
    isSuitableForRetail = true;
    address = "Seattle";
    size = 250;
    numOffices2 = 1;
    isSuitableForRetail2 = false;
    address2 = "Boston";
    size2 = 70;

    testCommercialProperty = new CommercialProperty(address, size, numOffices,
        isSuitableForRetail);
    testCommercialProperty2 = new CommercialProperty(address2, size2, numOffices2,
        isSuitableForRetail2);
  }

  @Test
  public void getNumOffices() {
    assertEquals(numOffices, testCommercialProperty.getNumOffices());
  }

  @Test
  public void setNumOffices() {
    testCommercialProperty.setNumOffices(numOffices2);
    assertEquals(numOffices2, testCommercialProperty.getNumOffices());
  }

  @Test
  public void getSuitableForRetail() {
    assertEquals(isSuitableForRetail, testCommercialProperty.getSuitableForRetail());
  }

  @Test
  public void setSuitableForRetail() {
    testCommercialProperty.setSuitableForRetail(isSuitableForRetail2);
    assertEquals(isSuitableForRetail2, testCommercialProperty.getSuitableForRetail());
  }

  @Test
  public void getAddress() {
    assertEquals(address, testCommercialProperty.getAddress());
  }

  @Test
  public void setAddress() {
    testCommercialProperty.setAddress(address2);
    assertEquals(address2, testCommercialProperty.getAddress());
  }

  @Test
  public void getSize() {
    assertEquals(size, testCommercialProperty.getSize());
  }

  @Test
  public void setSize() {
    testCommercialProperty.setSize(size2);
    assertEquals(size2, testCommercialProperty.getSize());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeNumOfOffices() throws IllegalArgumentException {
    testCommercialProperty.setNumOffices(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeSize() throws IllegalArgumentException {
    testCommercialProperty.setSize(-100);
  }

  @Test
  public void testEquals() {
    assertTrue(testCommercialProperty.equals(testCommercialProperty));
    assertFalse(testCommercialProperty.equals(testCommercialProperty.getAddress()));
    testCommercialProperty2 = new CommercialProperty(address, size, numOffices,
        isSuitableForRetail);
    assertTrue(testCommercialProperty.equals(testCommercialProperty2));
    testCommercialProperty2.setAddress(address2);
    assertFalse(testCommercialProperty.equals(testCommercialProperty2));
    testCommercialProperty2 = new CommercialProperty(address, size, numOffices,
        isSuitableForRetail);
    testCommercialProperty2.setSize(size2);
    assertFalse(testCommercialProperty.equals(testCommercialProperty2));
    testCommercialProperty2 = new CommercialProperty(address, size, numOffices,
        isSuitableForRetail);
    testCommercialProperty2.setNumOffices(numOffices2);
    assertFalse(testCommercialProperty.equals(testCommercialProperty2));
    testCommercialProperty2 = new CommercialProperty(address, size, numOffices,
        isSuitableForRetail);
    testCommercialProperty2.setSuitableForRetail(isSuitableForRetail2);
    assertFalse(testCommercialProperty.equals(testCommercialProperty2));
  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash(Objects.hash(address, size), numOffices, isSuitableForRetail);
    assertEquals(hash, testCommercialProperty.hashCode());
  }

  @Test
  public void testToString() {
    String toString = "CommercialProperties{" +
        "numOffices=" + numOffices +
        ", isSuitableForRetail=" + isSuitableForRetail +
        "} " + "AbstractProperty{" +
        "Address='" + address + '\'' +
        ", Size=" + size +
        '}';
    assertEquals(toString, testCommercialProperty.toString());
  }
}