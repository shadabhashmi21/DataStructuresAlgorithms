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

    public void insert(int x){
        if (n == heap.length - 1)
            resize(2*heap.length);

        n++;
        heap[n] = x;
        swim(n);
    }

    public void swim(int k){
        while (k > 1 && heap[k/2] < heap[k]){
            int temp = heap[k];
            heap[k] = heap[k/2];
            heap[k/2] = temp;
            k = k/2;
        }
    }

    private void resize(int capacity) {
        Integer[] temp = new Integer[capacity];
        for (int i = 0; i < heap.length; i++)
            temp[i] = heap[i];
        heap = temp;
    }

    public void printMaxHeap(){
        for (int i = 1; i <= n; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        MaximumPriorityQueue mpq = new MaximumPriorityQueue(3);
        mpq.insert(2);
        mpq.insert(3);
        mpq.insert(8);
        mpq.insert(5);
        mpq.insert(1);
        mpq.printMaxHeap();
        System.out.println(mpq.getSize());
    }
}
