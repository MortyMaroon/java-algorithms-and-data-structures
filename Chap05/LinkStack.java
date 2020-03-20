package Chap05;

public class LinkStack {
    private LinkList theList;

    public LinkStack() {
        this.theList = new LinkList();
    }

    public void push(int id, double dd) {
        theList.insertFirst(id,dd);
    }

    public Link pop() {
        return theList.deleteFirst();
    }

    public boolean isEmpty() {
        return theList.isEmpty();
    }

    public void displayStack() {
        System.out.print("Stack (top-->bottom): ");
        theList.displayList();
    }
}
