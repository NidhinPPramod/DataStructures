public class smltree {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    public void insert(int data) {
        Node currentNode = root;
        if (currentNode == null) {
            root = new Node(data);
            return;
        }
        while (true) {
            if (data < currentNode.data) {
                if (currentNode.left == null) {
                    currentNode.left = new Node(data);
                    break;
                } else {
                    currentNode = currentNode.left;
                }
            } else {
                if (currentNode.right == null) {
                    currentNode.right = new Node(data);
                    break;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }
    }

    public void findsmallest() {
        Node rtpoint = root.right;
        while (rtpoint.left != null) {
            rtpoint = rtpoint.left;
        }
        System.out.println(rtpoint.data);
    }

    public static void main(String[] args) {
        smltree bst = new smltree();
        bst.insert(8);
        bst.insert(3);
        bst.insert(10);
        bst.insert(1);
        bst.insert(6);
        bst.insert(4);
        bst.insert(7);
        bst.insert(14);
        bst.insert(13);
        bst.findsmallest();
    }
}
