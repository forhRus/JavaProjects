package Base;

import java.util.ArrayList;
import java.util.Date;

public abstract class HomeAnimal extends Animal{
    private static String type = "Домашнее животное";
    public HomeAnimal(String animalClass, String name, String birthday) {
        super(animalClass, name, type, birthday);
    }

    public HomeAnimal(int id, String animalClass, String name, String birthday, ArrayList<String> commands) {
        super(id, animalClass, name, type, birthday, commands);
    }
}

