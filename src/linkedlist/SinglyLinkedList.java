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
            previous.next = newNode;
            newNode.next = current;
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

    public void getMiddleNode(){
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

    public void findNthFromLast(int index){
        if(head == null)
            return;

        ListNode mainPtr = head;
        ListNode refPtr = head;
        int count = 0;
        while (count < index){
            refPtr = refPtr.next;
            count++;
        }
        while (refPtr != null){
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        System.out.println(mainPtr.data);
    }

    public void removeDuplicateFromSortedLinkedList(){
        if(head == null){
            return;
        }
        ListNode current = head;
        while (current.next != null){
            if(current.data == current.next.data){
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }
    }

    public void insertNodeInSortedLinkedList(int data){
        ListNode newNode = new ListNode(data);

        if(head == null){
            head = newNode;
            return;
        }

        if(head.data >= newNode.data){
            newNode.next = head;
            head = newNode;
            return;
        }

        ListNode current = head;
        ListNode temp = null;
        while (current != null && current.data < newNode.data){
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        temp.next = newNode;
    }

    public void removeGivenKey(int key){

        ListNode current = head;
        ListNode prev = null;

        if(current != null && current.data == key){
            head = current.next;
            return;
        }

        while (current != null && current.data != key){
            prev = current;
            current = current.next;
        }
        if(current == null){
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
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(fastPtr == slowPtr){
                System.out.println("Loop Detected");
                return;
            }
        }
        System.out.println("Loop not detected");
    }

    public void startOfLoop(){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (fastPtr != null && fastPtr.next !=  null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(fastPtr == slowPtr){
                //getStartingNode(slowPtr);
                removeLoop(slowPtr);
                break;
            }
        }
    }

    //Floyd's Cycle Detection Algorithm
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
            if(l1.data <= l2.data){
                tail.next = l1;
                l1 = l1.next;
            }else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 == null) {
            tail.next = l2;
        }else {
            tail.next = l1;
        }
        head = dummy.next;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        /*sll.head = new ListNode(10);
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
        sll.insertAt(1,5);
        sll.insertAt(4,20);
        sll.removeDuplicateFromSortedLinkedList();
        sll.insertNodeInSortedLinkedList(25);
        sll.removeGivenKey(20);

        sll.display();
        sll.count();*/

        /*sll.createLoopInLinkedList();
        sll.containsLoop();
        sll.startOfLoop();
        sll.display();*/

        /*sll.reverse();
        sll.display();
        sll.getMiddleNode();
        sll.findNthFromLast(2);*/

        SinglyLinkedList sll1 = new SinglyLinkedList();
        sll1.head = new ListNode(1);
        sll1.insertLast(3);
        sll1.insertLast(5);

        SinglyLinkedList sll2 = new SinglyLinkedList();
        sll2.head = new ListNode(2);
        sll2.insertLast(4);
        sll2.insertLast(6);

        sll1.display();
        sll2.display();

        SinglyLinkedList res = new SinglyLinkedList();
        res.mergeTwoSortedList(sll1.head, sll2.head);
        res.display();
    }
}
