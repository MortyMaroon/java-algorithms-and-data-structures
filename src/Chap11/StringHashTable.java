package Chap11;

public class StringHashTable extends HashString{
    private static final String ERROR_MESSAGE = "Переданное значение не соотвествует шаблону [a-z]";
    private String[] hashArray;
    private int arraySize;
    private String deletedItem;

    public StringHashTable(int size) {
        this.arraySize = size;
        hashArray = new String[arraySize];
        deletedItem = "-1";
    }

    public static boolean isMathLettersInString(String value) {
        return value.matches("^[a-z]+$");
    }

    public void insert(String item) {
        if (!isMathLettersInString(item)) {
            System.out.println(ERROR_MESSAGE);
            return;
        }
        int hashVal = hashFunk3(item);
        while (hashArray[hashVal] != null && !hashArray[hashVal].equals(deletedItem)) {
            ++hashVal;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
    }

    public String delete(String item) {
        if (!isMathLettersInString(item)) {
            System.out.println(ERROR_MESSAGE);
            return null;
        }
        int hashVal = hashFunk3(item);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].equals(item)) {
                String value = hashArray[hashVal];
                hashArray[hashVal] = deletedItem;
                return value;
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }

    public String getDisplayData() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%s: ", this.getClass().getSimpleName()));
        for (int i = 0; i < arraySize; i++) {
            if (hashArray[i] != null) {
                stringBuilder.append(String.format("%s ", hashArray[i]));
            } else {
                stringBuilder.append("** ");
            }
        }
        stringBuilder.append("");
        return stringBuilder.toString();
    }
}
