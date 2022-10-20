package sort;

import java.util.Arrays;

public class MergeSort {
    public void sort(int[] arr, int[] temp, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            sort(arr, temp, low, mid);
            sort(arr, temp, mid + 1, high);
            merge(arr, temp, low, mid, high);
        }
    }

    private void merge(int[] arr, int[] temp, int low, int mid, int high) {
        for (int i = low; i <= high; i++)
            temp[i] = arr[i];

        int i = low, j = mid + 1, k = low;
        while (i <= mid && j <= high) {
            if (temp[i] < arr[j]){
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        while (i <= mid){
            arr[k] = temp[i];
            i++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {9, 5, 2, 4, 3, -1, 1};
        MergeSort ms = new MergeSort();
        ms.sort(arr, new int[arr.length], 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
