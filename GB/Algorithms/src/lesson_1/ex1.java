package lesson_1;

import java.util.ArrayList;
import java.util.List;

public class ex1 {
    public static void main(String[] args) {
        List<Integer> availableDivider = findSimleNumber(12);
        for (Integer integer : availableDivider) {
            System.out.println(integer);
        }
    }
    public static List<Integer> findAvaribleDivider(int number) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                result.add(i);
            }
        }
        return result;
    }

    public static List<Integer> findSimleNumber (int number) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            boolean f = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    f = false;
                }
            }
            if(f){
                result.add(i);
            }
        }
        return result;
    }

}
