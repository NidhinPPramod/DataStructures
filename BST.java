import java.util.Stack;

public class BST {
    class Node {
        Node lchild;
        Node rchild;
        int data;

        Node(int d) {
            data = d;
        }
    }

    Node root = null;

    public void insert(int data) {
        Node current = root;
        if (current == null) {
            root = new Node(data);
            return;
        }
        while (true) {
            if (current.data < data) {
                if (current.rchild == null) {
                    current.rchild = new Node(data);
                    break;
                } else {
                    current = current.rchild;
                }
            } else {
                if (current.lchild == null) {
                    current.lchild = new Node(data);
                    break;
                } else {
                    current = current.lchild;
                }
            }
        }
    }

    public void inOrder(Node node, int key) {
        if (node != null) {
            inOrder(node.lchild, key);
            if (node.data == key) {
                System.out.println("Found");
                return;
            }
            inOrder(node.rchild, key);
        }

    }

    public int getMin(Node temp) {
        Node prev = temp;
        temp = temp.rchild;
        while (temp.lchild != null) {
            prev = temp;
            temp = temp.lchild;
        }
        while (temp.rchild != null) {
            prev.rchild = temp.rchild;
        }
        return temp.data;
    }

    public int getMax(Node node) {
        Node temp = node;
        Node prev = null;
        temp = temp.lchild;
        while (temp.rchild != null) {
            prev = temp;
            temp = temp.rchild;
        }
        while (temp.lchild != null) {
            prev.lchild = temp.lchild;
        }
        return temp.data;
    }

    public void delete(int key) {
        Node current = root;
        while (current != null) {
            if (current.data < key) {
                current = current.rchild;
            } else if (current.data > key) {
                current = current.lchild;
            } else {
                if (current.rchild != null) {
                    current.data = getMin(current);
                } else if (current.lchild != null) {
                    current.data = getMax(current);
                } else
                    current.data = getMin(current);
                System.out.println("Deleted Success");
            }
        }
        System.out.println("Data not found");
    }

    public int maxDepth(Node node) {
        if (node == null) {
            return -1;
        }
        int lh = maxDepth(node.lchild);
        int rh = maxDepth(node.rchild);

        return 1 + Math.max(lh, rh);
    }

    public int findClosest(int target) {
        Node current = root;
        int closest = current.data;
        while (current != null) {
            if (Math.abs(target - closest) > Math.abs(target - current.data)) {
                closest = current.data;
            }
            if (target < current.data) {
                current = current.lchild;
            } else if (target > current.data) {
                current = current.rchild;
            } else {
                break;
            }
        }
        return closest;
    }

    public void InorderIt() {
        Stack<Node> st = new Stack<>();
        Node temp = root;
        while (true) {
            while (temp != null) {
                st.push(temp);
                temp = temp.lchild;
            }
            if (st.isEmpty()) {
                break;
            }
            temp = st.pop();
            System.out.println(temp.data);
            temp = temp.rchild;
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(4);
        tree.insert(5);
        tree.insert(8);
        tree.insert(7);
        tree.insert(3);
        tree.insert(2);
        tree.InorderIt();
        tree.inOrder(tree.root, 1);
        // tree.delete(7);
        System.out.println("closest" + tree.findClosest(6));
        System.out.println("Depth" + tree.maxDepth(tree.root));
    }
}