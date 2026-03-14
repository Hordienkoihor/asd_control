package processor;

import domain.Money;
import domain.Order;
import logger.LoggerService;
import org.slf4j.Logger;

public abstract class OrderProcessorTemplate {
    protected static final Logger logger = LoggerService.getLogger(OrderProcessorTemplate.class);

    public final void process(Order order) {
        validateOrder(order);

        Money total = order.getTotal();

        makePayment(total);

        logger.info("Order with id {} processed with total {}", order.getId() ,total);
    }

    protected abstract void validateOrder(Order order) ;

    protected abstract void makePayment(Money total) ;
}
