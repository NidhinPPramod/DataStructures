import java.util.Stack;

public class BinarySearchTree {
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

    public boolean contains(int data) {
        Node currentNode = root;
        while (currentNode != null) {
            if (data < currentNode.data) {
                currentNode = currentNode.left;
            } else if (data > currentNode.data) {
                currentNode = currentNode.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public void remove(int data) {
        removeHelper(data, root, null);
    }

    public void removeHelper(int data, Node currentNode, Node parentNode) {
        while (currentNode != null) {
            if (data < currentNode.data) {
                parentNode = currentNode;
                currentNode = currentNode.left;
            } else if (data > currentNode.data) {
                parentNode = currentNode;
                currentNode = currentNode.right;
            } else {
                if (currentNode.left != null && currentNode.right != null) {
                    currentNode.data = getMinValue(currentNode.right);
                    removeHelper(currentNode.data, currentNode.right, currentNode);
                } else {
                    if (parentNode == null) {
                        if (currentNode.right == null) {
                            root = currentNode.left;
                        } else {
                            root = currentNode.right;
                        }
                    } else {
                        if (parentNode.left == currentNode) {
                            if (currentNode.right == null) {
                                parentNode.left = currentNode.left;
                            } else {
                                parentNode.left = currentNode.right;
                            }
                        } else {
                            if (currentNode.right == null) {
                                parentNode.right = currentNode.left;
                            } else {
                                parentNode.right = currentNode.right;
                            }
                        }
                    }
                }
                break;
            }
        }
    }

    public int getMinValue(Node currentNode) {
        if (currentNode.left == null) {
            return currentNode.data;
        } else {
            return getMinValue(currentNode.left);
        }
    }

    public void inOrder() {
        inOrderHelper(root);
    }

    public void inOrderHelper(Node node) {
        if (node != null) {
            inOrderHelper(node.left);
            System.out.print(node.data + " ");
            inOrderHelper(node.right);
        }
    }

    public void preOrder() {
        preOrderHelper(root);
    }

    public void preOrderHelper(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderHelper(node.left);
            preOrderHelper(node.right);
        }
    }

    public void postOrder() {
        postOrderHelper(root);
    }

    public void postOrderHelper(Node node) {
        if (node != null) {
            postOrderHelper(node.left);
            postOrderHelper(node.right);
            System.out.print(node.data + " ");
        }
    }

    public int findClosest(int target) {
        Node current = root;
        int closest = current.data;
        while (current != null) {
            if (Math.abs(target - closest) > Math.abs(target - current.data)) {
                closest = current.data;
            }
            if (target < current.data) {
                current = current.left;
            } else if (target > current.data) {
                current = current.right;
            } else {
                break;
            }
        }
        return closest;
    }

    public void inOrderIt() {
        Stack<Node> st = new Stack<>();
        Node temp = root;
        while (true) {
            while (temp != null) {
                st.push(temp);
                temp = temp.left;
            }
            if (st.isEmpty()) {
                break;
            }
            temp = st.pop();
            System.out.println(temp.data);
            temp = temp.right;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(8);
        bst.insert(11);
        bst.insert(4);
        bst.insert(9);
        System.out.println(bst.contains(4));
        System.out.println(bst.contains(3));
        bst.inOrder();
        System.out.println();
        bst.inOrderIt();
        // bst.preOrder();
        // System.out.println();
        // bst.postOrder();
        // System.out.println();
        // System.out.println(bst.findClosest(5));
    }
}