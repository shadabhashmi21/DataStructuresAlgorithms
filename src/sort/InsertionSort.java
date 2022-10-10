package sort;

/*Here we divide the array into two parts, the first is the sorted part and the second is the unsorted part.
*We traverse the unsorted part and move its elements into the sorted array, as per the required index.*/

import java.util.Arrays;

public class InsertionSort {
    public static void sort(int[] arr){
        for(int i=1; i<arr.length; i++) {
            int temp = arr[i];
            int j = i-1;

            while (j >= 0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        sort(new int[]{5,4,8,1,11,9});
    }
}
