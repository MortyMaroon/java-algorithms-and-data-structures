package Chap11;

public class HashTableChain {

    private SortedList[] hashArray;
    private int arraySize;

    public HashTableChain(int size) {
        this.arraySize = size;
        hashArray = new SortedList[size];
        for (int i = 0; i < arraySize; i++) {
            hashArray[i] = new SortedList();
        }
    }

    public void displayTable() {
        for (int i = 0; i < arraySize; i++) {
            System.out.print(i + ", ");
            hashArray[i].displayList();
        }
    }

    private int hashFunk(int key) {
        return key % arraySize;
    }

    public void insert(Link theLink) {
        int key = theLink.getKey();
        int hashVal = hashFunk(key);
        hashArray[hashVal].insert(theLink);
    }

    public void delete(int key) {
        int hashVal = hashFunk(key);
        hashArray[hashVal].delete(key);
    }

    public Link find(int key) {
        int hashVal = hashFunk(key);
        Link theLink = hashArray[hashVal].found(key);
        return theLink;
    }
}
