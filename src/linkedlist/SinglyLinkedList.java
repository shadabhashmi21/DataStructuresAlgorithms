package linkedlist;

public class SinglyLinkedList {
    private ListNode head;

    private static class ListNode {
        private final int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void display() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + "-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void count() {
        int counter = 0;
        ListNode current = head;
        while (current != null) {
            counter++;
            current = current.next;
        }
        System.out.println("Length of linked list= " + counter);
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

        newNode.next = current;
    }

    public void insertAt(int index, int data){
        ListNode newNode = new ListNode(data);

        if(index == 1){
            newNode.next = head;
            head = newNode;
        }else {
            ListNode previous = head;
            int counter = 1;
            while (counter < index-1){
                previous = previous.next;
                counter++;
            }
            ListNode current = previous.next;
            newNode.next = current;
            previous.next = newNode;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new ListNode(10);
        ListNode second = new ListNode(20);
        ListNode third = new ListNode(30);
        ListNode fourth = new ListNode(40);

        // now linking the lists
        sll.head.next = second;
        second.next = third;
        third.next = fourth;

        /*sll.insertFirst(5);
        sll.insertFirst(4);
        sll.insertFirst(3);
        sll.insertLast(41);
        sll.insertLast(42);
        sll.insertLast(43);*/
        sll.insertAt(5,8);

        sll.display();
        sll.count();
    }
}
