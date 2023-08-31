package materialy.wbudowaneIF;

import java.util.function.UnaryOperator;

public class UnaryOperatorExamples {
    public static void main(String[] args) {
        UnaryOperator<String> unaryOperator = s -> s + s;
        System.out.println(unaryOperator.apply("hehe"));
    }
}
