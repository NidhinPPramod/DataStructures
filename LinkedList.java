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

    public void removeDuplicates() {
        Node current = head;
        while (current != null) {
            Node next = current.next;
            while (next != null && current.data == next.data) {
                next = next.next;
            }
            current.next = next;
            if (next == tail && current.data == tail.data) {
                tail = current;
                current.next = null;
            }
            current = next;
        }
    }

    public void reverseList() {
        Node current = head;
        Node temp = null;
        Node prev = null;
        Node temp_tail = tail;
        while (current != temp) {
            temp = current;
            while (temp != temp_tail) {
                prev = temp;
                temp = temp.next;
            }
            int swap = temp.data;
            temp.data = current.data;
            current.data = swap;

            current = current.next;
            temp_tail = prev;
        }

    }

    public static void main(String[] args) {
        LinkedList Lnk = new LinkedList();
        Lnk.display();
        Lnk.addnode(10);
        Lnk.addnode(20);
        Lnk.addnode(30);
        Lnk.addnode(40);
        Lnk.reverseList();
        Lnk.display();
        Lnk.addnode(50);
        Lnk.display();
        Lnk.removeDuplicates();
        Lnk.display();
        Lnk.delete(30);
        Lnk.insertAfter(10, 40);
        Lnk.display();
    }
}
