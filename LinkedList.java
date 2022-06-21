public class LinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void addnode(int data) {
        Node newNode = new Node(data);
        Node temp = head;
        if (temp == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public void display() {
        Node temp = head;
        if (temp == null) {
            System.out.println("Empty List");
        }
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void delete(int data) {
        Node temp = head, prev = null;
        if (temp != null && temp.data == data) {
            head = temp.next;
            return;
        }
        while (temp != null && temp.data != data) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Data Not found!!");
            return;
        }
        if (temp == tail) {
            tail = prev;
            tail.next = null;
            return;
        }
        prev.next = temp.next;
    }

    public void insertAfter(int nextTo, int data) {
        Node newNode = new Node(data);
        Node temp = head;
        while (temp != null && temp.data != nextTo) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Data Not found!!");
            return;
        }
        if (temp == tail) {
            tail.next = newNode;
            tail = newNode;
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public static void main(String[] args) {
        LinkedList Lnk = new LinkedList();
        Lnk.display();
        Lnk.addnode(10);
        Lnk.addnode(20);
        Lnk.display();
        Lnk.delete(30);
        Lnk.insertAfter(10, 40);
        Lnk.display();
    }
}
