package linkedlist.practice;

import java.util.NoSuchElementException;

public class PracticeDoublyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int length;
    public static class ListNode{
        private ListNode next;
        private ListNode previous;
        private int data;

        public ListNode(int data){
            this.data = data;
        }
    }

    public PracticeDoublyLinkedList(){
        head = null;
        tail = null;
        length = 0;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void displayForward(){
        ListNode current = head;
        while (current != null){
            System.out.println(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void displayBackward(){
        ListNode current = tail;
        while (current != null){
            System.out.println(current.data + " --> ");
            current = current.previous;
        }
        System.out.println("null");
    }

    public void insertFirst(int data){
        ListNode newNode = new ListNode(data);

        if (isEmpty()){
            tail = newNode;
        }else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    public void insertLast(int data){
        ListNode newNode = new ListNode(data);

        if (isEmpty()){
            head = newNode;
        }else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        length++;
    }

    public void deleteFirst(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }

        ListNode temp = head;
        if (head == tail){
            tail = null;
        }else {
            head.next.previous = null;
        }
        head = head.next;
        temp.next = null;
    }

    public void deleteLast(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }

        ListNode temp = tail;
        if (head == tail){
            head = null;
        }else {
            tail.previous.next = null;
        }
        tail = tail.previous;
        temp.previous = null;
    }
}
