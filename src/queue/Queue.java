package queue;

import java.util.NoSuchElementException;

/*Note -> Insertion is done at rear and deletion is done at front*/

public class Queue {
    private ListNode front;
    private ListNode rear;
    private int length;

    public Queue(){
        front = null;
        rear = null;
        length = 0;
    }

    private static class ListNode{
        private final int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            next = null;
        }
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void print(){
        if (isEmpty()){
            return;
        }
        ListNode current = front;
        while (current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public void enqueue(int data) {
        ListNode temp = new ListNode(data);
        if (isEmpty()){
            front = temp;
        }else{
            rear.next = temp;
        }
        rear = temp;
        length++;
    }

    public int dequeue() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        int result = front.data;
        front = front.next;
        if (front == null){
            rear = null;
        }
        length--;
        return result;
    }

    public int first() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return front.data;
    }

    public int last() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return rear.data;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.print();

        queue.dequeue();
        queue.print();

        System.out.println(queue.first());
        System.out.println(queue.last());
    }
}
