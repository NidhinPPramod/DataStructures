public class BSTRank {
    class Node {
        int data;
        Node lchild;
        Node rchild;
        String name;

        Node(int data, String s) {
            this.data = data;
            this.name = s;
        }
    }

    Node root = null;

    public void addNode(int d, String s) {
        Node current = root;
        if (root == null) {
            root = new Node(d, s);
            return;
        }
        while (true) {
            if (current.data > d) {
                if (current.lchild == null) {
                    current.lchild = new Node(d, s);
                    break;
                } else {
                    current = current.lchild;
                }
            }
            if (current.rchild == null) {
                current.rchild = new Node(d, s);
                break;
            } else {
                current = current.rchild;
            }
        }
    }

    public void inOrder() {
        inOrderHelper(root);
    }

    public void inOrderHelper(Node r) {
        if (r != null) {
            inOrderHelper(r.lchild);
            System.out.print(r.data + " ");
            inOrderHelper(r.rchild);
        }
    }

    public void preOrder(String s) {
        preOrderHelper(root, s);
    }

    public void preOrderHelper(Node r, String s) {
        if (r != null) {
            if (r.name == s) {
                System.out.println();
                System.out.println(r.name);
                System.out.println(r.data);
            }
            preOrderHelper(r.lchild, s);
            preOrderHelper(r.rchild, s);
        }
    }

    public static void main(String[] args) {
        BSTRank bst = new BSTRank();
        bst.addNode(9, "sai");
        bst.addNode(10, "prav");
        bst.addNode(15, "adil");
        bst.addNode(20, "nikk");
        bst.addNode(25, "nidhin");
        bst.addNode(19, "fundesh");
        bst.inOrder();
        bst.preOrder("fundesh");
    }
}
