package sort;

import java.util.Arrays;

/*BubbleSort algorithm checks two adjacent elements and swaps them if needed. This approach is followed in every pass.*/

public class BubbleSort {
    public static void sort(int[] arr){
        int n = arr.length;
        boolean isSwapped;

        for (int i = 0; i < n-1; i++) {
            isSwapped = false;
            for (int j = 0; j < n-1-i; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSwapped = true;
                }
            }
            if (!isSwapped) break;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        sort(new int[]{5,4,8,1,9});
    }
}
