package Chap05.Works;

public class SortedLinkedList {
    private LinkItem first;

    public LinkItem getFirst() {
        return first;
    }

    public SortedLinkedList() {
        this.first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(int key, long data) {
        LinkItem newLink = new LinkItem(key,data);
        if (!isEmpty()) {
            if (first.getData() > newLink.getData()) {
                newLink.setNext(first);
                first = newLink;
            } else {
                LinkItem current = first;
                while (current.getNext() != null) {
                    if (current.getData() <= newLink.getData() && current.getNext().getData() > newLink.getData()) {
                        break;
                    }
                    current = current.getNext();
                }
                newLink.setNext(current.getNext());
                current.setNext(newLink);
            }
        } else {
            newLink.setNext(first);
            first = newLink;
        }
    }

    public LinkItem deleteFirst() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("SortedLinkedList is empty");
        } else {
            LinkItem temp = first;
            first = first.getNext();
            return temp;
        }
    }


}
