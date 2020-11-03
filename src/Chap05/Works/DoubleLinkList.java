package Chap05.Works;

public class DoubleLinkList {

    private DoubleLinkItem first;
    private DoubleLinkItem last;

    public DoubleLinkList() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(long value) {
        DoubleLinkItem newLink = new DoubleLinkItem(value);
        if (isEmpty()) {
            last = newLink;
        } else {
            first.setPrevious(newLink);
            newLink.setNext(first);
        }
        first = newLink;
    }

    public void insertLast(long value) {
        DoubleLinkItem newLink = new DoubleLinkItem(value);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.setNext(newLink);
            newLink.setPrevious(last);
        }
        last = newLink;
    }

    public DoubleLinkItem deleteFirst() {
        DoubleLinkItem temp = first;
        if (first.getNext() == null) {
            last = null;
        } else {
            first.getNext().setPrevious(null);
        }
        first = first.getNext();
        return temp;
    }

    public DoubleLinkItem deleteLast() {
        DoubleLinkItem temp = last;
        if (first.getNext() == null) {
            first = null;
        } else {
            last.getPrevious().setNext(null);
        }
        last = last.getPrevious();
        return temp;
    }

    public boolean insertAfter(long key, long value) {
        DoubleLinkItem current = first;
        while (current.getData() != key) {
            current = current.getNext();
            if (current == null) {
                return false;
            }
        }
        DoubleLinkItem newLink = new DoubleLinkItem(value);
        if (current == last) {
            newLink.setNext(null);
            last = newLink;
        } else {
            newLink.setNext(current.getNext());
            current.getNext().setPrevious(newLink);
        }
        newLink.setPrevious(current);
        current.setNext(newLink);
        return true;
    }

    public DoubleLinkItem deleteKey(long key) {
        DoubleLinkItem current = first;
        if (first == null) {
            return null;
        }
        while (current.getData() != key) {
            current = current.getNext();
            if (current == null) {
                return null;
            }
        }
        if (current == first) {
            first = current.getNext();
        } else {
            current.getPrevious().setNext(current.getNext());
        }
        if (current == last) {
            last = current.getPrevious();
        } else {
            current.getNext().setPrevious(current.getPrevious());
        }
        return current;
    }

    public void displayForward() {
        System.out.print("List (first-->last): ");
        DoubleLinkItem current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println();
    }

    public void displayBackward() {
        System.out.print("List (last-->first): ");
        DoubleLinkItem current = last;
        while (current != null) {
            current.displayLink();
            current = current.getPrevious();
        }
        System.out.println();
    }

    public DoubleLinkItem getFirst() {
        return first;
    }

    public DoubleLinkItem getLast() {
        return last;
    }
}
