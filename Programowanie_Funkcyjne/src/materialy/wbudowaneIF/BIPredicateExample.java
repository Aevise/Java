package materialy.wbudowaneIF;

import java.util.function.BiPredicate;

public class BIPredicateExample {

    public static void main(String[] args) {
        BiPredicate<String, Dog> biPredicate1 = (str, dog) -> dog.toString().contains(str);
        BiPredicate<String, Dog> biPredicate2 = checker();
        BiPredicate<String, Dog> biPredicate3 = BIPredicateExample::BIPredicateTest;

        System.out.println(biPredicate1.test("urek", new Dog("Burek")));
        System.out.println(biPredicate2.test("opka", new Dog("Kropka")));
        System.out.println(biPredicate3.test("och", new Dog("Szczoch")));


    }

    private static BiPredicate<String, Dog> checker(){
        return (str, dog) ->{
            System.out.println("method checker: "+ str + " and " + dog.getName());
            return dog.toString().contains(str);
        };
    }

    private static boolean BIPredicateTest(String string, Dog dog){
        System.out.println("Calling BIPredicateTest: " + string + " and " + dog.getName());
        return dog.toString().contains(string);
    }

    static class Dog{
        private final String name;

        public Dog(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Dog{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
