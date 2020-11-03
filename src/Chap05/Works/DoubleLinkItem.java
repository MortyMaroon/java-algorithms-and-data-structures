package Chap05.Works;

public class DoubleLinkItem {
    private long data;
    private DoubleLinkItem next;
    private DoubleLinkItem previous;

    public long getData() {
        return data;
    }

    public DoubleLinkItem getNext() {
        return next;
    }

    public void setNext(DoubleLinkItem next) {
        this.next = next;
    }

    public DoubleLinkItem getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleLinkItem previous) {
        this.previous = previous;
    }

    public DoubleLinkItem(long data) {
        this.data = data;
    }

    public void displayLink() {
        System.out.print(data + " ");
    }
}
