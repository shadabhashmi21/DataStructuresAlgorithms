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

        current.next = newNode;
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
        }else {
            ListNode previous = head;
            int count = 1;
            while (count < index-1){
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = current.next;
        }
    }

    public void searchElement(int data){
        int index = 1;
        ListNode current = head;
        while (current != null){
            if(current.data == data){
                System.out.println("Element found at " + index + " index");
                return;
            }
            index++;
            current = current.next;
        }
        System.out.println("Element not found");
    }

    public void reverse(){
        if(head == null){
            return;
        }

        ListNode current = head;
        ListNode next;
        ListNode previous = null;
        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    public void findMiddleNode(){
        if (head == null)
            return;

        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        System.out.println("Middle node = "+slowPtr.data);
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
        sll.insertLast(41);
        sll.insertLast(42);
        sll.insertLast(43);
        sll.insertAt(5,8);
        sll.deleteFirst();
        sll.deleteFirst();
        sll.deleteLast();
        sll.deleteAt(2);
        sll.searchElement(5);

        sll.display();
        sll.count();

        sll.reverse();
        sll.display();
        sll.findMiddleNode();
    }
}
