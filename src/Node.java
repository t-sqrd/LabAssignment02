/**
 * This class represents the recursive Nodes on a binary tree.
 *
 * @author Tyson Craner
 */
class Node {
    private Node left;
    private Node right;
    private String value;

    Node(String value) {
        this.value = value;
    }

    // get Node value
    String get() {
        return this.value;
    }

    // get right node
    Node getRight() {
        return this.right;
    }

    // set right node
    void setRight(Node node) {
        this.right = node;
    }

    // set left node
    void setLeft(Node node) {
        this.left = node;
    }

    // get left node
    Node getLeft() {
        return this.left;
    }
}

