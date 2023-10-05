package java8;

import java.math.BigDecimal;

public class Apple implements ShoppingCartElement {
    private BigDecimal pricePerKG;
    private BigDecimal weight;


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
