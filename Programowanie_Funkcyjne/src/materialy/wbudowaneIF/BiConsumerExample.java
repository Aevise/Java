package materialy.wbudowaneIF;

import java.util.function.BiConsumer;

public class BiConsumerExample {

    public static void main(String[] args) {
        BiConsumer<String, Cat> biConsumer1 = (str, cat) -> System.out.println("Cat " + cat.getName() + " likes to eat: " + str);
        BiConsumer<String, Cat> biConsumer2 = BiConsumerExample::EatSomethin;

        biConsumer1.accept("Whiskas", new Cat("Tomek"));
        biConsumer2.accept("Milk", new Cat("Krysia"));

    }

    private static void EatSomethin(String string, Cat cat){
        System.out.println("EatSomethin");
        System.out.println("Cat " + cat.getName() + " likes to eat " + string);
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
            return "Cat{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
