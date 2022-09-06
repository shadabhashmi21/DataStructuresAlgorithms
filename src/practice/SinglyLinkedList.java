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

    public void insertNodeInSortedLinkedList(int data){
        ListNode newNode = new ListNode(data);

        if (head == null){
            head = newNode;
            return;
        }

        if (head.data >= newNode.data){
            newNode.next = head;
            head = newNode;
            return;
        }

        ListNode current = head, temp = null;
        while (current.data <= newNode.data){
            temp = current;
            current = current.next;
        }
        temp.next = newNode;
        newNode.next = current;
    }

    public void removeGivenKey(int key){
        ListNode current = head, prev = null;

        if (current != null && current.data == key){
            head = current.next;
            return;
        }

        while (current != null && current.data != key) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Element not found");
            return;
        }
        prev.next = current.next;
    }

    public void createLoopInLinkedList(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;
    }

    public void containsLoop(){
        ListNode fastPtr = head, slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                System.out.println("Loop Detected");
                return;
            }
            System.out.println("Loop not detected");
        }
    }

    public void startOfLoop(){
        ListNode fastPtr = head, slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {

                return;
            }
        }
    }

    public void getStartingNode(ListNode node){
        ListNode temp = head;
        while (temp != node){
            temp = temp.next;
            node = node.next;
        }
        System.out.println("Starting node = " + node.data);
    }

    public void removeLoop(ListNode node){
        ListNode temp = head;
        while (temp.next != node.next){
            temp = temp.next;
            node = node.next;
        }
        node.next = null;
    }

    public void mergeTwoSortedList(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (l1 != null && l2 != null){
            if (l1.data <= l2.data){
                tail.next = l1;
                l1 = l1.next;
            }else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
            if (l1 == null)
                tail.next = l2;
            else
                tail.next = l1;

            head = dummy.next;
        }
    }
}