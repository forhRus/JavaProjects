package lesson_3.hm3.UI;

import lesson_3.hm3.MVC.Model;
import lesson_3.hm3.MVC.Presenter;
import lesson_3.hm3.MVC.View;
import lesson_3.hm3.db.Config;
import java.util.Scanner;

public class App {
    private static Scanner scanner;
    private static View view;
    private static Model model;
    private static Presenter presenter;
    private static Menu menu;

    public static void start() {
        Config c = new Config(); // Подгружаем конфиги (там путь к директории для контактов)
        scanner = new Scanner(System.in);
        view = new View(scanner);
        model = new Model(c);
        presenter = new Presenter(view, model);
        menu = new Menu();

        menu();
        endProgramm();
    }

    /**
     * Навигация по меню
     */
    private static void menu() {
        int exit = menu.getExit();
        int choice = exit;
        boolean f = true;
        do {
            if (f) {
                view.showMenu(menu.getMenu());
//  Если введено отличное от пункта меню, то меню повторно не выводим, ждём корректный ввод
                f = false;
            }
            choice = view.inputInt();
            switch (choice) {
                case 1:

                    //  Добавляем контакт
                    presenter.addContact();

                    f = true;
                    System.out.println();
                    break;
            }
        } while (choice != exit);
    }


    private static void endProgramm() {
        scanner.close();
        view.println("Программа завершена");
    }
}