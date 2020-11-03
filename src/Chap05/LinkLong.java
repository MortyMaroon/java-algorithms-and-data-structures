package Chap05;

public class LinkLong {
    public long dData;
    public LinkLong next;

    public LinkLong(long dData) {
        this.dData = dData;
    }

    public void displayLink() {
        System.out.print(dData + " ");
    }
}
