import java.math.BigDecimal;

public class Bicycle implements ShoppingCartElement {
    private BigDecimal price;
    private BigDecimal discount;
    @Override
    public BigDecimal accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }

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
