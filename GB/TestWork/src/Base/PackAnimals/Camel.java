package Base.PackAnimals;

import Base.PackAnimal;

import java.util.ArrayList;

public class Camel extends PackAnimal {
    private static String animalClass = "Верблюд";
    public Camel(String name, String birthday) {
        super(animalClass, name, birthday);
    }
    public Camel(int id,  String name, String birthday, ArrayList<String> commands) {
        super(id, animalClass, name, birthday, commands);
    }
}
