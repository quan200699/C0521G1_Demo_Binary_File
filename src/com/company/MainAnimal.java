package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainAnimal {
    public static void main(String[] args) {
        try {
            writeObjectToBinaryFile("animal.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            List<Animal> animals = readObject("animal.txt");
            for (Animal animal : animals) {
                System.out.println(animal);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeObjectToBinaryFile(String filePath) throws IOException {
        FileOutputStream fos = new FileOutputStream(filePath);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Dog", 12));
        animals.add(new Animal("Cat", 10));
        animals.add(new Animal("Pig", 9));
        oos.writeObject(animals);
        oos.close();
        fos.close();
    }

    public static List<Animal> readObject(String filePath) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filePath);
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Animal> animals = (List<Animal>) ois.readObject();
        return animals;
    }
}
