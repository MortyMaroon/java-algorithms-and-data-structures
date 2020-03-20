package Chap05;

public class LinkDouble {
    public long dData;
    public LinkDouble next;
    public LinkDouble previous;

    public LinkDouble(long dData) {
        this.dData = dData;
    }

    public void displayLink() {
        System.out.print(dData + " ");
    }
}
