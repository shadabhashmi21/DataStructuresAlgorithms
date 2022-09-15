package matrix;

public class SortedMatrix {
    public static void search(int[][] arr, int n, int x){
        int i = 0, j = n-1;
        while (i < n && j >= 0){
            if (arr[i][j] == x){
                System.out.println("Element found at: " + i + "," + j);
                return;
            }
            if (arr[i][j] > x)
                j--;
            else
                i++;
        }
        System.out.println("Element not found");
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 51}
        };
        search(matrix, matrix.length, 45);
    }
}
