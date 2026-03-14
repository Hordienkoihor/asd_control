package domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static long orderIdCounter = 1;

    private long id;
    private final List<OrderItem> items = new ArrayList<>();

    public void add(OrderItem item) {
        this.items.add(item);
    }

    public void remove(OrderItem item) {
        this.items.remove(item);
    }

    public Money getTotal() {
        double total = items
                .stream()
                .mapToDouble(orderItem -> orderItem.getPrice().getAmount())
                .sum();

        return new Money(total);
    }

    public long getId() {
        return id;
    }

    public List<OrderItem> getItems() {
        return new ArrayList<>(items);
    }
}
