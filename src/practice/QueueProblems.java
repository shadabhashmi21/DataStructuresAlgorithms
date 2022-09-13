package practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class QueueProblems {
    static String[] generateBinaryNumbers(int n){
        String[] result = new String[n];
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        for (int i = 0; i < n; i++){
            result[i] = queue.poll();
            queue.offer(result[i] + "0");
            queue.offer(result[i] + "1");
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateBinaryNumbers(5)));
    }
}
