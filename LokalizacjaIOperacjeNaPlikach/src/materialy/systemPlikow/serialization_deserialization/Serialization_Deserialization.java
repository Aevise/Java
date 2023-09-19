package materialy.systemPlikow.serialization_deserialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serialization_Deserialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Ford Mustang", 1969L, List.of(new Door("left"), new Door("right"))));
        carList.add(new Car("BMW 3", 2015L, List.of(new Door("left"), new Door("right"))));
        carList.add(new Car("Mercedes 6-Class", 2004L, List.of(new Door("left"), new Door("right"))));

        File destination = new File("cars.txt");

        serialize(carList, destination);

        List<Car> carsDeserialized = deserializeCar(destination);
        System.out.println(carsDeserialized);

        System.out.println("-------------------------------------------------------");
        File destinationForDogs = new File("dogs.txt");
        List<Dog> dogs = new ArrayList<>();
        System.out.println("Creating dog1: ");
        dogs.add(new Dog());
        System.out.println("----------------------\nCreating dog2: ");
        dogs.add(new Dog("Wojtek", "Szczepionka"));
        System.out.println("----------------------\nSerializing dogs: ");
        serialize(dogs, destinationForDogs);
        System.out.println("----------------------\nDeserializing dogs: ");
        List<?> dogsDeserialize = deserialize(destinationForDogs);
        System.out.println(dogsDeserialize);
    }

    private static List<Car> deserializeCar(File destination) throws IOException, ClassNotFoundException {
        List<Car> carList = new ArrayList<>();
        try (
                ObjectInputStream inputStream = new ObjectInputStream(
                        new BufferedInputStream(
                                new FileInputStream(destination)
                        )
                )) {
            while(true){
                Object object = inputStream.readObject();
                if(!(object instanceof Car)){
                    System.out.println("Object is not a car");
                    continue;
                }
                Car readCar = (Car)object;
                System.out.println("Found car: " + readCar);
                carList.add(readCar);
            }
        } catch (EOFException e){
            System.out.println("End of file");
        }
        return carList;
    }
    private static List<?> deserialize(File destination) throws IOException, ClassNotFoundException {
        List<Object> objectList = new ArrayList<>();
        try (
                ObjectInputStream inputStream = new ObjectInputStream(
                        new BufferedInputStream(
                                new FileInputStream(destination)
                        )
                )) {
            while(true){
                Object object = inputStream.readObject();
                System.out.println("Found object type: " + object.getClass().getSimpleName());
                objectList.add(object);
            }
        } catch (EOFException e){
            System.out.println("End of file");
        }
        return objectList;
    }

    private static void serialize(List<?> objectList, File destination) throws IOException {
        try (
                ObjectOutputStream outputStream = new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(destination)))
        ) {
            for (Object object : objectList) {
                outputStream.writeObject(object);
            }
        }
    }
}
