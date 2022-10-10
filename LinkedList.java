public class LinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }

        Node() {
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

    public Node RotateRight(int k) {
        // specialcase
        while (head == null || k == 0 || head.next == null)
            return head;
        // length
        Node current = head;
        int l = 1;
        while (current.next != null) {
            l++;
            current = current.next;
        }
        // creating circular ll
        current.next = head;
        k = l - k % l;
        while (k-- > 0)
            current = current.next;
        head = current.next;
        current.next = null;
        return head;
    }

    public Node RotateRght(int k) {
        for (int i = 0; i < k; i++) {
            Node temp = head;
            Node prev = null;
            while (temp != tail) {
                prev = temp;
                temp = temp.next;
            }
            tail.next = head;
            head = tail;
            tail = prev;
            tail.next = null;
        }
        return head;
    }

    public Node RotateLeft(int k) {
        for (int i = 0; i < k; i++) {
            Node temp = head.next;
            tail.next = head;
            head.next = null;
            tail = head;
            head = temp;
        }
        return head;
    }

    public void RemoveNth(int k) {
        Node start = new Node();
        start.next = head;
        Node fast, slow;
        fast = slow = head;
        for (int i = 1; i <= k; i++) {
            fast = fast.next;
            if (fast == null) {
                head = head.next;
                return;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
    }

    public void nextHigh(int key) {
        Node temp = head;
        int closest = temp.data;
        while (temp != null) {
            if (Math.abs(key - closest) > Math.abs(key - temp.data)) {
                closest = temp.data;
            }
            temp = temp.next;
        }
        System.out.println(closest);

    }

    public void fun(Node head) {
        Node current = head;
        if (current == null)
            return;
        fun(current.next);
        System.out.println(current.data);
    }

    public static void main(String[] args) {
        LinkedList Lnk = new LinkedList();
        Lnk.addnode(1);
        Lnk.addnode(2);
        Lnk.addnode(3);
        Lnk.addnode(4);
        // Lnk.fun(Lnk.head);
        // Lnk.reverseList();
        // Lnk.display();
        // Lnk.addnode(50);
        // Lnk.display();
        // Lnk.removeDuplicates();
        Lnk.display();

        // Lnk.delete(30);
        // Lnk.insertAfter(10, 40);
        // Lnk.nextHigh(32);
        // Lnk.RotateRght(2);
        // Lnk.display();
        // Lnk.RotateRight(1);
        // Lnk.display();
        // Lnk.RemoveNth(1);
        // Lnk.display();
    }
}
