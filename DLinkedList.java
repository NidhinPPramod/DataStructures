public class DLinkedList {
    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
    }

    public void display() {
        Node temp = head;
        if (temp == null) {
            System.out.println("Empty !!");
        }
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void displayBackward() {
        Node temp = tail;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.prev;
        }
    }

    public void delete(int data) {
        Node temp = head, prev = null;
        if (temp != null && temp.data == data) {
            head = temp.next;
            temp.next.prev = null;
            return;
        }
        while (temp != null && temp.data != data) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Data Not Found!!");
            return;
        }
        if (temp == tail) {
            tail = prev;
            tail.next = null;
            return;
        }
        prev.next = temp.next;
        temp.next.prev = prev;
    }

    public void insertNext(int nextTo, int data) {
        Node temp = head;
        Node newNode = new Node(data);
        if (temp != null && temp.data == nextTo) {
            newNode.next = temp.next;
            temp.next.prev = newNode;
            temp.next = newNode;
            newNode.prev = temp;
            return;
        }
        while (temp != null && temp.data != nextTo) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Data Not Found!!");
            return;
        }
        if (temp == tail) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            return;
        }
        newNode.next = temp.next;
        temp.next.prev = newNode;
        temp.next = newNode;
        newNode.prev = temp;

    }

    public void insertBefore(int beforeTo, int data) {
        Node temp = head;
        Node newNode = new Node(data);
        if (temp != null && temp.data == beforeTo) {
            newNode.next = temp;
            temp.prev = newNode;
            newNode.prev = null;
            head = newNode;
            return;
        }
        while (temp != null && temp.data != beforeTo) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Data Not Found!!");
            return;
        }
        if (temp == tail) {
            newNode.next = tail;
            tail.prev = newNode;
            return;
        }
        newNode.next = temp;
        temp.prev.next = newNode;
        newNode.prev = temp.prev;
        temp.prev = newNode;
        return;
    }

    public static void main(String[] args) {
        DLinkedList Dlnk = new DLinkedList();
        Dlnk.display();
        Dlnk.addNode(10);
        Dlnk.addNode(20);
        Dlnk.addNode(30);
        Dlnk.addNode(40);
        // Dlnk.delete(10);
        Dlnk.insertNext(20, 50);
        Dlnk.insertBefore(10, 60);
        Dlnk.display();
        Dlnk.displayBackward();
    }
}
