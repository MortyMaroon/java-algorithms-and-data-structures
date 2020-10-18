package Chap11;

public class HashString {
    public static int arraySize = 100;

    public static int hashFunk1(String key) {
        int hashVal = 0;
        int pow27 = 1;

        for (int i = key.length() - 1; i >= 0; i--) {
            int letter = key.charAt(i) - 96;
            hashVal += pow27 * letter;
            pow27 *= 27;
        }
        return hashVal % arraySize;
    }

    public static int hashFunk2(String key) {
        int hashVal = key.charAt(0) - 98;

        for (int i = 1; i < key.length() - 1; i++) {
            int letter = key.charAt(i) - 96;
            hashVal = hashVal * 27 + letter;
        }
        return hashVal % arraySize;
    }

    public static int hashFunk3(String key) {
        int hashVal = 0;

        for (int i = 0; i < key.length(); i++) {
            int letter = key.charAt(i) - 96;
            hashVal = (hashVal * 27 + letter) % arraySize;
        }
        return hashVal;
    }
}
