import java.util.Scanner;

/*
Упражнение 5
Измените предыдущую программу. Пусть пользователь кроме номера операции вводит
два числа, и в зависимости от номера операции с введенными числами выполняются
определенные действия (например, при вводе числа 3 числа умножаются).
Результат операции выводиться на консоль.
 */
public class ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.print("Введите первое число: ");
            int a = sc.nextInt();
            System.out.print("Введите второе число: ");
            int b = sc.nextInt();
            System.out.print("Введите номер операции: 1.Сложение 2.Вычитание 3.Умножение: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(a+b);
                    break;
                case 2:
                    System.out.println(a-b);
                    break;
                case 3:
                    System.out.println(a*b);
                    break;
                default:
                    System.out.println("Операция неопределена");
                    break;
            }
        }
        sc.close();
    }

}
