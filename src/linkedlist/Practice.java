package linkedlist;

public class Practice {

    private ListNode head;
    private static class ListNode{
        private final int data;
        private ListNode next;

        private ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private void display(){
        ListNode current = head;
        while (current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void count(){
        ListNode current = head;
        int counter = 0;
        while (current != null){
            counter++;
            current = current.next;
        }
        System.out.println("Length of linked list = "+counter);
    }

    public void insertFirst(int data){
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertLast(int data){
        ListNode newNode = new ListNode(data);

        if(head == null){
            head = newNode;
            return;
        }

        ListNode current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }

    public void insertAt(int data, int index){
        ListNode newNode = new ListNode(data);

        if(index == 1){
            newNode.next = head;
            head = newNode;
            return;
        }

        int counter = 1;
        ListNode previous = head;
        while (counter < index-1){
            previous = previous.next;
            counter++;
        }
        ListNode current = previous.next;
        previous.next = newNode;
        newNode.next = current;
    }

    public void deleteFirst(){
        if(head == null){
            return;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
    }

    public void deleteLast(){
        if(head == null || head.next == null){
            return;
        }

        ListNode current = head;
        ListNode previous = null;
        while (current.next != null){
            previous = current;
            current = current.next;
        }
        previous.next = null;
    }

    public void deleteAt(int index){
        if(index == 1){
            head = head.next;
            return;
        }
        int counter = 1;
        ListNode previous = head;
        while (counter < index-1){
            previous = previous.next;
            counter++;
        }
        ListNode current = previous.next;
        previous.next = current.next;
    }

    public static void main(String[] args) {
        Practice sl = new Practice();

        sl.insertFirst(10);
        sl.insertFirst(5);
        sl.insertLast(15);
        sl.insertLast(18);
        sl.insertLast(20);
        sl.insertAt(12, 3);
        sl.deleteFirst();
        sl.deleteLast();
        sl.deleteAt(3);

        sl.display();
        sl.count();
    }
}
