package MVC;

import Base.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    private Scanner scan;

    public View(Scanner scan) {
        this.scan = scan;
    }

    public void print(Object msg) {
        System.out.print(msg.toString());
    }

    public void println(Object msg) {
        print(String.format("%s\n", msg));
    }

    public void println() {
        System.out.println();
    }

    // Вводи строки заданной длины
    public String inputStr(int length) {
        String str = scan.nextLine();
        if (str.length() > length) {
            str = str.substring(0, length);
        }
        return str;
    }

    public String inputStr(String msg, int length) {
        System.out.println(msg);
        String str = scan.nextLine();
        if (str.length() > length) {
            str = str.substring(0, length);
        }
        return str;
    }

    public int inputInt() {
        int input = 0;
        while (true) {
            if (scan.hasNextInt()) {
                input = scan.nextInt();
                break;
            } else {
                System.out.println("Введите число!");
            }
            scan.nextLine();
        }
        scan.nextLine();
        return input;
    }

    public int choiceInput(int length) {
        while (true) {
            int choice = inputInt();
            if (0 < choice && choice <= length) {
                System.out.println();
                return choice;
            } else {
                System.out.printf("Введите от 1 до %d: ", length);
            }
        }
    }

    // выводит пункты меню
    public void showMenu(String[] menu) {
        int point = 0;
        for (String p : menu) {
            System.out.printf("\t%d. %s\n", ++point, p);
        }
        System.out.println();
    }

    public void showRegister(ArrayList<Animal> reg) {
        for (int i = 0; i < reg.size(); i++) {
            System.out.printf("\t%s\n", reg.get(i));
        }
        System.out.println();
    }
}
