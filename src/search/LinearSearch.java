package search;

public class LinearSearch {
    public static void search(int[] arr, int key){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                System.out.println("Element found at index " + i);
                return;
            }
        }
        System.out.println("Element not found");
    }

    public static void main(String[] args) {
       search(new int[]{1, 2, 3}, 2);
    }
}
