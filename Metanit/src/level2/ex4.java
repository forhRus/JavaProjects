package level2;

/*
Упражнения 4
Напишите программу, которая выводит на консоль таблицу умножения
 */
public class ex4 {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%d\t", i * j);
            }
            System.out.println();
        }
    }
}
