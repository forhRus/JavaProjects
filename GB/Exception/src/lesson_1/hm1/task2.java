package lesson_1.hm1;

import java.util.Arrays;
import java.util.Random;

// Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
// и возвращающий новый массив, каждый элемент которого равен разности элементов
// двух входящих массивов в той же ячейке. Если длины массивов не равны,
// необходимо как-то оповестить пользователя.
public class task2 {
    static Random rand = new Random();

    public static void main(String[] args) {
        int[] array1 = new int[5 + rand.nextInt(0, 2)];
        int[] array2 = new int[5];

        fillArray(array1);
        fillArray(array2);

        int[] array3 = diffirence(array1, array2);
        System.out.println(Arrays.toString(array3));
    }

    static int[] diffirence(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Массивы разного размера.");
        }
        int[] res = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            res[i] = arr1[i] - arr2[i];
        }
        return res;
    }

    static void fillArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(0, 10);
        }
    }
}
