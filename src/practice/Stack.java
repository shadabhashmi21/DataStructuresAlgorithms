package practice;

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
        ListNode newNode = new ListNode(data);

        newNode.next = top;
        top = newNode;
        length++;
    }

    public int pop(){
        if (isEmpty())
            throw new EmptyStackException();

        int result = top.data;
        top = top.next;
        length--;
        return result;
    }

    public int peek(){
        if (isEmpty())
            throw new EmptyStackException();

        return top.data;
    }
}
