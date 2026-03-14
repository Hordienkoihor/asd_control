package exceptions;

public class PayPalPaymentException extends RuntimeException {
    public PayPalPaymentException(String message) {
        super(message);
    }

  public PayPalPaymentException() {
    super();
  }
}
