package java8;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        List<ShoppingCartElement> elements = List.of(
                new Bicycle(BigDecimal.valueOf(1279), BigDecimal.TEN),
                new Apple(BigDecimal.valueOf(2.5), BigDecimal.valueOf(43))
        );

        ShoppingCartVisitorMap shoppingCartVisitorMap = new ShoppingCartVisitorMap();
        BigDecimal result = elements.stream()
                .map(element -> element.accept(shoppingCartVisitorMap.apply(element.getClass())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total price: " + result);
    }
}
