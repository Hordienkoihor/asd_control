package exceptions;

public class BankTransferPaymentException extends RuntimeException {
    public BankTransferPaymentException(String message) {
        super(message);
    }

  public BankTransferPaymentException() {
    super();
  }
}
