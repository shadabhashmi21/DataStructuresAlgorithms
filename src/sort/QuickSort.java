package sort;

import java.util.Arrays;

public class QuickSort {
    public void sort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            sort(arr, low, p-1);
            sort(arr, p+1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low, j = low;
        while (i <= high){
            if (arr[i] <= pivot){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
            i++;
        }
        return j-1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {9, 5, 2, 4, 3, -1, 1};
        QuickSort qs = new QuickSort();
        qs.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
