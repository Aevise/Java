package generic;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        UnaryOperator<String> textHandler = (String input) -> input.replace("hehe", "not hehe");
        Function<String, String> pipeline = textHandler
                .andThen((String input2) -> input2.toUpperCase())
                .andThen(String::toString);
    }
}
