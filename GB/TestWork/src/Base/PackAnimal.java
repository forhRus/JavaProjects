package Base;

import java.util.ArrayList;

public class PackAnimal extends Animal {
    private static String type = "Вьючное животное";
    public PackAnimal(String animalClass, String name, String birthday) {
        super(animalClass, name, type, birthday);
    }
    public PackAnimal(int id, String animalClass, String name, String birthday, ArrayList<String> commands) {
        super(id, animalClass, name, type, birthday, commands);
    }
}
