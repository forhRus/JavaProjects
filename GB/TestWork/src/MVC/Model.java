package MVC;


import Base.Animal;
import Base.Counter;
import Base.HomeAnimals.Cat;
import Base.HomeAnimals.Dog;
import Base.HomeAnimals.Hamster;
import Base.PackAnimals.Camel;
import Base.PackAnimals.Donkey;
import Base.PackAnimals.Horse;
import Base.Registry;
import db.Config;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model {
    private Config conf;
    private Registry reg;
    private Counter c;

    // Создаёт реестр, в который добавляет список животных из загруженного
    public Model(Config conf) {
        this.conf = conf;
        try {
            File fileRegistry = new File(conf.getPathRegistry());
            reg = new Registry(loadList(fileRegistry));
            c = new Counter();
            //устанавливаем id последнего добавленного животного как количество животных для будущих id
            if (reg.getRegistry().size() != 0) {
                Animal animal = reg.getAnimal(reg.getRegistry().size());
                Animal.setCount(animal.getID());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void increaseCounter() {
        c.Increase();
    }

    public int getCount() {
        return c.getCount();
    }

    public ArrayList<Animal> loadList(File file) {
        ArrayList<Animal> l = new ArrayList<>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader bf = new BufferedReader(fr);
            String line = bf.readLine();
            while (line != null && line.length() > 0) {
                l.add(parseLine(line));
                line = bf.readLine();
            }
            bf.close();
            fr.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return l;
    }

    private Animal parseLine(String line) {
        int id = Integer.valueOf(line.substring(0, line.indexOf(';')));
        line = cutLine(line);

        String name = line.substring(0, line.indexOf(';'));
        line = cutLine(line);

        String clas = line.substring(0, line.indexOf(';'));
//        line = line.substring(line.indexOf(';') + 1, line.lastIndexOf(';'));
        line = cutLine(line);

        String type = line.substring(0, line.indexOf(';'));
        line = cutLine(line);

        String birthday = line.substring(0, line.indexOf(';'));
        line = cutLine(line);

        ArrayList<String> commands = new ArrayList<>(Arrays.asList(line.substring(0, line.indexOf(';')).split(":")));

//        String[] array = line.substring(0, line.indexOf(';')).split(":");
//        ArrayList<String> commands = new ArrayList<>();
//        for (int i = 0; i < array.length; i++) {
//            commands.add(array[i]);
//        }

        Animal animal = createAnimal(id, name, clas, type, birthday, commands);

        return animal;
    }

    private String cutLine(String line) {
        return line.substring(line.indexOf(';') + 1, line.lastIndexOf(';') + 1);
    }

    // колхоз, но что делать? Не научился по другому.
    private Animal createAnimal(int id, String name, String clas, String type, String birthday, ArrayList<String> commands) {
        Animal animal = null;
        switch (clas) {
            case "Кот":
                animal = new Cat(id, name, birthday, commands);
                break;
            case "Собака":
                animal = new Dog(id, name, birthday, commands);
                break;
            case "Хомяк":
                animal = new Hamster(id, name, birthday, commands);
                break;
            case "Лошадь":
                animal = new Horse(id, name, birthday, commands);
                break;
            case "Осёл":
                animal = new Donkey(id, name, birthday, commands);
                break;
            case "Верблюд":
                animal = new Camel(id, name, birthday, commands);
                break;
        }
        return animal;
    }


    public ArrayList<Animal> getRegistry() {
        return reg.getRegistry();
    }

    public void addAnimal(Animal animal) {
        reg.addAnimal(animal);
    }

    public void learnCommands(int ID, String command) {
        Animal animal = (Animal) reg.getAnimal(ID);
        animal.learnCommand(command);
    }

    public String getCommands(int ID) {
        Animal animal = (Animal) reg.getAnimal(ID);
        return animal.showCommands();
    }

    public boolean checkAnimal(int ID) {
        return reg.contain(ID);
    }

    public void save() {
        File fileRegistry = new File(conf.getPathRegistry());
        saveRegistry(fileRegistry, this.reg.getRegistry());
    }


    private void saveRegistry(File file, List<Animal> reg) {
        try {
            FileWriter fw = new FileWriter(file, false);
            for (Animal a : reg) {
                String saveStr = animalStringToSave(a);
                fw.write(saveStr);
            }
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String animalStringToSave(Animal a) {
        String res = String.format("%d;%s;%s;%s;%s;%s;\n", a.getID(), a.getName(), a.getAnimalClass(), a.getType(), a.getBirthday(), String.join(":", a.getCommands()));
        return res;
    }

}