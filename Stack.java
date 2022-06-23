public class Stack {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node top = null;

    public void push(int data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }

    }

    public void pop() {
        if (top == null) {
            System.out.println("Stack Underflow!");
            return;
        }
        top = top.next;
    }

    public void display() {
        Node temp = top;
        if (temp == null) {
            System.out.println("Stack Underflow!");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.display();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.display();
        stack.pop();
        stack.pop();
        stack.display();
    }
}
