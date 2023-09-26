/*
Write a program to replace all “word1” by “word2” to a file and
display the no. of replacement.*/

import java.io.*;
import java.util.*;

class FileReplace {
    public static void main(String[] args) throws IOException {
        File f1 = new File("G:\\bb.txt"); // read from this and replace
        File f2 = new File("G:\\bbb.txt"); // write to this after replace
        FileWriter fw1 = new FileWriter(f1);
        fw1.write("Hi baby Hi Hi its too High");
        fw1.close();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Word 1");
        String word1 = sc.next();
        System.out.println("Enter Word 2");
        String word2 = sc.next();
        FileWriter fw2 = new FileWriter(f2);
        FileReader fr1 = new FileReader(f1);
        BufferedReader br1 = new BufferedReader(fr1); //
        String rep = "";
        String s = "";
        int count = 0;
        while ((s = br1.readLine()) != null) {
            String s1[] = s.split(" ");
            for (String s2 : s1) {
                if (s2.equals(word1)) {
                    count++;
                    s2 = word2;
                }
                rep = rep + s2 + " ";
            }
            System.out.println("Count of Replacement = " + count);
            fw2.write(rep + "\n");
        }
        fw2.close();
    }
}