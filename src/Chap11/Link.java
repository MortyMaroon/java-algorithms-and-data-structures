package Chap11;

public class Link {
    private int iData;
    public Link next;

    public Link(int it) {
        this.iData = it;
    }

    public int getKey() {
        return iData;
    }


    public void displayLink() {
        System.out.print(iData + " ");
    }
}
