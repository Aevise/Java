package materialy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public final class PF {


    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
//        System.out.println(function1(() -> "hehe"));
//        Interface1<String> stringInterface1 = function2();
//        System.out.println(stringInterface1.compute());

        ISomeInterface iSomeInterface = someStaticFunction(input -> System.out.println(input));
        iSomeInterface.someMethod("test");

        Cat cat = new Cat("Mruczek");
        Dog dog = new Dog("Bartek");
        Method[] constructors = cat.getClass().getDeclaredMethods();
        for (Method constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println(Arrays.toString(constructors));
        System.out.println(constructors[0].invoke(cat));
        System.out.println(constructors[1].invoke(cat));
        System.out.println(constructors[0].invoke(dog));
        System.out.println(constructors[1].invoke(dog));
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

    static class Dog extends Cat{
        public Dog(String name) {
            super(name);
        }

        @Override
        public String getName() {
            return "oj Bartek, Bartek";
        }
    }

    static ISomeInterface someStaticFunction(ISomeInterface function){
        function.someMethod("Some String");
        return otherInput -> System.out.println("returned " + otherInput);
    }

    interface ISomeInterface{
        void someMethod(String input);
    }

    public static String function1(final Interface1<String> param1){
        return param1.compute();
    }
    public static Interface1<String> function2(){
        return () -> "function2 -> not hehe";
    }

    interface Interface1<T>{
        T compute();
    }
}
