package heap;

/*PriorityQueue is a data structure that allows us to find maximum/minimum element among a collection of element in a constant time.
* The following operations are supported - insert, deleteMax/deleteMin, getMax/getMin */

/*The binary heap is a data structure that helps us in implementing PriorityQueue operations efficiently. A binary heap is a
* complete Binary Tree in which each node value is <= or >= than the value of its children (max heap or min heap)*/

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

    public void sink(int k){
        while (2*k <= n){
            int j = 2*k;
            if (j<n && heap[j] < heap[j+1])
                j++;
            if (heap[k] >= heap[j])
                break;
            swap(k, j);
            k = j;
        }
    }

    public int deleteMax(){
        int max = heap[1];
        swap(1,n);
        n--;
        sink(1);
        heap[n+1] = null;
        if(n > 0 && (n == (heap.length - 1) / 4))
            resize(heap.length/2);
        return max;
    }

    public void swap(int a, int b){
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    public static void main(String[] args) {
        MaximumPriorityQueue mpq = new MaximumPriorityQueue(3);
        mpq.insert(2);
        mpq.insert(3);
        mpq.insert(8);
        mpq.insert(5);
        mpq.insert(1);
        mpq.printMaxHeap();
        mpq.deleteMax();
        mpq.printMaxHeap();
    }
}
