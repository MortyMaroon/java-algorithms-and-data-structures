package Chap11;

import java.io.*;
import java.util.ArrayList;

public class test1 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader (new FileReader("input.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt")) ) {

            ArrayList<String> options = new ArrayList<>();
            StringBuilder newWord;
            boolean flag;
            char oldLetter;
            char newLetter;
            String test;
            String[] temps;
            String[] tables;
            String[] tests;

            temps = reader.readLine().split(" ");
            options.add(reader.readLine());
            
            tables = new String[Integer.parseInt(temps[1])];
            for (int i = 0; i < tables.length; i++) {
                tables[i] = reader.readLine();
            }
            tests = new String[Integer.parseInt(reader.readLine())] ;
            for (int i = 0; i < tests.length; i++) {
                tests[i] = reader.readLine();
            }


            for (int i = 0; i < options.size(); i++) {
                for (String table : tables) {
                    newWord = new StringBuilder();
                    flag = true;
                    for (int k = 0; k < Integer.parseInt(temps[0]); k++) {
                        oldLetter = options.get(i).charAt(k);
                        newLetter = table.charAt(k);
                        if (newLetter == '-' || newLetter == oldLetter) {
                            newWord.append(oldLetter);
                        } else {
                            newWord.append(newLetter);
                        }
                    }
                    for (String option : options) {
                        if (newWord.toString().equals(option)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        options.add(newWord.toString());
                    }
                }
            }
            int n = Integer.parseInt(reader.readLine());
            for (int i = 0; i < n; i++) {
                test = reader.readLine();
                flag = false;
                for (String option : options) {
                    if (test.equals(option)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    writer.write("YES\n");
                } else {
                    writer.write("NO\n");
                }
                writer.flush();
            }
        }
    }
}
