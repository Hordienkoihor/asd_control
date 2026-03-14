package domain;

public class OrderItem {
    private final long id;
    private static long orderItemIdCounter = 1;
    private String name;
    private String description;
    private Money price;

    public OrderItem(String name, String description, Money price) {
        this.id = orderItemIdCounter++;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }
}


