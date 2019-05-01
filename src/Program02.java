import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Tyson Craner
 * CSCI 2201
 * Lab Assignment 02
 * Friday, April 26th
 *
 * This lab takes a parsed .txt file in level-order format and creates a binary tree
 * Traverses this tree in pre and post order, and then sends traversed tree
 * to a stack to calculate in pre and post order.
 *
 * Outputs the binary tree in pre order and post order format with the
 * evaluated expression.
 *
 * @author Tyson Craner
 */
public class Program02 {

    public static void main(String[] args) {
        // check for proper arguments
        if (args.length != 1) {
            System.out.println("Proper usage is 'java Program02 [file].txt'");
            return;
        }
        // initialize
        new Program02(args[0]);
    }

    // reads the file and converts to an expression stack
    // then converts expression stack to a tree
    private Program02(String fileName) {
        BinaryTree bt = new BinaryTree();
        Stack expression = new Stack();

        try {
            Scanner scanner = new Scanner(new File(fileName));

            while (scanner.hasNext()) {
                String curChar = scanner.next();
                expression.push(curChar);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Node tree = createLevelOrder(expression, bt.getRoot(), 0, expression.length());

        // construct a binary tree to store parsed math expression
        bt.setRoot(tree);
        printInfo(bt);
    }

    // recursively create a level ordered tree
    private Node createLevelOrder(Stack s, Node root, int i, int n) {
        if (i < n) {
            // store temporary Node
            root = new Node(s.getArray()[i]);

            // recurse on left then right
            root.setLeft(createLevelOrder(s, root.getLeft(), 2 * i + 1, n));
            root.setRight(createLevelOrder(s, root.getRight(), 2 * i + 2, n));
        }
        return root;
    }

    // prints required output for provided BinaryTree
    private void printInfo(BinaryTree bt) {
        // traverse preorder
        System.out.printf("%-23s", "Pre-Order:");
        bt.traversePreorder(bt.getRoot());
        System.out.println();
        // evaluate preorder
        System.out.printf("%-23s", "Pre-Order Evaluation:");
        System.out.println(evaluatePreorder(bt.getPreOrder().getArray()));
        // traverse postorder
        System.out.printf("%-23s", "Post-Order:");
        bt.traversePostorder(bt.getRoot());
        System.out.println();
        //evaluate postorder
        System.out.printf("%-23s", "Post-Order Evaluation:");
        System.out.println(evaluatePostorder(bt.getPostOrder().getArray()));
    }

    // evaluate preorder
    private static int evaluatePreorder(String[] exp) {
        Stack Stack = new Stack();

        for (int i = exp.length - 1; i >= 0; i--) {

            // push operands to stack
            if (!(exp[i].equals("+") || exp[i].equals("-") ||
                    exp[i].equals("*") || exp[i].equals("/")))
                Stack.push(exp[i]);
            else {

                // operator found pop two elements from stack
                int o1 = Integer.parseInt(Stack.pop());
                int o2 = Integer.parseInt(Stack.pop());

                // perform operation
                switch (exp[i]) {
                    case "+":
                        Stack.push("" + (o1 + o2));
                        break;
                    case "-":
                        Stack.push("" + (o1 - o2));
                        break;
                    case "*":
                        Stack.push("" + (o1 * o2));
                        break;
                    case "/":
                        Stack.push("" + (o1 / o2));
                        break;
                }
            }
        }

        return Integer.parseInt(Stack.pop());
    }

    // evaluates postorder
    private static int evaluatePostorder(String[] exp) {
        Stack stack = new Stack();

        for (int i = 0; i < exp.length; i++) {
            String s = exp[i];

            // push operand to stack
            if (!(exp[i].equals("+") || exp[i].equals("-") ||
                    exp[i].equals("*") || exp[i].equals("/")))
                stack.push(s);

                //  if operator, pop two operands
            else {
                int val1 = Integer.parseInt(stack.pop());
                int val2 = Integer.parseInt(stack.pop());

                // perform operation
                switch (s) {
                    case "+":
                        stack.push("" + (val2 + val1));
                        break;
                    case "-":
                        stack.push("" + (val2 - val1));
                        break;
                    case "/":
                        stack.push("" + (val2 / val1));
                        break;
                    case "*":
                        stack.push("" + (val2 * val1));
                        break;
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
