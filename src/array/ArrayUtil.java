package array;

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

    public static void main(String[] args) {
        int[] arr = {0,2,0,3,4,0,5,7,9,0};
        ArrayUtil arrayUtil = new ArrayUtil();
        arrayUtil.removeEven(arr);
        arrayUtil.reverse(arr);
        arrayUtil.findSmallestElement(arr);
        arrayUtil.findSecondMax(arr);
        arrayUtil.moveZeros(arr);
    }
}
