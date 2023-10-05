package java8;

import java.math.BigDecimal;

public class Bicycle implements ShoppingCartElement {
    private BigDecimal price;
    private BigDecimal discount;

    public Bicycle(BigDecimal price, BigDecimal discount) {
        this.price = price;
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }
}
