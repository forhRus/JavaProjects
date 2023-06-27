package lesson_1.hm1;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
// Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?
public class task1 {
    static Random rand = new Random();


    public static void main(String[] args) {
        int[] array = new int[10];
        fillArray(array);
        System.out.println(Arrays.toString(array));
        Scanner scan = new Scanner("123m");

        System.out.println(average(array)); //  ArrayIndexOutOfBoundsException
        System.out.println(divMinMax(array)); //  ArithmeticException
        System.out.println(sum(scan)); //  InputMismatchException
    }
    static int sum(Scanner scan){
        int sum = 0;
        while (true){
            if(scan.hasNext()){
                sum += scan.nextInt();
            } else{
                break;
            }
        }
        return sum;
    }

    static void fillArray(int[] arr) {
        arr[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = rand.nextInt(0, 10);
        }
    }

    static int average(int[] arr) {
        int sum = arr[0];
        for (int i = 1; i <= arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    static int divMinMax(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        return max / min;
    }


}
