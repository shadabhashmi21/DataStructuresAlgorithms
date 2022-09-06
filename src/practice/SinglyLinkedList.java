package practice;

public class SinglyLinkedList {
    private ListNode head;

    private static class ListNode{
        private final int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public void display(){
        ListNode current = head;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void count(){
        int counter = 0;
        ListNode current = head;
        while (current != null) {
            counter++;
            current = current.next;
        }
        System.out.println("count " + counter);
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
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void insertAt(int index, int data){
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
        head = temp.next;
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

    public void deleteAt(int index, int data){
        ListNode newNode = new ListNode(data);

        if(index ==1){
            head = head.next;
            return;
        }

        ListNode previous = head;
        int counter = 1;
        while (counter < index){
            counter++;
            previous = previous.next;
        }
        ListNode current = previous.next;
        previous.next = current.next;
    }

    public void searchElement(int data){
        ListNode current = head;
        int index = 1;
        while (current != null){
            if (current.data == data){
                System.out.println("Element found " + data + " at " + index);
                return;
            }
            index++;
            current = current.next;
        }
        System.out.println("Element not found");
    }

    public void reverse(){
        if (head == null) return;

        ListNode current = head, previous = null, next;
        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    public void getMiddleNode(){
        if (head == null) return;

        ListNode fastPtr = head, slowPtr = head;
        while (fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        System.out.println("Middle node = " + slowPtr);
    }

    public void findNthFromLast(int index){
        if (head == null) return;

        ListNode mainPtr = head, refPtr = head;
        int counter = 0;
        while (counter < index){
            refPtr = refPtr.next;
            counter++;
        }
        while (refPtr != null){
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }

        System.out.println(mainPtr.data);
    }

    public void removeDuplicateFromSortedLinkedList(){
        if (head == null) return;

        ListNode current = head;
        while (current != null){
            if (current.data == current.next.data)
                current = current.next.next;
            else
                current = current.next;
        }
    }


}