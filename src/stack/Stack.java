package stack;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class Stack {
    private ListNode top;
    private int length;

    private static class ListNode{
        private final int data;
        private ListNode next;

        private ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Stack(){
        top = null;
        length = 0;
    }

    public int getLength(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void push(int data){
        ListNode temp = new ListNode(data);
        temp.next = top;
        top = temp;
        length++;
    }

    public void pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        }

        int result = top.data;
        top = top.next;
        length--;
        System.out.println("Popped Element = " + result);
    }

    public void peek(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        System.out.println("Peek Element = " + top.data);
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(10);
        stack.push(15);
        stack.push(20);

        stack.peek();
        stack.pop();
        stack.pop();
        stack.pop();
    }
}
