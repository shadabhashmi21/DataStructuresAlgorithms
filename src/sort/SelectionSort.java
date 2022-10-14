package sort;

import java.util.Arrays;

public class SelectionSort {
    public static void sort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n-1; i++) {
            int min = i;
            for(int j = i+1; j < n; j++) {
                if(arr[j] < arr[min])
                    min = j;

                int temp = arr[min];
                arr[min] = arr[j];
                arr[j] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        sort(new int[]{5,4,8,1,11,9});
    }
}
