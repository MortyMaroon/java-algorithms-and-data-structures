package Chap11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HashDoubleApp {
    public static void main(String[] args) throws IOException{
        int aKey, size, n;
        DataItem aDataItem;

        System.out.print("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter initial number of item: ");
        n = getInt();

        HashTable theHashtable = new HashTable(size);

        for (int i = 0; i < n; i++)
            {
            aKey = (int)(Math.random() * 2 * size);
            aDataItem = new DataItem(aKey);
            theHashtable.insert(aDataItem);
            }

        while (true)
        {
            System.out.print("Enter first letter of: ");
            System.out.print("show, insert, delete or find: ");
            char choice = getChar();
            switch (choice)
            {
                case 's':
                    theHashtable.displayTable();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    aDataItem = new DataItem(aKey);
                    theHashtable.insertDoubleHash(aKey, aDataItem);
                    break;
                case 'd':
                    System.out.print("Enter key value to delete: ");
                    aKey = getInt();
                    theHashtable.deleteDoubleHash(aKey);
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    aKey = getInt();
                    aDataItem = theHashtable.findDoubleHash(aKey);
                    if (aDataItem != null)
                        System.out.print("Found " + aKey);
                    else
                        System.out.print("Could not find " + aKey);
                    break;
                default:
                    System.out.print("Invalid entry\n");
            }
        }
    }

    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException
    {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException
    {
        String s = getString();
        return Integer.parseInt(s);
    }
}
