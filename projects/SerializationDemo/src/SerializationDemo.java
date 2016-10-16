import com.sun.org.apache.bcel.internal.util.ByteSequence;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Objects;


public class SerializationDemo {
    public static void main(String[] args) throws Exception {
        Client originalClient = new Client();
        originalClient.setID(1);
        originalClient.setName("Chuck Norris");
        originalClient.setBirthDate(LocalDate.of(1940, 3, 10));

        Path path = Paths.get("object.bin");
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(originalClient);
        }

        Client deserializedClient;
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {

            deserializedClient = (Client) ois.readObject();
        }

        System.out.printf("%-15s %-30s\n", "ID", deserializedClient.getID());
        System.out.printf("%-15s %-30s\n", "Name", deserializedClient.getName());
        System.out.printf("%-15s %-30s\n", "Date of Birth", deserializedClient.getBirthDate());
        System.out.printf("%-15s %-30s\n", "Age", deserializedClient.getAgeInYears());
    }

    public static class Client implements Serializable {
        private long id;
        private String name;
        private LocalDate birthDate;
        private transient int ageInYears;

        public long getID() { return id; }

        public void setID(long id) { this.id = id; }

        public String getName() { return name; }

        public void setName(String name) { this.name = name; }

        public LocalDate getBirthDate() { return birthDate; }

        public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

        public int getAgeInYears() {
            if (ageInYears == 0) {
                ageInYears = birthDate.until(LocalDate.now()).getYears();
            }
            return ageInYears;
        }

    }

    public class Animal implements Serializable {
        private final String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Animal) {
                return Objects.equals(name, ((Animal) obj).name);
            }
            return false;
        }
    }


    public static Animal[] deserializeAnimalArray(byte[] data) {
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            int size = ois.readInt();
            Animal [] deserializedAnimals = new Animal[size];

            for (int i = 0; i < size; ++i) {
                deserializedAnimals[i] = (Animal) ois.readObject();
            }

            return deserializedAnimals;
        }

        catch (IOException | ClassNotFoundException | ClassCastException e) {
            throw new IllegalArgumentException();
        }
    }
}