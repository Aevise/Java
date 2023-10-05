package java8;

import java.math.BigDecimal;

@FunctionalInterface
public interface ShoppingCartVisitor {


    BigDecimal visit(ShoppingCartElement element);

}
