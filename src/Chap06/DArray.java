package Chap06;

public class DArray {
    private long[] theArray;
    private int nElements;

    public DArray(int max) {
        this.theArray = new long[max];
        this.nElements = 0;
    }

    public void insert(long value) {
        theArray[nElements] = value;
        nElements++;
    }

    public void display() {
        for (int i = 0; i < nElements; i++) {
            System.out.print(theArray[i] + " ");
        }
        System.out.println();
    }

    public void mergeSort() {
        long[] workSpace = new long[nElements];
        recMergeSort(workSpace,0,nElements-1);
    }

    private void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;
            recMergeSort(workSpace,lowerBound,mid);
            recMergeSort(workSpace,mid + 1,upperBound);
            merge(workSpace,lowerBound,mid + 1,upperBound);
        }
    }

    private void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound) {
        int i = 0;
        int lowerBound = lowPtr;
        int mid = highPtr -1;
        int n = upperBound - lowerBound + 1;
        while (lowPtr <= mid && highPtr <= upperBound) {
            if (theArray[lowPtr] < theArray[highPtr]) {
                workSpace[i++] = theArray[lowPtr++];
            } else {
                workSpace[i++] = theArray[highPtr++];
            }
        }
        while (lowPtr <= mid) {
            workSpace[i++] = theArray[lowPtr++];
        }
        while (highPtr <= upperBound) {
            workSpace[i++] = theArray[highPtr++];
        }
        for (i = 0; i < n; i++) {
            theArray[lowerBound + i] = workSpace[i];
        }
    }
}
