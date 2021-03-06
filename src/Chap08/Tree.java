package Chap08;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Tree {
    private Node root;

    public Tree(){
        this.root = null;
    }

    public Tree(Node root){
        this.root = root;
    }

    public Node find(int key){
        Node current = root;
        while (current.iData != key){
            if (key < current.iData){
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null){
                return null;
            }
        }
        return current;
    }

    public void insert(Node node){
        insert(node.iData, node.dData);
    }

    public void insert(int id, double dd){
        Node newNode = new Node();
        newNode.iData = id;
        newNode.dData = dd;
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (id < current.iData){
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public Node minimum(){
        Node current = root;
        Node last = null;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public boolean delete(int key){
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.iData != key) {
            parent = current;
            if (key < current.iData) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }
        if (current.leftChild == null && current.rightChild == null){
            if (current == root){
                root = null;
            }else if (isLeftChild){
                parent.leftChild = null;
            }else{
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        }else if (current.leftChild == null){
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            Node successor = getSuccessor(current);
            if (current == root){
                root = successor;
            } else if (isLeftChild){
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    public Node getSuccessor(Node delNode){
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != delNode.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    public void travers(int traversType){
        switch (traversType){
            case 1:
                System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 2:
                System.out.print("\nInorder traversal: ");
                inOrder(root);
                break;
            case 3:
                System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
        }
    }

    public void preOrder(Node localRoot){
        if (localRoot != null){
            System.out.print(localRoot.iData + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    public void inOrder(Node localRoot){
        if (localRoot != null){
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.iData + " ");
            inOrder(localRoot.rightChild);
        }
    }

    public void postOrder(Node localRoot){
        if (localRoot != null){
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.iData + " ");
        }
    }

    public void displayTree(){
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRoweEmpty = false;
        while(isRoweEmpty == false) {
            Stack<Node> localStack = new Stack<>();
            isRoweEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }
            while(globalStack.isEmpty()==false){
                Node temp = globalStack.pop();
                if (temp != null){
                    System.out.print(temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if (temp.leftChild != null || temp.rightChild != null){
                        isRoweEmpty = false;
                    }
                }else{
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int i = 0; i < nBlanks * 2 - 2; i++) {
                    System.out.print(" ");

                }
                System.out.println();
                nBlanks /= 2;
                while(localStack.isEmpty() == false){
                    globalStack.push(localStack.pop());
                }
            }
        }
    }

    public Tree makeTreeFromUserChars(String inputChars){
        Deque<Tree> treeDeque = new ArrayDeque<>();
        char[] chars = inputChars.toCharArray();
        Node tempNode = new Node('+','+');
        int counter = 0;
        while(counter < chars.length) {
            if (tempNode.leftChild == null){
                tempNode.leftChild = new Node(chars[counter], chars[counter]);
                if (++counter >= chars.length){
                    Tree smallTree = new Tree();
                    smallTree.insert(tempNode);
                    treeDeque.add(smallTree);
                }
            } else if (tempNode.rightChild == null){
                tempNode.rightChild = new Node(chars[counter], chars[counter]);
                if (++counter >= chars.length){
                    Tree smallTree = new Tree();
                    smallTree.insert(tempNode);
                    treeDeque.add(smallTree);
                }
            } else {
                Tree smallTree = new Tree();
                smallTree.insert(tempNode);
                treeDeque.add(smallTree);
            }
        }
        return makeTree(treeDeque);
    }

    private static Tree makeTree(Deque<Tree> treeDeque){
        if (treeDeque.size() == 1) {
            return treeDeque.poll();
        }
        Node tempNode = new Node('+','+');
        while (treeDeque.size() != 0) {
            if (tempNode.leftChild == null) {
                tempNode.leftChild = treeDeque.poll().root;
                if (treeDeque.size() == 0) {
                    Tree mediumTree = new Tree();
                    mediumTree.insert(tempNode);
                    treeDeque.addLast(mediumTree);
                    break;
                }
            } else if (tempNode.rightChild == null) {
                tempNode.rightChild = treeDeque.poll().root;
                if (treeDeque.size() == 0) {
                    Tree mediumTree = new Tree();
                    mediumTree.insert(tempNode);
                    treeDeque.addLast(mediumTree);
                    break;
                }
            } else {
                Tree mediumTree = new Tree();
                mediumTree.insert(tempNode);
                treeDeque.addLast(mediumTree);
                tempNode = new Node('+','+');
            }
        }
        return treeDeque.poll();
    }

    public Tree makeFullTreeFromUserChars(String inputChars) {
        return makeFullTree(inputChars.toCharArray(), null, 0);
    }

    private static Tree makeFullTree(char[] chars, Node rootNode, int rootNodePosition) {
        if (chars.length == 0) {
            return null;
        }
        Node node;
        Character character;
        Tree tree;
        if (rootNode == null) {
            character = chars[rootNodePosition];
            node = new Node(character, character);
        } else {
            node = rootNode;
        }

        int leftNodePosition = rootNodePosition * 2 + 1;
        if (chars.length <= leftNodePosition) {
            return new Tree(node);
        } else {
            node.leftChild = new Node(chars[leftNodePosition], chars[leftNodePosition]);
        }

        int rightNodePosition = rootNodePosition * 2 + 2;
        if (chars.length <= rightNodePosition) {
            return new Tree(node);
        } else {
            node.rightChild = new Node(chars[rightNodePosition], chars[rightNodePosition]);
        }

        tree = new Tree(node);

        Tree leftSubTree = makeFullTree(chars, tree.root.leftChild, leftNodePosition);
        if (leftSubTree == null) {
            return new Tree(node);
        }
        node.leftChild = leftSubTree.root;

        Tree rightSubTree = makeFullTree(chars, tree.root.rightChild, rightNodePosition);
        if (rightSubTree == null) {
            return new Tree(node);
        }
        node.rightChild = rightSubTree.root;

        return tree;
    }
}
