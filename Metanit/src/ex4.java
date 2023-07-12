import java.util.Scanner;

/*
Упражнение 4
Напишите консольную программу, которая выводит пользователю сообщение
"Введите номер операции: 1.Сложение 2.Вычитание 3.Умножение".
Рядом с названием каждой операции указан ее номер, например,
операция вычитания имеет номер 2. Пусть пользователь вводит в
программе номер операции, и в зависимости от этого номера программа
выводит название операции.
Для определения операции по введенному номеру используйте конструкцию switch...case.

Если введенное пользователем число не соответствует никакой операции (например, число 120),
то выведите пользователю сообщение о том, что операция неопределена.
 */
public class ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("Введите номер операции: 1.Сложение 2.Вычитание 3.Умножение");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Сложение");
                    break;
                case 2:
                    System.out.println("Вычитание");
                    break;
                case 3:
                    System.out.println("Умножение");
                    break;
                default:
                    System.out.println("Операция неопределена");
            }
        }
        sc.close();
    }
}
