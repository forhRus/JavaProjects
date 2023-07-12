
import java.util.Scanner;

/*
Упражнение 1
Напишите консольную программу, в которой пользователь с клавиатуры вводит два числа.
А программа сранивает два введенных числа и выводит на консоль результат сравнения
(два числа равны, первое число больше второго или первое число меньше второго).
 */
public class ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int a = sc.nextInt();

        System.out.print("Введите второе число: ");
        int b = sc.nextInt();

        if (a > b) System.out.printf("%d > %d", a, b);
        else if (a < b) System.out.printf("%d > %d", b, a);
        else System.out.printf("%d = %d", a, b);
        System.out.println();

        sc.close();
    }
}
