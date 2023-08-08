package Base.HomeAnimals;

import Base.Animal;

import Base.HomeAnimal;

import java.util.ArrayList;
import java.util.Date;

public class Hamster extends HomeAnimal {
    private static String animalClass = "Хомяк";
    public Hamster(String name, String birthday) {
        super(animalClass, name, birthday);
    }

    public Hamster(int id,  String name, String birthday, ArrayList<String> commands) {
        super(id, animalClass, name, birthday, commands);
    }
}
