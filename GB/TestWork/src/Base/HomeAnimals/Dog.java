package Base.HomeAnimals;

import Base.HomeAnimal;

import java.util.ArrayList;

public class Dog extends HomeAnimal {
    private static String animalClass = "Собака";
    public Dog(String name, String birthday) {
        super(animalClass, name, birthday);
    }

    public Dog(int id,  String name, String birthday, ArrayList<String> commands) {
        super(id, animalClass, name, birthday, commands);
    }
}
