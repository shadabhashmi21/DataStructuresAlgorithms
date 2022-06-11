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

        sll.insertFirst(5);
        sll.insertFirst(4);
        sll.insertFirst(3);

        sll.display();
        sll.count();
    }
}
