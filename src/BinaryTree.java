/**
 * My implementation of a binary tree using my Node class
 * Can traverse and use other operations
 * Automatically creates preOrder and postOrder stacks when traversing
 *
 * @author Tyson Craner
 */
class BinaryTree {

    private Node root;
    Stack preOrder;
    Stack postOrder;

    // set the root of the binary tree
    void setRoot(Node n) {
        this.root = n;
        this.preOrder = new Stack();
        this.postOrder = new Stack();
    }

    // perform preorder traversal and sets preorder stack
    void traversePreorder(Node node) {
        if (node == null || node.get().equals("_"))
            return;

        this.preOrder.push(node.get());
        System.out.print(node.get() + " ");
        traversePreorder(node.getLeft());
        traversePreorder(node.getRight());
    }

    // perform postorder traversal and set postorder stack
    void traversePostorder(Node node) {
        if (node == null || node.get().equals("_"))
            return;

        traversePostorder(node.getLeft());
        traversePostorder(node.getRight());
        this.postOrder.push(node.get());
        System.out.print(node.get() + " ");
    }

    // return the root of the binary tree
    Node getRoot() {
        return root;
    }

    // stack in preorder format
    Stack getPreOrder() {
        return this.preOrder;
    }

    // stack in postorder format
    Stack getPostOrder() {
        return this.postOrder;
    }
}