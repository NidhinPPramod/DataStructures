public class DDLink {
    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    Node head = null;
    Node tail = null;

    public void Addnode(int data) {
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

    public int count() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void rearrange() {
        Node temp = head;
        Node prev = null;
        Node end = tail;
        if (count() % 2 == 0) {
            while (temp.next != end) {
                prev = temp;
                temp = temp.next.next;
                Node newNode = new Node(prev.next.data);
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
                prev.next = temp;
            }
        } else {
            while (temp != end) {
                prev = temp;
                temp = temp.next.next;
                Node newNode = new Node(prev.next.data);
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
                prev.next = temp;
            }
        }

    }

    public static void main(String[] args) {
        DDLink obj = new DDLink();
        obj.Addnode(1);
        obj.Addnode(2);
        obj.Addnode(3);
        obj.Addnode(4);
        obj.Addnode(5);
        obj.Addnode(6);
        obj.Addnode(7);
        obj.Addnode(8);
        obj.Addnode(9);

        obj.rearrange();
        obj.display();
    }
}