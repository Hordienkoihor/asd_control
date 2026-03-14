package paymentMethod;

import domain.Money;
import exceptions.BankTransferPaymentException;
import exceptions.PayPalPaymentException;
import logger.LoggerService;
import org.slf4j.Logger;

public class BankTransferPayment implements PaymentMethodInt{
    private final static double SUM_REACHED_FEE = 0.5;
    private final static double FEE = 2;
    private final static double SUM_REACHED = 50000;
    private final static Logger logger = LoggerService.getLogger(BankTransferPayment.class);


    @Override
    public void pay(Money sum) {
        if (sum == null) {
            throw new BankTransferPaymentException("Payment details are missing");
        }

        double total = sum.getAmount();

        if (total < SUM_REACHED_FEE) {
            logger.info("Bank transfer payment processed with total {}", sum.getAmount() * (1 - 0.02));
            return;
        }

        logger.info("PayPal payment processed with total {}", sum.getAmount() * (1 - 0.005));
    }
}
