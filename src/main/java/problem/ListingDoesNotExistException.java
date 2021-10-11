package problem;

/**
 * Exception ListingDoesNotExistException class. That exception is thrown when the parsed listing
 * does not included in the collection.
 */
public class ListingDoesNotExistException extends Exception {

  public ListingDoesNotExistException(String message) {
    super(message);
  }
}
