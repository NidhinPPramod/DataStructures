public class sortLL {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }

        Node() {
        }
    }

    Node head, tail;

    public void addNode(int data) {
        Node newNode = new Node(data);
        Node temp = head;
        if (temp == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public void sortedInsert(int data) {
        Node start = new Node();
        Node newnd = new Node(data);
        Node point;
        start.next = head;
        point = start;
        while (point.next != null) {
            while (point.next.data > data) {
                if (point.next == head) {
                    newnd.next = head;
                    head = newnd;
                    return;
                }
            }
            while (point.next.data < data) {
                if (point.next == tail) {
                    tail.next = newnd;
                    tail = newnd;
                    return;
                }
                point = point.next;
            }
            break;
        }

        newnd.next = point.next;
        point.next = newnd;
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

    public static void main(String[] args) {
        sortLL sl = new sortLL();
        sl.addNode(10);
        sl.addNode(20);
        sl.addNode(40);
        sl.sortedInsert(-2);
        sl.sortedInsert(60);
        sl.display();
    }
}
