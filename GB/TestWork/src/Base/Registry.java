package Base;

import java.util.ArrayList;

/**
 * Класс хранит список животных
 * добавляет в список
 * проверяет наличие в списке животного по id
 * возвращает животное по id
 * возвращает список животных
 */
public class Registry {

    ArrayList<Animal> registry;

    public Registry(ArrayList<Animal> reg) {
        this.registry = reg;
    }

    public void addAnimal(Animal animal){
        registry.add(animal);
    }

    public Animal getAnimal(int ID){
        Animal animal = null;
        for (int i = 0; i < registry.size(); i++) {
            animal = registry.get(i);
            if (animal.getID() == ID) {
                break;
            }
        }
        return animal;
    }

    public boolean contain(int ID) {
        boolean f = false;
        for (int i = 0; i < registry.size(); i++) {
            Animal animal = registry.get(i);
            if (animal.getID() == ID) {
                f = true;
                break;
            }
        }
        return f;
    }


    public ArrayList<Animal> getRegistry(){
        return this.registry;
    }

}
