package exceptions;

public class MoneySettingException extends RuntimeException {
    public MoneySettingException(String message) {
        super(message);
    }

  public MoneySettingException() {
    super();
  }
}
