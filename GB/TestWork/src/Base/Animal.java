package Base;

import java.util.ArrayList;

/**
 * Класс животного хранит в себе id, имя, вид животного, тип, дату рождения, список команд
 */
public abstract class Animal {
    // счётчик и будущий id для нового животного
    private static int count = 0;
    private int ID;
    private String animalClass, name, type, birthday;
    private ArrayList<String> commands;

    // Конструктор для загрузки животных из файла
    public Animal(int id, String animalClass, String name, String type, String birthday, ArrayList<String> commands) {
        this.ID = id;
        this.animalClass = animalClass;
        this.name = name;
        this.type = type;
        this.birthday = birthday;
        this.commands = commands;
    }

    public Animal(String animalClass, String name, String type, String birthday) {
        this(++count, animalClass, name, type, birthday, new ArrayList<>());
    }

    public static void setCount(int count) {
        Animal.count = count;
    }

    public int getID() {
        return ID;
    }

    public ArrayList<String> getCommands() {
        return commands;
    }

    public String getAnimalClass() {
        return animalClass;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getBirthday() {
        return birthday;
    }

    public void learnCommand(String command) {
        commands.add(command);
    }

    public String showCommands() {
        return commands.toString();
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Class: %s, Type: %s, Birthday: %s, Commands: %s", ID, name, animalClass, type, birthday, commands.toString());
    }

    public void setCommands(ArrayList<String> commands) {
        this.commands = commands;
    }
}


