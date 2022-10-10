public class SumLL {
    class Node {
        int data1;
        int data2;
        Node next;

        Node(int data) {
            this.data1 = data;
        }

        Node(int data1, int data2) {
            this.data1 = data1;
            this.data2 = data2;
        }
    }

    Node head = null;
    Node tail = null;

    public void AddNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public void insert(int data1, int data2) {
        Node newNode = new Node(data1, data2);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data1 + "\t");
            temp = temp.next;
        }
    }

    public void displayresult() {
        Node temp = head;
        while (temp != null) {
            System.out.println("Combination are:" + temp.data1 + "," + temp.data2);
            temp = temp.next;
        }
    }

    public void sumFinder(int target) {
        SumLL result = new SumLL();
        Node temp = head;
        while (temp != null) {
            Node current = temp.next;
            while (current != null) {
                if (current.data1 + temp.data1 == target) {
                    result.insert(current.data1, temp.data1);
                }
                current = current.next;
            }
            temp = temp.next;
        }
        result.displayresult();
    }

    public static void main(String[] args) {
        SumLL l1 = new SumLL();
        l1.AddNode(10);
        l1.AddNode(0);
        l1.AddNode(5);
        l1.AddNode(4);
        l1.AddNode(5);
        l1.AddNode(6);
        l1.display();
        l1.sumFinder(10);
    }
}
