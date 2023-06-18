package lesson_2;
import java.util.Date;
public class sem2 {
    public static void InsertSort(int[] Array){ // O(N^2) = O(N*N/2)
        for(int i = 1; i<Array.length; i++){
            for(int j = i; j > 0; j--){
                if(Array[j] < Array[j - 1]){
                    int temp = Array[j];
                    Array[j] = Array[j - 1];
                    Array[j-1] = temp;
                }
            }
        }
    }

    final static int[] buf = new int[100000];
    public static void MergeSort(int[] Array) {
        MergeSort(Array, 0, Array.length - 1);
    }

    private static void MergeSort(int[] Array, int left, int right) {
        if(left == right){
            return;
        }
        int mid = (left + right) / 2;
        MergeSort(Array, left, mid);
        MergeSort(Array, mid+1, right);

        //СЃР»РёСЏРЅРёРµ
        int i = left, j = mid + 1, k = left;
        while(i <= mid && j <= right){
            if(Array[i] < Array[j]){
                buf[k] = Array[i];
                i++;
            }else{
                buf[k] = Array[j];
                j++;
            }
            k++;
        }
        while(i <= mid){
            buf[k++] = Array[i++];
        }
        while(j <= right){
            buf[k++] = Array[j++];
        }
        for(int q = left; q <= right; q++) {
            Array[q] = buf[q];
        }
    }


    private static Integer BinarySearch(int[] Array, int value){
        int left = 0, right = Array.length - 1;
        while(right - left > 1){
            int mid = (left + right) / 2;
            if(Array[mid] < value){
                left = mid;
            }else{
                right = mid;
            }
        }
        if(Array[left] == value)
            return left;
        if(Array[right] == value)
            return right;
        return null;
    }

    public static void main(String[] args) {
        int N = 100000;
        int[] Array1 = new int[N];
        //int[] Array2 = new int[N];
        for(int i=0; i<N; i++){
            Array1[i] = (int)(Math.random() * 100000);
            //Array2[i] = Array1[i];
        }

        //Date start = new Date();
        //InsertSort(Array1);
        //Date end = new Date();
        //long time1 = end.getTime() - start.getTime();

        //start = new Date();
        MergeSort(Array1);
        //end = new Date();
        //long time2 = end.getTime() - start.getTime();

        //System.out.printf("time1 = %d, time2 = %d%n", time1, time2);

        System.out.println(BinarySearch(Array1, 78453));

    }
}