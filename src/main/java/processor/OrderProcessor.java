package processor;

import domain.Money;
import domain.Order;
import domain.OrderItem;
import paymentMethod.BankTransferPayment;
import paymentMethod.PayPalPayment;
import paymentMethod.PaymentMethodInt;

import java.util.List;

public class OrderProcessor extends OrderProcessorTemplate{
    @Override
    protected void validateOrder(Order order) {
        List<OrderItem> items = order.getItems();

        for (OrderItem item : items) {
            if (item.getPrice().getAmount() >= 50000) {
                logger.warn("Order processing error: item price is greater than 50000");
                throw new RuntimeException("Order processing error: item price is greater than 50000");
            }
        }
    }

    @Override
    protected void makePayment(Money total) {
        if (total.getAmount() < 600) {
            BankTransferPayment bankTransferPayment = new BankTransferPayment();
            bankTransferPayment.pay(total);
        } else {
            PaymentMethodInt paymentMethod = new PayPalPayment();
            paymentMethod.pay(total);
        }
    }
}
