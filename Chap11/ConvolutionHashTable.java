package Chap11;


public class ConvolutionHashTable{
    private static final int TEN = 10;
    private Integer[] hashArray;
    private int arraySize;
    private Integer deleteItem;
    private int groupSize;

    public ConvolutionHashTable(int size) {
        this.arraySize = size;
        this.hashArray = new Integer[arraySize];
        this.deleteItem = -1;
        this.groupSize = calcGroupSize(arraySize);
    }

    public static int calcGroupSize(int arraySize) {
        int tempValue = arraySize;
        for (int i = 0; true; i++) {
            tempValue /= TEN;
            if (tempValue < TEN) {
                return i;
            }
        }
    }

    public int hashFunction(Integer item){
        int hashValue = 0;
        char[] itemDigits = item.toString().toCharArray();
        if (itemDigits.length <= groupSize){
            hashValue = item;
        } else {
            int tempValue = 0;
            for (int i = 0; i < itemDigits.length; i++) {
                tempValue += Integer.parseInt(String.valueOf(itemDigits[i]));
                if (i != 0 && (i + 1) % groupSize == 0
                        || (itemDigits.length % groupSize != 0 && i + 1 == itemDigits.length)) {
                    hashValue += tempValue;
                    tempValue = 0;
                } else {
                    tempValue *= TEN;
                }
            }
        }
        return hashValue % arraySize;
    }

    public void insert(Integer item) {
        int hashValue = hashFunction(item);
        while (hashArray[hashValue] != null && !hashArray[hashValue].equals(deleteItem)){
            ++hashValue;
            hashValue %= arraySize;
        }
        hashArray[hashValue] = item;
    }

    public Integer delete(Integer item) {
        int hashValue = hashFunction(item);
        while (hashArray[hashValue] != null) {
            if (hashArray[hashValue].equals(item)){
                Integer value = hashArray[hashValue];
                hashArray[hashValue] = deleteItem;
                return value;
            }
            ++hashValue;
            hashValue %= arraySize;
        }
        return null;
    }

    public Integer find(Integer item) {
        int hashValue = hashFunction(item);
        while (hashArray[hashValue] != null) {
            if (hashArray[hashValue].equals(item)){
                return hashArray[hashValue];
            }
            ++hashValue;
            hashValue %= arraySize;
        }
        return null;
    }

    public String getDisplayData() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%s ", this.getClass().getSimpleName()));
        for (int i = 0; i < arraySize; i++) {
            if (hashArray[i] != null) {
                stringBuilder.append(String.format("%s ", hashArray[i].toString()));
            } else {
                stringBuilder.append("** ");
            }
        }
        stringBuilder.append("");
        return stringBuilder.toString();
    }
}