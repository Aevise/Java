package materialy.wbudowaneIF;

import java.util.function.BinaryOperator;

public class BinaryOperatorExample {

    public static void main(String[] args) {
        BinaryOperator<String> binaryOperator = (str1, str2) ->str1.concat(str2);
        BinaryOperator<String> binaryOperator2 = String::concat;


        System.out.println(binaryOperator.apply("hehe1", "hehe2"));
        System.out.println(binaryOperator2.apply("nothehe", ":)"));
    }
}
