package lesson_1.hm1;

import java.util.Arrays;
import java.util.Random;

// * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
// и возвращающий новый массив, каждый элемент которого равен частному элементов двух
// входящих массивов в той же ячейке. Если длины массивов не равны,
// необходимо как-то оповестить пользователя.
// Важно: При выполнении метода единственное исключение,
// которое пользователь может увидеть - RuntimeException, т.е. ваше.
public class task3 {
    static Random rand = new Random();

    public static void main(String[] args) {
        int n;
        n = 1; // Массивы разного размера.
        n = 0;
        int[] array1 = new int[5 + n];
        int[] array2 = new int[5];

        fillArray(array1);
        fillArray(array2);
        array2[0] = 0; //  Делить на ноль нельзя.

        int[] array3 = diffirence(array1, array2);
        System.out.println(Arrays.toString(array3));
    }

    static int[] diffirence(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Массивы разного размера.");
        }

        //  Хотел отсортировать и сделать бинарный поиск на наличие 0, чтобы не делать ненужные деления,
        //  - но это ведь сортирует массив, а нам делить нужно
        //  - Arrays.copyOf таже O(N), так что принебрёг

        int[] res = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            if(arr2[i] == 0){
                throw new RuntimeException("Делить на ноль нельзя.");
            }
            res[i] = arr1[i] / arr2[i];
        }
        return res;
    }

    static void fillArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(1, 10);
        }
    }
}
