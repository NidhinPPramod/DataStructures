public class Queue {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node front = null;
    Node rear = null;

    public void enQueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public void deQueue() {
        if (front == null) {
            System.out.println("Empty!!");
            return;
        }
        front = front.next;
    }

    public void display() {
        Node temp = front;
        if (temp == null) {
            System.out.println("Empty!!");
        }
        while (temp != null) {
            System.out.println(temp.data + "\t");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.display();
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.display();
        queue.deQueue();
        queue.display();
    }
}
// using array:TimeComplexity:O(n)
// usingLinkList:TimeComplexity:O(1)