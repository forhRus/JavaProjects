package Base.PackAnimals;

import Base.PackAnimal;

import java.util.ArrayList;

public class Horse extends PackAnimal {
    private static String animalClass = "Лошадь";
    public Horse(String name, String birthday) {
        super(animalClass, name, birthday);
    }

    public Horse(int id,  String name, String birthday, ArrayList<String> commands) {
        super(id, animalClass, name, birthday, commands);
    }
}
