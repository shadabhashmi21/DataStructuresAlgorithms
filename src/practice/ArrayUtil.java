package practice;

public class ArrayUtil {
    public void printArray(int[] arr){
        for (int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void removeEven(int[] arr){
        int oddCount = 0;
        for (int i: arr){
            if (i%2 != 0)
                oddCount++;
        }
        int[] oddArray = new int[oddCount];
        int index = 0;
        for (int i: arr){
            if (arr[i]%2 != 0){
                oddArray[index] = arr[i];
                index++;
            }
        }
        printArray(oddArray);
    }

    public void reverse(int[] arr){
        int start=0, end = arr.length-1;
        while (start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        printArray(arr);
    }

    public void findSmallest(int[] arr){
        int min = arr[0];
        for (int i: arr){
            if (arr[i] > min)
                min = arr[i];
        }
        System.out.println("Smallest element= " + min);
    }

    public void findSecondMax(int[] arr){
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        for (int i: arr){
            if (arr[i] > max){
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        System.out.println("Second Max = " + secondMax);
    }

    public void moveZeros(int[] arr){
        int j = 0;
        for (int i: arr){
            if (arr[i] != 0 && arr[j] == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if (arr[j] != 0)
                j++;
        }
        printArray(arr);
    }

    public void findMissingNumber(int[] arr){
        int n = arr.length + 1;
        int sum = n * (n+1) /2;
        for (int i: arr){
            sum = sum-arr[i];
        }
        System.out.println(sum);
    }
}
