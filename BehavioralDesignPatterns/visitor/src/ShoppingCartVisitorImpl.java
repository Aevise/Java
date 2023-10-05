import java.math.BigDecimal;
import java.math.RoundingMode;

public class ShoppingCartVisitorImpl implements ShoppingCartVisitor {
    @Override
    public BigDecimal visit(Bicycle bicycle) {
        BigDecimal bicyclePrice = bicycle.getPrice().divide(bicycle.getDiscount(), RoundingMode.HALF_UP);
        System.out.println("bicyclePrice: " + bicyclePrice);
        return bicyclePrice;
    }

    @Override
    public BigDecimal visit(Apple apple) {
        BigDecimal applePrice = apple.getPricePerKG().multiply(apple.getWeight());
        System.out.println("applePrice: " + applePrice);
        return applePrice;
    }
}
