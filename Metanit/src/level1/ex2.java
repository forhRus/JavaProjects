package level1;

import java.util.Scanner;

/*
Упражнение 2

Напишите консольную программу, в которой пользователь вводит с клавиатуры число.
Если число одновременно меньше 9 и больше 2, то программа выводит
"Число больше 2 и меньше 9". Иначе программа выводит сообщение "Неизвестное число".
 */
public class ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.print("Введите число: ");
            int a = sc.nextInt();

            System.out.println((a < 9) && (a > 2) ?
                    "Число больше 2 и меньше 9" : "Неизвестное число");
        }
        sc.close();
    }
}
