import java.util.Arrays;
import java.util.Random;

/*
Написать метод, которому можно передать в качестве аргумента массив, состоящий
строго из единиц и нулей(целые числа типа int). Метод должен заменить единицы в массиве на нули, а нули на единицы.
Написать как можно больше вариантов.
 */
public class task_3 {
    static Random r = new Random();
    public static void main(String[] args) {
        int[] array = new int[10];
        fill(array);
        System.out.println(Arrays.toString(array));
        swap(array);
        System.out.println(Arrays.toString(array));
    }
    public static void swap(int [] ar){
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == 0){
                ar[i] = 1;
            } else {
                ar[i] = 0;
            }
        }
    }
    public static void fill(int[] ar){
        for (int i = 0; i < ar.length; i++) {
            ar[i] = r.nextInt(0, 2);
        }
    }
}
