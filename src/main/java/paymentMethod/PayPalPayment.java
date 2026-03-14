package paymentMethod;

import domain.Money;
import exceptions.PayPalPaymentException;
import logger.LoggerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PayPalPayment implements PaymentMethodInt{
    private final static double BOTTOM_LIMIT = 600;
    private final static Logger logger = LoggerService.getLogger(PayPalPayment.class);


    @Override
    public void pay(Money sum) {
        if (sum == null) {
            throw new PayPalPaymentException("Payment details are missing");
        }

        double total = sum.getAmount();

        if (total < BOTTOM_LIMIT) {
            logger.warn("Payment denied. {} didn't reach floor: {}", total, BOTTOM_LIMIT);
            throw new PayPalPaymentException("Payment floor wasn't reached");
        }

        logger.info("PayPal payment processed with total {}", sum);
    }
}
