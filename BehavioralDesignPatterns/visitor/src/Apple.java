import java.math.BigDecimal;

public class Apple implements ShoppingCartElement {
    private BigDecimal pricePerKG;
    private BigDecimal weight;

    @Override
    public BigDecimal accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }

    public BigDecimal getPricePerKG() {
        return pricePerKG;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public Apple(BigDecimal pricePerKG, BigDecimal weight) {
        this.pricePerKG = pricePerKG;
        this.weight = weight;
    }


}
