package Chap07;

public class ArrayPar {
    private long[] theArray;
    private int nElements;

    public ArrayPar(int max){
        theArray = new long[max];
        nElements = 0;
    }

    public void insert(long value){
        theArray[nElements] = value;
        nElements++;
    }

    public int size(){
        return nElements;
    }

    public void display(){
        System.out.print("A= ");
        for (int i = 0; i < nElements; i++)
            System.out.print(theArray[i] + " ");
        System.out.println();
    }

    public int partitionIt(int left, int right, long pivot){
        int leftPtr = left - 1;
        int rightPtr = right + 1;
        while (true){
            while (leftPtr < right && theArray[++leftPtr] < pivot);
            while (rightPtr > left && theArray[--rightPtr] > pivot);
            if (leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
        }
        return leftPtr;
    }

    public void swap(int dex1, int dex2){
        long temp;
        temp = theArray[dex1];
        theArray[dex1] = theArray[dex2];
        theArray[dex2] = temp;
    }
}
