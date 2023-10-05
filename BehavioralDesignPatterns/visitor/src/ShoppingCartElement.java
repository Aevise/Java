import java.math.BigDecimal;

public interface ShoppingCartElement {
    BigDecimal accept(ShoppingCartVisitor visitor);
}
