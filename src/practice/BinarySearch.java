package practice;

public class BinarySearch {
    public static void search(int[] arr, int key){
        int low = 0, high = arr.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == key){
                System.out.println("Element found at index " + mid);
                return;
            }
            if(arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        System.out.println("Element not found");
    }
}
