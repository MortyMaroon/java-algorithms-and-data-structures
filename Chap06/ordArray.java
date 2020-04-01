package Chap06;

public class ordArray {
    private long[] a;
    private int nElements;

    public ordArray(int max) {
        this.a = new long[max];
        this.nElements = 0;
    }

    public int size() {
        return nElements;
    }

    public int find(long searchKey) {
        return recFind(searchKey,0,nElements - 1);
    }

    private int recFind(long searchKey, int lowerBound, int upperBound) {
        int curIn = (lowerBound + upperBound) / 2;
        if (a[curIn] == searchKey) {
            return curIn;
        } else if (lowerBound > upperBound) {
            return nElements;
        } else {
            if (a[curIn] < searchKey) {
                return recFind(searchKey, curIn +1, upperBound);
            } else {
                return recFind(searchKey, lowerBound , curIn - 1);
            }
        }
    }

    public void insert(long value) {
        int i;
        for (i = 0; i < nElements; i++) {
            if (a[i] > value) {
                break;
            }
        }
        for (int j = nElements; j > i; j--) {
            a[j] = a[j - 1];
        }
        a[i] = value;
        nElements++;
    }

    public void display() {
        for (int i = 0; i < nElements; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
