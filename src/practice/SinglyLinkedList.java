package practice;

public class SinglyLinkedList {
    private ListNode head;

    public static class ListNode{
        private final int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public void display() {
        ListNode current = head;
        while (current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.print("null");
    }

    public void count() {
        ListNode current = head;
        int counter = 0;
        while (current != null){
            counter++;
            current = current.next;
        }
        System.out.println("Length: " + counter);
    }

    public void insertFirst(int data){
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertLast(int data){
        ListNode newNode = new ListNode(data);

        if (head == null){
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

        if (index == 1){
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
        if (head == null) return;

        ListNode temp = head;
        head = head.next;
        temp.next = null;
    }

    public void deleteLast(){
        if (head == null || head.next == null) return;

        ListNode current = head, previous = null;
        while (current.next != null){
            previous = current;
            current = current.next;
        }

        previous.next = null;
    }

    public void deleteAt(int index){
        if (index == 1){
            head = head.next;
            return;
        }

        int counter = 1;
        ListNode previous = head;
        while (counter < index -1 ){
            previous = previous.next;
            counter++;
        }

        ListNode current = previous.next;
        previous.next = current.next;
    }

    public void searchElement(int data){
        int index = 1;
        ListNode current = head;

        while (current != null){
            if (current.data == data){
                System.out.println("Element found at index " + index);
                return;
            }
            index++;
            current = current.next;
        }

        System.out.println("Element not found");
    }

    public void reverse(){
        if (head == null) return;

        ListNode current = head, previous = null, next = null;
        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }


}