public class LinkRemove {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head = null;
    Node tail = null;

    public void addNode(int data) {
        Node newNode = new Node(data);
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
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
    }

    public void remains(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.data == temp2.data) {
                temp1 = temp1.next;
                temp2 = head2;
            } else {
                temp2 = temp2.next;
            }
        }
        if (temp2 == null) {
            System.out.print("Extra Element\t" + temp1.data);
        }
    }

    public static void main(String[] args) {
        LinkRemove l1 = new LinkRemove();
        LinkRemove l2 = new LinkRemove();

        l2.addNode(1);
        l2.addNode(2);
        l2.addNode(3);
        l2.addNode(4);
        l2.addNode(5);

        l1.addNode(2);
        l1.addNode(3);
        l1.addNode(1);
        l1.addNode(6);
        l1.addNode(4);
        l1.addNode(5);

        l1.display();
        System.out.println("\n");
        l2.display();
        System.out.println("\n");
        l1.remains(l1.head, l2.head);
    }
}
