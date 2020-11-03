package Chap05.Works;

public class CyclicList {
    LinkItem current;
    int count = 0;

    public CyclicList() {
        this.current = null;
    }

    public boolean isEmpty() {
        return current == null;
    }

    public void insert(long data) {
        LinkItem item = new LinkItem(count++,data);
        if (current == null) {
            current = item;
            item.setNext(current);
        } else {
            item.setNext(current.getNext());
            current.setNext(item);
        }
    }

    public LinkItem deleteFirst() {
        LinkItem temp = current;
        if (!isEmpty()) {
            if (current.getNext() == current) {
                current = null;
            } else {
                temp = current.getNext();
                current.setNext(current.getNext().getNext());
            }
        }
        return temp;
    }

    public LinkItem find(LinkItem item) {
        if (!isEmpty()) {
            LinkItem temp = this.current;
            while (temp.getData() != item.getData()) {
                if (temp.getNext() == null || temp.getNext() == this.current) {
                    return null;
                } else {
                    temp = temp.getNext();
                }
            }
            return temp;
        } else {
            return null;
        }
    }

    public LinkItem delete(LinkItem item) {
        LinkItem tempCurrent = current;
        while (current.getNext().getData() != item.getData()) {
            current = current.getNext();
        }
        if (current.getNext() == current) {
            current = null;
        } else {
            tempCurrent = current.getNext();
            current.setNext(current.getNext().getNext());
            step();
        }
        return tempCurrent;
    }

    public LinkItem getFirst() {
        return current;
    }

    public void displayList() {
        LinkItem temp = current;
        System.out.print("List (current-->current-1): ");
        if (!isEmpty()) {
            while (true) {
                System.out.print(temp.getData() + " ");
                temp = temp.getNext();
                if (temp == current) {
                    break;
                }
            }
        } else {
            System.out.print("null ");
        }
        System.out.println();
    }

    public LinkItem step() {
        if (current != null) {
            current = current.getNext();
            return current;
        } else {
            return null;
        }
    }
}
