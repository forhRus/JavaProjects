//    Реализовать алгоритм пирамидальной сортировки (сортировка кучей).

package lesson_2;

import java.util.Arrays;
import java.util.Random;

public class hm2 {
    static Random rand = new Random();

    public static void main(String[] args) {

        int[] array = new int[]
                {30, 27, 7, 12, 28, 2, 16, 1, 14, 29, 24, 3, 9, 5, 6, 25, 8, 22, 21, 10, 13, 11, 26, 15, 23, 20, 4, 17, 18, 0};

        System.out.println(Arrays.toString(array));
        HeapSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void HeapSort(int arr[]) {
        int length = arr.length;
        // Построение кучи
        for (int i = length / 2 - 1; i >= 0; i--)
            heapify(arr, length, i);

        // Один за другим извлекаем элементы из кучи
        for (int i = length - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int arr[], int n, int root) {
        int largest = root; // Инициализируем наибольший элемент как корень
        int l = 2 * root + 1; // потомки
        int r = 2 * root + 2;

        // Если левый потомок больше корня
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // Если индекс самого большого элемента не у корня
        if (largest != root) {
            int swap = arr[root];
            arr[root] = arr[largest];
            arr[largest] = swap;

            // Вызываем рекурсию
            heapify(arr, n, largest);
        }
    }
}
