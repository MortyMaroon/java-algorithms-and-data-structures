package Chap11;

public class QuadraticProbingHashTable extends HashTable{

    public QuadraticProbingHashTable(int size) {
        arraySize = size;
        hashArray = new DataItem[arraySize];
    }

//    Получение первого простого числа после введеного
    public static int getPrime(int min) {
        for (int i = min + 1; true; i++) {
            if (isPrime(i)){
                return i;
            }
        }
    }

//    Проверка числа является ли оно простым
    public static boolean isPrime(int value) {
        for (int i = 2; (i * i < value); i++) {
            if (value % 2 == 0) {
                return false;
            }
        }
        return true;
    }

    public void insert(DataItem item) {
        int hasVal = hashFunk1(item.getKey());
        int i = 1;
        while (hashArray[hasVal] != null && hashArray[hasVal].getKey() != nonItem.getKey()) {
            hasVal += i * i;
            hasVal %= arraySize;
        }
        hashArray[hasVal] = item;
    }
}
