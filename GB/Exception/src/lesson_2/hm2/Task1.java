package lesson_2.hm2;

import java.util.Scanner;

//    Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
//    и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
//    вместо этого, необходимо повторно запросить у пользователя ввод данных.

public class Task1 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        programm();
    }

    private static void programm() {
        for (int i = 0; i < 10; i++) {
            float number = input();
            System.out.printf("Вы ввели: %f\n", number);
        }
    }

    private static float input() {
        float number;
        try {
            number = Float.parseFloat(scan.nextLine());
        } catch (Exception e) {
            System.out.print("Введите число: ");
            number = input();
        }
        return number;
    }
}

