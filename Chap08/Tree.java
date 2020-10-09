package Chap08;

public class Tree {
    private Node root;

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

    public void insert(int id, double dd){
        Node newNOde = new Node();
        newNOde.iData = id;
        newNOde.fData = dd;
        if (root == null) {
            root = newNOde;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (id < current.iData){
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNOde;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNOde;
                        return;
                    }
                }
            }
        }
    }

    public void inOrder(Node localRoot){
        if (localRoot != null){
            inOrder(localRoot.leftChild);
            System.out.println(localRoot.iData + " ");
            inOrder(localRoot.rightChild);
        }
    }

    public void delete(int id){

    }
}
