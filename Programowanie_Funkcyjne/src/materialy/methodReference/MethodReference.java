package materialy.methodReference;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MethodReference {

    public static void main(String[] args) {
        SomeInterface someInterface = arg1 -> {
            System.out.println("someInterface: hehe");
        };

        MilkProducer producer = () -> "Some Milk";
        MilkConsumer consumer = arg1 -> "Milk Consumed: " + arg1;
        System.out.println(producer.produce());
        System.out.println(consumer.consume("Mlekowita"));

        MilkProducer producer2 = MethodReference::someMilkReference1;
        MilkConsumer consumer2 = MethodReference::consumeMilk2;
        System.out.println(producer2.produce());
        System.out.println(consumer2.consume("Heeyah"));

        Testing1 testOut = Test::testFromOtherClass;
        System.out.println(testOut.testingInside(543));

        MethodReference main = new MethodReference();
        main.run();

    }

    private void run(){
        DogPrinter dogPrinter = new DogPrinter();
        String someDog = Optional.of(new Dog("Burek"))
                                .map(Dog::getName)
                                .orElse("AnotherDogName");
        System.out.println(someDog);

        Optional.of(new Dog("nastepny Burek"))
                .ifPresent(dogPrinter::printDog);

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Tomasz"));
        dogs.add(new Dog("Fabian"));

        dogs.sort((a,b) -> a.getName().compareTo(b.getName()));
        dogs.sort(Comparator.comparing(dog -> dog.getName()));
        dogs.sort(Comparator.comparing(Dog::getName));

        SteeringWheel steeringWheel = new SteeringWheel(6.52);
        Car car = Optional.of(steeringWheel)
                .map(SW -> new Car(SW))
                .orElse(new Car(new SteeringWheel(0.0)));
        Car car2 = Optional.of(steeringWheel)
                .map(Car::new)
                .orElse(new Car(new SteeringWheel(0.0)));

        System.out.println(car);
        System.out.println(car2);
    }

    private static String consumeMilk2(String s) {
        return "consumeMilk2: " + s;
    }

    public static void myMethod(String arg1){
        System.out.println("myMethod: hehe");
    }
    @FunctionalInterface
    interface SomeInterface{
        void someMethod(String arg1);
    }
    @FunctionalInterface
    interface MilkProducer{
        String produce();
    }

    @FunctionalInterface
    interface MilkConsumer{
        String consume(String toConsume);
    }

    interface Testing1{
        Integer testingInside(int num);
    }

    public static String someMilkReference1(){
        return "someMilkReference1";
    }
}
