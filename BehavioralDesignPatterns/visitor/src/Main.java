import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ShoppingCartElement> elements = List.of(
                new Bicycle(BigDecimal.valueOf(1279), BigDecimal.TEN),
                new Apple(BigDecimal.valueOf(2.5), BigDecimal.valueOf(43))
        );

        ShoppingCartVisitor shoppingCartVisitor = new ShoppingCartVisitorImpl();
        BigDecimal result = elements.stream()
                .map(element -> element.accept(shoppingCartVisitor))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total price: " + result);
    }
}
