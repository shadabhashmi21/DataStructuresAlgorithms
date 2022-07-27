package linkedlist;

public class Practice {

    private ListNode head;
    private static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void display(){
        ListNode current = head;
        while (current != null){
            System.out.print(current.data + "-> ");
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
        System.out.println("Length of linked list -> " + counter);
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

    public void deleteFirst(){
        head = head.next;
    }

    public void deleteLast(){
        if(head == null || head.next == null){
            return;
        }

        ListNode previous = null;
        ListNode current = head;

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

        ListNode previous = head;
        int counter = 1;
        while (counter < index-1){
            previous = previous.next;
            counter++;
        }

        ListNode current = previous.next;
        previous.next = current.next;
    }

    public void searchElement(int data){
        ListNode current = head;
        int index = 1;
        while (current != null){
            if (current.data == data){
                System.out.println("Element found at " + index);
                return;
            }
            index++;
            current = current.next;
        }
        System.out.println("Element not found");
    }

    public void reverse(){
        if(head == null)
            return;

        ListNode current = head;
        ListNode next = null, previous = null;
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

        ListNode fastPtr = head, slowPtr = head;
        while (fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        System.out.println("Middle Node = " + slowPtr.data);
    }

    public void getNthNodeFromLast(int index){
        if(head == null)
            return;

        ListNode refPtr = head, mainPtr = head;
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

    public void removeDuplicates(){
        if (head == null)
            return;

        ListNode current = head;
        while (current.next != null){
            if (current.data == current.next.data){
                current = current.next.next;
            }else {
                current = current.next;
            }
        }
    }

    public void insertNodeInSortedLinkedList(int data){
        ListNode newNode = new ListNode(data);

        if (head == null){
            head = newNode;
            return;
        }

        if(head.data >= data){
            newNode.next = head;
            head = newNode;
            return;
        }

        ListNode current = head, temp = null;
        while (current != null && current.data < newNode.data){
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        temp.next = newNode;
    }

    public void removeGivenKey(int key){
        ListNode current = head, temp = null;

        if(current != null && current.data == key){
            head = current.next;
            return;
        }

        while (current != null && current.data != key){
            temp = current;
            current = current.next;
        }

        if (current == null){
            System.out.println("Element not found");
            return;
        }

        temp.next = current.next;
    }

    public void createLoop(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;
    }

    public void containsLoop(){
        ListNode fastPtr = head, slowPtr = head;

        while (fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr){
                System.out.println("Loop Detected");
                return;
            }
        }
        System.out.println("Loop not detected");
    }

    public void startOfLoop(){
        ListNode fastPtr = head, slowPtr = head;

        while (fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr){
                getStartingNode(slowPtr);
                break;
            }
        }
    }

    public void getStartingNode(ListNode node){
        ListNode current = head;
        while (current != node){
            current = current.next;
            node = node.next;
        }
        System.out.println("Starting node = " + node.data);
    }

    public void removeLoop(ListNode node){
        ListNode current = head;
        while (current.next != node.next){
            current = current.next;
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
        }
        if (l1 == null) {
            tail.next = l2;
        }else {
            tail.next = l1;
        }
        head = dummy.next;
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