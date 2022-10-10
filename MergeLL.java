import java.util.Scanner;

public class MergeLL {
    class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;

        }
    }

    Node head = null;
    Node tail = null;

    public void AddNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            Node temp = head;
            Node prev = null;
            while (temp.data < data) {
                if (temp == tail) {
                    tail.next = newNode;
                    tail = newNode;
                    break;
                }
                prev = temp;
                temp = temp.next;
            }
            if (temp.data >= data && temp != head) {
                prev.next = newNode;
                newNode.next = temp;
            }
            if (temp.data >= data && temp == head) {
                newNode.next = head;
                head = newNode;
            }
        }

    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
    }

    public void merge(Node tail1, Node head2) {
        tail1.next = head2;
    }

    public void sort() {
        for (Node temp = head; temp != null; temp = temp.next) {
            for (Node count = temp.next; count != null; count = count.next) {
                if (temp.data > count.data) {
                    int swap = temp.data;
                    temp.data = count.data;
                    count.data = swap;
                }
            }
        }
    }

    public static void main(String[] args) {
        MergeLL l1 = new MergeLL();
        MergeLL l2 = new MergeLL();
        MergeLL result = new MergeLL();
        Scanner sc = new Scanner(System.in);
        int choice;
        int data;
        int c = 0;

        do {
            System.out
                    .println(
                            "Enter choice\n1.Add node to first list\n2.add node to second list\n3.Dispplay merged list\n");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter data to be inserted");
                    data = sc.nextInt();
                    l1.AddNode(data);
                    break;
                case 2:
                    System.out.println("Enter data to be inserted");
                    data = sc.nextInt();
                    l2.AddNode(data);
                    break;
                case 3:
                    System.out.println("Merged List");
                    result.merge(l1.tail, l2.head);
                    l1.sort();
                    l1.display();
                    break;
                case 4:
                    System.out.println("Display list 1");
                    l1.display();
                    break;
                case 5:
                    System.out.println("Display list 2");
                    l2.display();
                    break;
            }
            System.out.println("1 or 0?");
            c = sc.nextInt();
        } while (c == 1);
        l1.AddNode(10);
        l1.AddNode(5);
        l1.AddNode(8);
        l1.AddNode(2);
        l1.AddNode(1);
        l1.AddNode(25);
        System.out.println("First LL");
        l1.display();
        l2.AddNode(2);
        l2.AddNode(10);
        l2.AddNode(5);
        l2.AddNode(3);
        System.out.println("\nsecond LL");
        l2.display();
        System.out.println("\nMerged List");

        result.merge(l1.tail, l2.head);
        l1.sort();
        l1.display();
    }
}
