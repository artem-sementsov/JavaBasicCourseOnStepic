import java.io.*;
import java.nio.file.Files;
import java.time.DayOfWeek;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
//        Animal animal0 = new Animal("Cat");
//        Animal animal1 = new Animal("Dog");
//        Animal animal2 = new Animal("Pig");
//        Animal animal3 = new Animal("Mouse");
//
//        Animal[] animals = new Animal[]{animal0, animal1, animal2, animal3};
//
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//
//        try (ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream)) {
//            oos.write(animals.length);
//            for (Animal animal : animals) {
//                oos.writeObject(animal);
//            }
//            oos.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Animal[] animals1 = deserializeAnimalArray(byteArrayOutputStream.toByteArray());

        Example example;
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data))) {
            int size = objectInputStream.readInt();
            Animal[] animals = new Animal[size];
            for (int i = 0; i < size; i++) {
                animals[i] = (Animal) objectInputStream.readObject();
            }
            return animals;
        }
        catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    final class Example<X> {
        private X value;
        private Example( X value){
            this.value = value;
        }

        public void someMethod(Object obj) {
        }

    }
}
