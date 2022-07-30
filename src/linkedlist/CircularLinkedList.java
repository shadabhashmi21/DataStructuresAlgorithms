package linkedlist;

import java.util.NoSuchElementException;

public class CircularLinkedList {
    private ListNode last;
    private int length;

    private static class ListNode{
        private ListNode next;
        private final int data;

        public ListNode(int data){
            this.data = data;
        }
    }

    public CircularLinkedList(){
        last = null;
        length = 0;
    }

    public int getLength(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void display(){
        if (last == null){
            return;
        }
        ListNode first = last.next;
        while (first != last){
            System.out.print(first.data + " --> ");
            first = first.next;
        }
        System.out.print(first.data);
        System.out.println();
    }

    public void createCircularLinkedList(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;

        last = fourth;
    }

    public void insertFirst(int data){
        ListNode newNode = new ListNode(data);

        if (last == null){
            last = newNode;
        }else {
            newNode.next = last.next;
        }
        last.next = newNode;
        length++;
    }

    public void insertLast(int data){
        ListNode newNode = new ListNode(data);

        if (last == null){
            last = newNode;
            last.next = last;
        }else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public void deleteFirst(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        ListNode temp = last.next;
        if(last.next == last){
            last = null;
        }else {
            last.next = temp.next;
        }
        temp.next = null;
        length--;
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.createCircularLinkedList();
        cll.display();

        cll.insertFirst(6);
        cll.insertFirst(5);
        cll.insertLast(7);
        cll.insertLast(8);
        cll.deleteFirst();
        cll.display();
    }
}
