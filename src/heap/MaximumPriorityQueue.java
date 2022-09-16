package heap;

public class MaximumPriorityQueue {
    Integer[] heap;
    int n;

    public MaximumPriorityQueue(int capacity){
        heap = new Integer[capacity + 1];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int getSize() {
        return n;
    }

    public static void main(String[] args) {
        MaximumPriorityQueue mpq = new MaximumPriorityQueue(3);
        System.out.println(mpq.getSize());
        System.out.println(mpq.isEmpty());
    }
}
