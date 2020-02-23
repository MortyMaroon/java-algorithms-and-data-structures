package Chap02;

public class OrdArray {
    private long[] array;
    private int nElements;

    public long[] getArray() {
        return array;
    }

    public int size(){
        return nElements;
    }

    public OrdArray(int max) {
        this.array = new long[max];
        this.nElements = 0;
    }

    public int find(long searchKey) {
        int lowBound = 0;
        int upperBound = nElements - 1;
        int curIn;
        while (true) {
            curIn = (lowBound + upperBound) / 2;
            if (array[curIn] == searchKey) {
                return curIn;
            } else if (lowBound > upperBound) {
                return nElements;
            } else {
                if (searchKey < array[curIn]) {
                    upperBound = curIn - 1;
                } else {
                    lowBound = curIn + 1;
                }
            }
        }
    }

    public void insert(long value) {
        int lowBound = 0;
        int upperBound = nElements - 1;
        int curIn;
        while (true) {
            curIn = (lowBound + upperBound) / 2;
            if (array[curIn] == value) {
                break;
            } else if (lowBound > upperBound) {
                if (value >= array[curIn]) {
                    if (array[curIn] == 0 && nElements == 0) {
                        curIn = 0;
                    } else {
                        curIn++;
                    }
                }
                break;
            } else {
                if (array[curIn] < value){
                    lowBound = curIn + 1;
                } else {
                    upperBound = curIn - 1;
                }
            }
        }

        for (int i = nElements; i > curIn; i--) {
            array[i] = array[i - 1];
        }
        array[curIn] = value;
        nElements++;
    }

    public boolean delete(long value){
        int i = find(value);
        if (i == nElements) {
            return false;
        } else {
            for (int j = i; j < nElements; j++) {
                array[j] = array[j + 1];
            }
            nElements--;
            return true;
        }
    }

    public void display() {
        for (int i = 0; i < nElements; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

    public void merge(long[] array) {
        for (long element: array) {
            if (find(element) == nElements) {
                insert(element);
            }
        }
    }
}