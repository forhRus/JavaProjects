package lesson_2.hm2;

//    Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
//    Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

import java.security.spec.ECField;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Task4 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws VoidException{
        programm();
    }
    private static void programm() throws VoidException{
        for (int i = 0; i < 10; i++) {
                String str = scan.nextLine();
                if (str.length() == 0) {
                    throw new VoidException();
                }
                System.out.printf("Вы ввели: %s\n", str);
        }
    }
}

class VoidException extends Exception{
    public VoidException() {
        super("Пустые строки вводить нельзя!");
    }
}
