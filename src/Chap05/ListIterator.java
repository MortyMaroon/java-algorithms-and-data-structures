package Chap05;

public class ListIterator {
    private LinkLong current;
    private LinkLong previous;
    private LinkListLong ourList;

    public ListIterator(LinkListLong ourList) {
        this.ourList = ourList;
        reset();
    }

    public void reset() {
        current = ourList.getFirst();
        previous = null;
    }

    public boolean atEnd() {
        return current.next == null;
    }

    public void nextLink() {
        previous = current;
        current = current.next;
    }

    public LinkLong getCurrent() {
        return current;
    }

    public void insertAfter(long dd) {
        LinkLong newLink = new LinkLong(dd);
        if (ourList.isEmpty()) {
            ourList.setFirst(newLink);
            current = newLink;
        } else {
            newLink.next = current.next;
            current.next = newLink;
            nextLink();
        }
    }

    public void insertBefore(long dd) {
        LinkLong newLink = new LinkLong(dd);
        if (previous == null) {
            newLink.next = ourList.getFirst();
            ourList.setFirst(newLink);
            reset();
        } else {
            newLink.next = previous.next;
            previous.next = newLink;
            current = newLink;
        }
    }

    public long deleteCurrent() {
        long value = current.dData;
        if (previous == null) {
            ourList.setFirst(current.next);
            reset();
        } else {
            previous.next = current.next;
            if (atEnd()) {
                reset();
            } else {
                current = current.next;
            }
        }
        return value;
    }
}
