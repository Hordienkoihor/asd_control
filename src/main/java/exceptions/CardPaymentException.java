package exceptions;

public class CardPaymentException extends RuntimeException {
    public CardPaymentException(String message) {
        super(message);
    }

  public CardPaymentException() {
    super();
  }
}
