import java.math.BigDecimal;

public interface ShoppingCartVisitor {


    BigDecimal visit(Bicycle bicycle);

    BigDecimal visit(Apple apple);
}
