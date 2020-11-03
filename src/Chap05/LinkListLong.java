package Chap05;

public class LinkListLong {
    private LinkLong first;

    public LinkListLong() {
        this.first = null;
    }

    public LinkLong getFirst() {
        return first;
    }

    public void setFirst(LinkLong first) {
        this.first = first;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public ListIterator getIterator() {
        return new ListIterator(this);
    }

    public void displayList() {
        LinkLong current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
}
