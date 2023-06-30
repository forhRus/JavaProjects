package lesson_3.hm3.MVC;

import java.util.Scanner;

public class View {
    Scanner scan;

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

    public int inputInt() {
        int input;
        while (true) {
            if (scan.hasNextInt()) {
                input = scan.nextInt();
                scan.nextLine();
                break;
            }
            scan.nextLine();
        }
        return input;
    }


    public void showMenu(String[] menu) {
        for (String p : menu) {
            System.out.println(p);
        }
    }
    public String inputString(){
        return scan.nextLine();
    }
}