package Chap05.Works;

public class LinkItem {
    private int key;
    private long data;
    private LinkItem next;

    public long getData() {
        return data;
    }

    public LinkItem getNext() {
        return next;
    }

    public void setNext(LinkItem next) {
        this.next = next;
    }

    public LinkItem(int key, long data) {
        this.key = key;
        this.data = data;
    }

    public void displayLink() {
        System.out.print("{" + key + ", " + data + "}");
    }
}
