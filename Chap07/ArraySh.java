package Chap07;

public class ArraySh {
    private final long[] theArray;
    private int nElements;

    public ArraySh(int max) {
        theArray = new long[max];
        nElements = 0;
    }

    public void insert(long value){
        theArray[nElements] = value;
        nElements++;
    }

    public void display(){
        System.out.print("A= ");
        for (int i = 0; i < nElements; i++)
            System.out.print(theArray[i] + " ");
        System.out.println();
    }

    public void shellSort(){
        int inner, outer;
        long temp;
        int h = 1;
        while (h <= nElements /3)
            h = h * 3 + 1;
        while (h > 0){
            for (outer = h; outer < nElements; outer++) {
                temp = theArray[outer];
                inner = outer;
                while (inner  > h - 1 && theArray[inner - 1] >= temp){
                    theArray[inner] = theArray[inner - 1];
                    inner -= h;
                }
                theArray[inner] = temp;
            }
            h = (h - 1) / 3;
        }
    }
}
