import javax.xml.crypto.Data;

public class LinkedList {

    // Creating a node
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public void addFirst(int data) { // Add element at starting of linkedList
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) { // Add element at ending of linkedList
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print() { // to print List elements
        if (head == null) {
            System.out.println(" list tis empty");
        }
        Node temp = head;
        while (temp != null) {

            System.out.print(" " + temp.data + " ");
            temp = temp.next;
        }
        System.out.println("null");

    }

   
    public static Node mergeSort(Node head) {   // Merge sort
        if (head == null || head.next == null) {
            return head;
        }
        // find mid
        Node mid = getMid(head);
        // left and right mergeSort
        Node rightHead = mid.next;
        mid.next = null;
        Node newleft = mergeSort(head); // left half
        Node newRight = mergeSort(rightHead); // right half
        // merge
        return merge(newleft, newRight);
    }
    public static Node merge(Node newLeft, Node newRight) {  // merge
        Node mergedll = new Node(-1);
        Node temp = mergedll;
        while (newLeft != null && newRight != null) {
            if (newLeft.data <= newRight.data) {
                temp.next = newLeft;
                temp = temp.next;
                newLeft = newLeft.next;
            } else {
                temp.next = newRight;
                temp = temp.next;
                newRight = newRight.next;
            }
        }
        while (newLeft != null) {
            temp.next = newLeft;
            temp = temp.next;
            newLeft = newLeft.next;
        }
        while (newRight != null) {
            temp.next = newRight;
            temp = temp.next;
            newRight = newRight.next;
        }

        return mergedll.next;

    }
    public static Node getMid(Node head) { // getMid
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String args[]) {

        LinkedList ll = new LinkedList();

        ll.addFirst(45);
        ll.addFirst(454);
        ll.addFirst(545);
        ll.addFirst(4454);
        ll.addLast(5);

        ll.print();
        ll.head = ll.mergeSort(ll.head);
        ll.print();

    }

}