package paymentMethod;

import domain.Money;
import exceptions.CardPaymentException;
import logger.LoggerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CardPayment implements PaymentMethodInt {
    private final static double LIMIT = 45000;
    private static final Logger logger = LoggerService.getLogger(CardPayment.class);

    @Override
    public void pay(Money sum) {
        if (sum == null) {
            throw new CardPaymentException("Payment details are missing");
        }

        double total = sum.getAmount();

        if (total > LIMIT) {
            logger.warn("Card payment denied. {} exceeded limit: {}", total, LIMIT);
            throw new CardPaymentException("Payment limit exceeded");
        }

        logger.info("Card payment processed with total {}", sum);
    }
}
