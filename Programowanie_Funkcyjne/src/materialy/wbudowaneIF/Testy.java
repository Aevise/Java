package materialy.wbudowaneIF;

import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

public class Testy {

    public static void main(String[] args) {
        Map<Integer, Cat> someMap = new HashMap<>();
        someMap.put(1,new Cat("test"));
        someMap.put(2,new Cat("test2"));
        someMap.put(3,new Cat("test3"));
        someMap.put(4,new Cat("test4"));

        System.out.println(someMap);
        someMap.replaceAll((key, value) -> new Cat(value + " Fajson"));
        System.out.println(someMap);

        Supplier<String> supplier1 = Testy::wrapper;
        Supplier<String> supplier2 = () -> stringCreationUnhecked();

        BinaryOperator<String> f1 = String::length;
        UnaryOperator<String> f2 = String::length;
        Function<String, Integer> f3 = String::length;
        Consumer<String> f4 = String::length;


    }

    public void buyStuff(int age){
        AgeValidator validator = a -> a>21;
        boolean validated1 = validator.validate(23);
        boolean validated2 = validator.validate(15);
    }

    interface AgeValidator{
        public boolean validate(Integer age);
    }


    private static String wrapper() {
        try{
            return stringCreationChecked();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "not hehe";
        }

    private static String stringCreationChecked() throws Exception{
        return "stringCreationChecked";
    }

    private static String stringCreationUnhecked() throws RuntimeException{
        return "stringCreationUnhecked";
    }

    static class Cat{
        private final String name;

        public Cat(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Cat: " + name;
        }
    }
}
