package practice;

import java.util.NoSuchElementException;

public class CircularLinkedList {
    private ListNode last;
    private int length;

   private static class ListNode{
       private final int data;
       private ListNode next;

       private ListNode(int data) {
           this.data = data;
       }
   }

   public CircularLinkedList(){
       last = null;
       length = 0;
   }

   public boolean isEmpty() {
       return length == 0;
   }

   public int getLength() {
       return length;
   }

   public void display(){
       if (isEmpty()) return;

       ListNode first = last.next;
       while (first != last) {
           System.out.println(first.data + " ");
           first = first.next;
       }
       System.out.println(first.data);
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

       if (isEmpty()){
           last = newNode;
           last.next = last;
       }else {
           newNode.next = last.next;
           last.next = newNode;
           last = newNode;
       }
       length++;
   }

   public void insertLast(int data){
       ListNode newNode = new ListNode(data);

       if (isEmpty()){
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
       if (isEmpty())
           throw new NoSuchElementException();

       ListNode temp = last.next;
       if (temp.next == null)
           last.next = null;
       else
           last.next = temp.next;
       temp.next = null;
       length--;
   }
}