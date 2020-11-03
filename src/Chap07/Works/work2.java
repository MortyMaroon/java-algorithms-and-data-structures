package Chap07.Works;

public class work2 {
    private long[] theArray;
    private int nElements;
    private int compares;
    private int swaps;

    public work2(int arrayQkSize)
    {
        theArray = new long[arrayQkSize];
        nElements = 0;
        compares = 0;
        swaps = 0;
    }

    public void insert(long value) throws IndexOutOfBoundsException
    {
        theArray[nElements++] = value;
    }

    public String display()
    {
        StringBuilder builder = new StringBuilder();

        builder.append("A = ");
        for (int i = 0; i < nElements; i++)
        {
            builder.append(theArray[i]);
            builder.append(" ");
        }

        return builder.toString();
    }

    public int getCompares()
    {
        return compares;
    }

    public int getSwaps()
    {
        return swaps;
    }

    void quickSort()
    {
        reqQuickSort(0, nElements - 1);
    }

    void reqQuickSort(int left, int right)
    {
        int size = right - left + 1;

        compares++;
        if (size < 10)
        {
            insertionSort(left, right);
        }
        else
        {
            long median = medianOf3(left, right);
            int partition = partitionInt(left, right, median);
            reqQuickSort(left, partition - 1);
            reqQuickSort(partition + 1, right);
        }
    }

    long medianOf3(int left, int right)
    {
        int center = (left + right) / 2;

        compares++;
        if (theArray[left] > theArray[center])
        {
            swap(left, center);
        }

        compares++;
        if (theArray[left] > theArray[right])
        {
            swap(left, right);
        }

        compares++;
        if (theArray[center] > theArray[right])
        {
            swap(center, right);
        }

        swap(center, right - 1);

        return theArray[right - 1];
    }

    int partitionInt(int left, int right, long median)
    {
        int leftPartition = left;
        int rightPartition = right - 1;

        while (true)
        {
            compares++;
            while (theArray[++leftPartition] < median)
            {
            }

            compares++;
            while (theArray[--rightPartition] > median)
            {
            }

            compares++;
            if (leftPartition >= rightPartition)
            {
                break;
            }
            else
            {
                swap(leftPartition, rightPartition);
            }
        }

        swap(leftPartition, right - 1);

        return leftPartition;
    }

    void insertionSort(int left, int right)
    {
        int inner, outer;
        for (outer = left + 1; outer <= right; outer++)
        {
            long temp = theArray[outer];
            inner = outer;

            compares += 2;
            while (inner > left && theArray[inner - 1] >= temp)
            {
                theArray[inner] = theArray[inner - 1];
                --inner;
            }

            theArray[inner] = temp;
        }
    }

    void swap(int firstValue, int secondValue)
    {
        swaps += 3;

        theArray[firstValue] = theArray[firstValue] + theArray[secondValue];
        theArray[secondValue] = theArray[firstValue] - theArray[secondValue];
        theArray[firstValue] = theArray[firstValue] - theArray[secondValue];
    }
}