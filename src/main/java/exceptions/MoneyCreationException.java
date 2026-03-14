package exceptions;

public class MoneyCreationException extends RuntimeException {
    public MoneyCreationException(String message) {
        super(message);
    }

  public MoneyCreationException() {
    super();
  }
}
