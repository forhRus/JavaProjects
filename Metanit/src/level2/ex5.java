package level2;

import java.util.Scanner;

/*
Упражнение 5
В цикле программа просит у пользователя ввести два числа и выводит результат их умножения.
После вывода результата умножения программа спрашивает, надо ли завершить выполнение.
И если пользователь введет число 1, то программа завершает цикл.
Если введено любое другое число, то программа продолжает спрашивать
у пользователя два числа и умножать их.
 */
public class ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int exit = 1;
        int choice = 0;
        do {
            System.out.print("Введите первое число: ");
            int num1 = sc.nextInt();
            System.out.print("Введите второе число: ");
            int num2 = sc.nextInt();
            System.out.println(num1 * num2);
            System.out.print("Для продолжение нажмите 1: ");
            choice = sc.nextInt();
        } while (choice == exit);
        System.out.println("Programm finished");
        sc.close();
    }
}
