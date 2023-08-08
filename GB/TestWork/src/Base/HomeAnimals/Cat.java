package Base.HomeAnimals;

import Base.HomeAnimal;

import java.util.ArrayList;

public class Cat extends HomeAnimal {
    private static String animalClass = "Кот";
    public Cat(String name, String birthday) {
        super(animalClass, name, birthday);
    }

    public Cat(int id,  String name, String birthday, ArrayList<String> commands) {
        super(id, animalClass, name, birthday, commands);
    }
}
