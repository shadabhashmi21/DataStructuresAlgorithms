package linkedlist;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int length;

    private static class ListNode {
        private final int data;
        private ListNode next;
        private ListNode previous;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void displayForward() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.print("null");
    }

    public void displayBackward() {
        ListNode current = tail;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.previous;
        }
        System.out.print("null");
    }

    public void insertFirst(int data) {
        ListNode newNode = new ListNode(data);

        if (isEmpty()) {
            tail = newNode;
        } else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    public void insertLast(int data) {
        ListNode newNode = new ListNode(data);

        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        length++;
    }

    public void deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        ListNode temp = head;
        if (head == tail) {
            tail = null;
        } else {
            head.next.previous = null;
        }
        head = head.next;
        temp.next = null;
    }

    public void deleteLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        ListNode temp = tail;
        if (head == tail) {
            head = null;
        } else {
            tail.previous.next = null;
        }
        tail = tail.previous;
        temp.previous = null;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertFirst(2);
        dll.insertFirst(1);
        dll.insertLast(4);
        dll.insertLast(5);
        dll.displayForward();

        dll.deleteFirst();
        dll.deleteLast();
        System.out.println();
        dll.displayForward();
    }
}
