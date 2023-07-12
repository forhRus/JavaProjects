package level2;

import java.util.Scanner;

/*
Упражнение 3
За каждый месяц банк начисляет к сумме вклада 7% от суммы.
Напишите консольную программу, в которую пользователь вводит сумму вклада
и количество месяцев. А банк вычисляет конечную сумму вклада с учетом начисления
процентов за каждый месяц.

Для вычисления суммы с учетом процентов используйте цикл for.
Пусть сумма вклада будет представлять тип float.
 */
public class ex3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Введите размер вклада: ");
        float sum = sc.nextFloat();
        System.out.printf("Введите период(месяцы): ");
        float month = sc.nextInt();

        for (int i = 0; i < month; i++) {
            sum += sum * 0.01;
        }
        System.out.println(sum);

        sc.close();
    }

}
