public class DelDll {
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
        while (temp != null) {
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
    }

    public void delete(int key) {
        Node temp = head;
        while (temp != null && temp.data == key) {
            head = temp.next;
            temp.prev = null;
            return;
        }
        while (temp != null && temp.data != key) {
            temp = temp.next;
        }
        if (temp == tail) {
            tail = temp.prev;
            tail.next = null;
            return;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    public void check() {
        Node temp;
        Node prev = null;
        int flag = 0;
        for (temp = head; temp.next != null; temp = temp.next) {
            for (prev = temp.next; prev.next != null; prev = prev.next) {
                if (prev.data > temp.data) {
                    flag = 1;
                } else if (prev.data < temp.data && flag == 1) {
                    System.out.println("Random");
                    return;
                }
            }
        }
        for (temp = head; temp.next != null; temp = temp.next) {
            for (prev = temp.next; prev.next != null; prev = prev.next) {
                if (prev.data < temp.data) {
                    flag = 0;
                } else if (prev.data > temp.data && flag == 0) {
                    System.out.println("Random");
                    return;
                }
            }
        }
        if (flag == 1) {
            System.out.println("Ascending");
        } else {
            System.out.println("Descending");
        }
    }

    public static void main(String[] str) {
        DelDll l = new DelDll();
        l.Addnode(10);
        l.Addnode(9);
        l.Addnode(8);
        l.Addnode(4);
        l.Addnode(6);
        l.Addnode(5);
        l.display();
        l.check();
    }
}
