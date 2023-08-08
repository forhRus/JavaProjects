package MVC;

import Base.Animal;
import Base.HomeAnimals.*;
import Base.PackAnimals.*;
import Exeptions.EmptyField;
import UI.Menu;

import java.util.ArrayList;


public class Controler {
    View v;
    Model m;
    Menu mainMenu = new Menu(new String[]{
            "Показать реестр животных",
            "Добавить в реестр животное",
            "Показать команды животного",
            "Научить животное новой команде",
            "Количество добавленных животных за ссесию",
            "Выход"});

    Menu animalType = new Menu(new String[]{
            "Кот",
            "Собака",
            "Хомяк",
            "Лошадь",
            "Осёл",
            "Верблюд",
            "Выход"
    });

    public Controler(View v, Model m) {
        this.v = v;
        this.m = m;
    }


    /**
     * Метод выводит главное меню, осуществляет навигацию
     */
    public void menu() {
        GG:
        while (true) {
            v.println("Главное меню");
            v.showMenu(mainMenu.getMenu());
            int exit = mainMenu.getExit();
            int choice = v.choiceInput(exit);
            if (choice == exit) {
                break;
            }
            switch (choice) {
                case 1: // Показать реестр животных
                    ArrayList<Animal> reg = m.getRegistry();
                    if (reg.size() == 0) {
                        v.println("Список пуст");
                    } else {
                        System.out.println("Список животных");
                        v.showRegister(reg);
                    }
                    break;
                case 2: // Добавить в реестр животное
                    menuAnimalType();
                    break;
                case 3: //"Показать команды животного",
                    v.println("Введите ID животного");
                    int id = v.inputInt();
                    if (m.checkAnimal(id)) {
                        System.out.println(m.getCommands(id));
                    }
                    break;
                case 4: // Научить животное новой команде
                    v.println("Введите ID животного");
                    id = v.inputInt();
                    String command = v.inputStr("Введите команду", 50);
                    if (m.checkAnimal(id)) {
                        m.learnCommands(id, command);
                    }
                    break;
                case 5: // Количество добавленных животных за ссесию
                    System.out.printf("Животных добавлено: %d\n\n", m.getCount());
                    break;
            }
        }
        m.save();
    }


    /**
     * Метод выводит список из видов животных, и добавляет животное согласно выбору и введенным параметрам
     * Колхоз, но я не знаю как сделать иначе, чтобы создавать не животных, а наследников
     */
    public void menuAnimalType() {
        Animal animal = null;
        String name = "";
        String birthday = "";
        GG:
        while (true) {
            v.println("Виды животных:");
            v.showMenu(animalType.getMenu());
            int exit = animalType.getExit();
            int choice = v.choiceInput(exit);
            if (choice == exit) {
                break;
            }
            if (choice > 0 && choice < exit) {
                try {
                    name = v.inputStr("Введите имя животного", 16);
                    // Проверка на валидность не делается. LocalDate ломает легко.
                    birthday = v.inputStr("Введите дату рождения", 10);
                    if (name.length() == 0 || birthday.length() == 0) {
                        throw new EmptyField();
                    }
                    m.increaseCounter();
                    switch (choice) {
                        case 1:
                            animal = new Cat(name, birthday);
                            m.addAnimal(animal);
                            break GG;
                        case 2:
                            animal = new Dog(name, birthday);
                            m.addAnimal(animal);
                            break GG;
                        case 3:
                            animal = new Hamster(name, birthday);
                            m.addAnimal(animal);
                            break GG;
                        case 4:
                            animal = new Horse(name, birthday);
                            m.addAnimal(animal);
                            break GG;
                        case 5:
                            animal = new Donkey(name, birthday);
                            m.addAnimal(animal);
                            break GG;
                        case 6:
                            animal = new Camel(name, birthday);
                            m.addAnimal(animal);
                            break GG;
                    }
                } catch (EmptyField e) {
                    System.out.println(e.getMessage());
                }
            }


        }
    }
}