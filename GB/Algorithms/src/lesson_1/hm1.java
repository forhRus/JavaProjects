package lesson_1;

import java.util.*;

public class hm1 {
    static Random rand = new Random();

    public static void main(String[] args) {
        // Дано целое число N из отрезка [1; 1000].
        // Также даны N целых чисел Ai из отрезка [1; 1000000].
        // Требуется для каждого числа Ai вывести количество различных делителей этого числа.
        // В этой задаче несколько верных решений, попробуйте найти наиболее оптимальное.
        // Для полученного решения укажите сложность в О-нотации.

        int N = rand.nextInt(1, 10);
        Map<Integer, Integer> map = func(N); // O(N*A)
        printMap(map); // O(N)

        // Ответ: O(N*A)
    }

    // Выводим словарь
    private static void printMap(Map<Integer, Integer> map){
        for(Integer k : map.keySet()){  // O(N)
            int v = map.get(k);
            System.out.printf("у числа %d - %d делителя(ей)\n", k, v);
        }
    }

    //  Генерируем N чисел из диапазона и возвращаем словать {число: количество делителей}
    private static Map<Integer, Integer> func(int N) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {  //  O(N*A) = O(N) * O(A) +...
            int A = rand.nextInt(1, 1000000);
            int count = counterDivider(A); // O(A)
            hm.put(A, count);
        }
        return hm; //  O(1)
    }

    // Счетчик делителей
    private static int counterDivider(int A) { //  O(A) = O(A/2) + O(1)...
        int count = 1;  //  O(1)
        for (int i = 1; i <= A / 2; i++) { //  O(A/2)
            if (A % i == 0) {
                count++;  //  O(1)
            }
        }
        return count; //  O(1)

    }
 
}