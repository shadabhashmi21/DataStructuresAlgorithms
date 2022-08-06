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
        System.out.println("After after removing even numbers");
        printArray(resultArray);
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,5,7,9};
        ArrayUtil arrayUtil = new ArrayUtil();
        arrayUtil.removeEven(arr);
    }
}
