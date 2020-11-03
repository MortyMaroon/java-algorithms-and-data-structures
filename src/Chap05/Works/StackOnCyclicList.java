package Chap05.Works;

public class StackOnCyclicList {
    private CyclicList cyclicList = new CyclicList();

    public void insert(long value) {
        cyclicList.insert(value);
    }

    public long remove() {
        return  cyclicList.deleteFirst().getData();
    }

    public long peekFront() {
        return cyclicList.getFirst().getData();
    }

    public boolean isEmpty() {
        return cyclicList.isEmpty();
    }

    public void display() {
        cyclicList.displayList();
    }
}
