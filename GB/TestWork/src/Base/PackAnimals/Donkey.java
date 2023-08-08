package Base.PackAnimals;

import Base.PackAnimal;

import java.util.ArrayList;

public class Donkey extends PackAnimal {
    private static String animalClass = "Осёл";
    public Donkey(String name, String birthday) {
        super(animalClass, name, birthday);
    }

    public Donkey(int id,  String name, String birthday, ArrayList<String> commands) {
        super(id, animalClass, name, birthday, commands);
    }
}
