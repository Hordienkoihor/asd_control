import domain.Money;
import domain.Order;
import domain.OrderItem;
import exceptions.BankTransferPaymentException;
import exceptions.CardPaymentException;
import exceptions.PayPalPaymentException;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import paymentMethod.BankTransferPayment;
import paymentMethod.CardPayment;
import paymentMethod.PayPalPayment;
import processor.OrderProcessor;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Tests {
    private OrderProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new OrderProcessor();
    }


    @ParameterizedTest
    @ValueSource(doubles = {600.0, 1000.0, 49999.99})
    void testPayPalSuccessParameterized(double amount) {
        PayPalPayment payPal = new PayPalPayment();
        assertDoesNotThrow(() -> payPal.pay(new Money(amount)));
    }

    @Test
    public void testProcessOrderViaPayPal() {
        Order order = new Order();
        order.add(new OrderItem("name", "description", new Money(1000)));
        assertDoesNotThrow(() -> processor.process(order));
    }

    @Test
    public void testProcessOrderViaBankTransfer() {
        Order order = new Order();
        order.add(new OrderItem("name", "description", new Money(500)));
        assertDoesNotThrow(() -> processor.process(order));
    }

    @Test
    public void testCardPaymentSuccess() {
        CardPayment cardPayment = new CardPayment();
        assertDoesNotThrow(() -> cardPayment.pay(new Money(40000)));
    }

    @Test
    public void testBankTransferSuccess() {
        BankTransferPayment bankPayment = new BankTransferPayment();
        assertDoesNotThrow(() -> bankPayment.pay(new Money(100)));
    }

    @Test
    public void testValidateOrderThrowsExceptionForExpensiveItem() {
        OrderItem expensiveItem = new OrderItem("name", "description", new Money(55000));
        Order order = new Order();
        order.add(expensiveItem);

        assertThrows(RuntimeException.class, () -> processor.process(order),
                "RuntimeException, якщо ціна товару >= 50000");
    }

    @Test
    public void testCardPaymentExceedsLimit() {
        CardPayment cardPayment = new CardPayment();
        assertThrows(CardPaymentException.class, () -> cardPayment.pay(new Money(45001)),
                "CardPaymentException при сумі > 45000");
    }

    @Test
    public void testPayPalFloorNotReached() {
        PayPalPayment payPal = new PayPalPayment();
        assertThrows(PayPalPaymentException.class, () -> payPal.pay(new Money(599)),
                "PayPalPaymentException при сумі < 600");
    }

    @Test
    public void testBankTransferNullSum() {
        BankTransferPayment bankPayment = new BankTransferPayment();
        assertThrows(BankTransferPaymentException.class, () -> bankPayment.pay(null),
                "BankTransferPaymentException для null");
    }

    @Test
    public void testPayPalNullSum() {
        PayPalPayment payPal = new PayPalPayment();
        assertThrows(PayPalPaymentException.class, () -> payPal.pay(null));
    }

}
