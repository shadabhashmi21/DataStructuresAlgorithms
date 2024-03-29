package practice;

import java.util.NoSuchElementException;

public class Queue {
    private ListNode front;
    private ListNode rear;
    private int length;

    private static class ListNode{
        private final int data;
        private ListNode next;

        private ListNode(int data) {
            this.data = data;
        }
    }

    public Queue(){
        front = null;
        rear = null;
        length = 0;
    }

    public int getLength(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void print(){
        if (isEmpty())
            return;

        ListNode current = front;
        while (current != null) {
            System.out.println(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void enqueue(int data) {
        ListNode newNode = new ListNode(data);

        if (isEmpty())
            front = newNode;
        else
            rear.next = newNode;

        rear = newNode;
        length++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();

        int result = front.data;
        front = front.next;
        if (front == rear)
            rear = null;
        length--;
        return result;
    }

    public int first() {
        if (isEmpty())
            throw new NoSuchElementException();

        return front.data;
    }

    public int last() {
        if (isEmpty())
            throw new NoSuchElementException();

        return rear.data;
    }
}
