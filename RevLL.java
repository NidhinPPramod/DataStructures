import java.util.Stack;

public class RevLL {
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
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
        }
        tail = newNode;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public Node reverseList() {
        RevLL result = new RevLL();
        Stack<Integer> st = new Stack<Integer>();
        Node temp = head;
        while (temp != null) {
            st.push(temp.data);
            temp = temp.next;
        }
        while (!st.isEmpty()) {
            result.Addnode(st.pop());
        }
        result.display();
        return result.head;
    }

    public boolean check(Node head1, Node head2) {
        while (head1 != null) {
            while (head2 != null) {
                if (head1.data == head2.data) {
                    head2 = head2.next;
                    break;
                } else {
                    return false;
                }
            }
            head1 = head1.next;
        }
        return true;
    }

    public static void main(String[] args) {
        RevLL rv = new RevLL();
        rv.Addnode(1);
        rv.Addnode(2);
        rv.Addnode(2);
        rv.Addnode(1);
        rv.display();
        System.out.println("Reversed List:");
        if (rv.check(rv.reverseList(), rv.head)) {
            System.out.println("Paliandrome");
        } else {
            System.out.println("Not Paliandrome");
        }
    }
}
