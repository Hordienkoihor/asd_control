package paymentMethod;

import domain.Money;
import domain.Order;

public interface PaymentMethodInt {
    void pay(Money sum);

}
