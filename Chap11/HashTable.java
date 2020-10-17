package Chap11;

public class HashTable
{
    private DataItem[] hashArray;
    private int arraySize;
    private DataItem nonItem = new DataItem(-1);

    public HashTable(int size)
        {
        this.arraySize = size;
        this.hashArray = new DataItem[arraySize];
        }

    public void displayTable()
        {
        System.out.print("Table: ");
        for (int i = 0; i < arraySize; i++)
            {
            if (hashArray[i] != null)
                System.out.print(hashArray[i].getKey() + " ");
            else
                System.out.print("** ");
            }
        System.out.println();
        }

    public int hashFunk1(int key)
        {
        return key % arraySize;
        }

    public int hashFunk2(int key)
    {
        return 5 - key % 5;
    }

    public void insertDoubleHash(int key, DataItem item)
    {
        int hashVal = hashFunk1(key);
        int stepSize = hashFunk2(key);

        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != nonItem.getKey())
        {
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
    }

    public void insert(DataItem item)
        {
         int key = item.getKey();
         int hasVal = hashFunk1(key);

         while (hashArray[hasVal] != null && hashArray[hasVal].getKey() != nonItem.getKey())
            {
            ++hasVal;
            hasVal %= arraySize;
            }
         hashArray[hasVal] = item;
        }

    public DataItem deleteDoubleHash(int key)
    {
        int hashVal = hashFunk1(key);
        int stepSize = hashFunk2(key);

        while (hashArray[hashVal] != null)
        {
            if (hashArray[hashVal].getKey() == key)
            {
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }

    public DataItem delete(int key)
        {
        int hashVal = hashFunk1(key);

        while (hashArray[hashVal] != null)
            {
            if (hashArray[hashVal].getKey() == key)
                {
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
                }
            ++hashVal;
            hashVal %= arraySize;
            }
        return null;
        }

    public DataItem findDoubleHash(int key)
    {
        int hashVal = hashFunk1(key);
        int stepSize = hashFunk2(key);

        while (hashArray[hashVal] != null)
        {
            if (hashArray[hashVal].getKey() == key)
                return hashArray[hashVal];
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }

    public DataItem find(int key)
        {
        int hashVal = hashFunk1(key);

        while (hashArray[hashVal] != null)
            {
            if (hashArray[hashVal].getKey() == key)
                return hashArray[hashVal];
            ++hashVal;
            hashVal %= arraySize;
            }
        return null;
        }
}

