package Chap07.Works;

public class work1 {
    private long[] theArray;
    private int nElements;

    public work1(int maxSize)
    {
        theArray = new long[maxSize];
        nElements = 0;
    }

    public void insert(long value) throws IndexOutOfBoundsException
    {
        theArray[nElements++] = value;
    }

    public int size()
    {
        return nElements;
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

    public int partitionItWithMaxElement(int left, int right)
    {
        int leftPartition = left - 1;
        int rightPartition = right + 1;

        while (true)
        {
            while (leftPartition < right && theArray[++leftPartition] < theArray[nElements - 1])
            {
            }

            while (rightPartition > left && theArray[--rightPartition] > theArray[nElements -1 ])
            {
            }

            if (leftPartition >= rightPartition)
            {
                break;
            }
            else
            {
                swap(leftPartition, rightPartition);
            }
        }

        return leftPartition;
    }

    public void swap(int firstValue, int secondValue)
    {
        theArray[firstValue] = theArray[firstValue] + theArray[secondValue];
        theArray[secondValue] = theArray[firstValue] - theArray[secondValue];
        theArray[firstValue] = theArray[firstValue] - theArray[secondValue];
    }

    int medianReq(int left, int right)
    {
        int leftPartition = left - 1;
        int rightPartition = right + 1;

        while (true)
        {
            while (leftPartition < right && theArray[++leftPartition] < theArray[nElements - 1])
            {
            }

            while (rightPartition > left && theArray[--rightPartition] > theArray[nElements -1 ])
            {
            }

            if (leftPartition >= rightPartition)
            {
                break;
            }
        }

        return leftPartition;
    }
}
