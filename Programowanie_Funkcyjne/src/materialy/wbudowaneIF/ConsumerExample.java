package materialy.wbudowaneIF;

import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {
        Consumer<String> consumer1 = input -> System.out.println(input);
        Consumer<String> consumer2 = System.out::println;
        Consumer<String> consumer3 = input -> {
            someMethod(input);
        };
        Consumer<String> consumer4 = ConsumerExample::someMethod;

        consumer1.accept("not hehe");
        consumer2.accept("hehe");
        consumer3.accept("Big not hehe");
        consumer4.accept("hehe");
    }

    private static void someMethod(String input){
        System.out.println("Calling someMethod: " + input);
    }
}
