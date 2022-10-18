package array;

import java.util.Arrays;

public class ArrayUtil {
    public void printArray(int[] arr){
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void removeEven(int[] arr){
        int oddCount = 0;
        for (int i=0; i<arr.length; i++){
            if (arr[i]%2 != 0){
                oddCount++;
            }
        }
        int[] resultArray = new int[oddCount];
        int index = 0;
        for (int i=0; i<arr.length; i++){
            if (arr[i]%2 != 0){
                resultArray[index] = arr[i];
                index++;
            }
        }
        System.out.println("Array after removing even numbers");
        printArray(resultArray);
    }

    public void reverse(int[] arr){
        int start = 0, end = arr.length -1;
        while (start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        System.out.println("Reversed Array");
        printArray(arr);
    }

    public void findSmallestElement(int[] arr){
        int min = arr[0];
        for (int i=0; i<arr.length; i++){
            if (arr[i] < min)
                min = arr[i];
        }
        System.out.println("Smallest Element = " + min);
    }

    public void findSecondMax(int[] arr){
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        for (int i=0; i<arr.length; i++){
            if (arr[i] > max){
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        System.out.println("Second Largest Element = " + secondMax);
    }

    public void moveZeros(int[] arr){
        int j=0;
        for (int i=0; i<arr.length; i++){
            if (arr[i] != 0 && arr[j] == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if (arr[j] != 0){
                j++;
            }
        }
        System.out.println("Array after moving Zeros to end");
        printArray(arr);
    }

    public void findMissingNumber(int[] arr){
        int n = arr.length + 1;
        int sum = n * (n+1) /2;
        for (int i=0; i<arr.length; i++){
            sum = sum-arr[i];
        }
        System.out.println("Missing Number = " + sum);
    }

    public void mergeTwoSortedArrays(int[] arr1, int[] arr2){
        int length1 = arr1.length, length2 = arr2.length;
        int i=0, j=0, k=0;
        int[] result = new int[length1 + length2];

        while (i<length1 && j<length2){
            if (arr1[i] < arr2[j]){
                result[k] = arr1[i];
                i++;
            }else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i<length1){
            result[k] = arr1[i];
            k++;
            i++;
        }

        while (j<length2){
            result[k] = arr2[j];
            k++;
            j++;
        }

        printArray(result);
    }

    public static void main(String[] args) {
        int[] arr = {0,2,0,3,4,0,5,7,9,0};
        ArrayUtil arrayUtil = new ArrayUtil();
        arrayUtil.removeEven(arr);
        arrayUtil.reverse(arr);
        arrayUtil.findSmallestElement(arr);
        arrayUtil.findSecondMax(arr);
        arrayUtil.moveZeros(arr);
        arrayUtil.findMissingNumber(new int[] {1,2,3,5});
        arrayUtil.mergeTwoSortedArrays(new int[] {2,5,6,8}, new int[] {1,3,4,7,10});
    }
}
