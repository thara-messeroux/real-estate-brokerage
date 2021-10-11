package problem;

import static org.junit.Assert.*;

import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class ResidentialPropertyTest {

  ResidentialProperty testResidentialProperty;
  Integer numBedrooms;
  Double numBathrooms;
  String address;
  Integer size;

  ResidentialProperty testResidentialProperty2;
  Integer numBedrooms2;
  Double numBathrooms2;
  String address2;
  Integer size2;


  @Before
  public void setUp() throws Exception {
    numBedrooms = 2;
    numBathrooms = 1.5;
    address = "Seattle";
    size = 70;

    numBedrooms2 = 5;
    numBathrooms2 = 3.0;

    testResidentialProperty = new ResidentialProperty(address, size, numBedrooms, numBathrooms);
  }

  @Test
  public void getNumBedrooms() {
    assertEquals(numBedrooms, testResidentialProperty.getNumBedrooms());
  }

  @Test
  public void setNumBedrooms() {
    testResidentialProperty.setNumBedrooms(numBedrooms2);
    assertEquals(numBedrooms2, testResidentialProperty.getNumBedrooms());
  }

  @Test
  public void getNumBathrooms() {
    assertEquals(numBathrooms, testResidentialProperty.getNumBathrooms());
  }

  @Test
  public void setNumBathrooms() {
    testResidentialProperty.setNumBathrooms(numBathrooms2);
    assertEquals(numBathrooms2, testResidentialProperty.getNumBathrooms());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeNumBedrooms() throws IllegalArgumentException {
    testResidentialProperty.setNumBedrooms(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeNumBathrooms() throws IllegalArgumentException {
    testResidentialProperty.setNumBathrooms(-2.0);
  }

  @Test
  public void testEquals() {
    assertTrue(testResidentialProperty.equals(testResidentialProperty));
    assertFalse(testResidentialProperty.equals(testResidentialProperty.getNumBathrooms()));
    testResidentialProperty2 = new ResidentialProperty(address, size, numBedrooms, numBathrooms);
    assertTrue(testResidentialProperty.equals(testResidentialProperty2));
    testResidentialProperty2.setNumBedrooms(numBedrooms2);
    assertFalse(testResidentialProperty.equals(testResidentialProperty2));
    testResidentialProperty2 = new ResidentialProperty(address, size, numBedrooms, numBathrooms);
    testResidentialProperty2.setNumBathrooms(numBathrooms2);
    assertFalse(testResidentialProperty.equals(testResidentialProperty2));
  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash(Objects.hash(address, size), numBedrooms, numBathrooms);
    assertEquals(hash, testResidentialProperty.hashCode());
  }

  @Test
  public void testToString() {
    String toString = "ResidentialProperty{" +
        "numBedrooms=" + numBedrooms +
        ", numBathrooms=" + numBathrooms +
        "} " + "AbstractProperty{" +
        "Address='" + address + '\'' +
        ", Size=" + size +
        '}';
    assertEquals(toString, testResidentialProperty.toString());
  }
}