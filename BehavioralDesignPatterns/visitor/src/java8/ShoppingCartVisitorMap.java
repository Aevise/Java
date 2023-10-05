package java8;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.function.Function;

public class ShoppingCartVisitorMap implements Function<Class<? extends ShoppingCartElement>, ShoppingCartVisitor> {

    private static final Map<Class<? extends ShoppingCartElement>, ? extends ShoppingCartVisitor> VISITORS = Map.of(
            Apple.class, element -> visit((Apple) element),
            Bicycle.class, element -> visit((Bicycle) element)
    );

    private static BigDecimal visit(final Apple apple){
        BigDecimal totalCost = apple.getWeight().multiply(apple.getPricePerKG());
        System.out.println("Calculated apple cost: " + totalCost);
        return totalCost;
    }

    private static BigDecimal visit(final Bicycle apple){
        BigDecimal totalCost = apple.getPrice().subtract(apple.getDiscount());
        System.out.println("Calculated bicycle cost: " + totalCost);
        return totalCost;
    }

    @Override
    public ShoppingCartVisitor apply(Class<? extends ShoppingCartElement> aClass) {
        return VISITORS.get(aClass);

    }

}
