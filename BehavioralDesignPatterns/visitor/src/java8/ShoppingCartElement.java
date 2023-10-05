package java8;

import java.math.BigDecimal;

public interface ShoppingCartElement {
    default BigDecimal accept(ShoppingCartVisitor visitor){
        return visitor.visit(this);
    }
}
