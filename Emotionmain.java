import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Timer;

/*
672115037 Phutawan Mueangma
ADT Programming Assignment 2
*/

public class Emotionmain {
     public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
            System.out.println("Enter file path : ");
                String filepath = input.nextLine();
        File ADT = new File(filepath);
        BufferedReader ReadFile = null;
        try {
            ReadFile = new BufferedReader(new FileReader(ADT));
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        String line = "";
        int Parindome = 0 ,TotalChatcount = 0 ,Emoticon = 0 ,Token = 0 ,longest = 0 ,lines = 0 ,wordCount = 0;   
        HashSet<String> listEmoticon = new HashSet<String>();
        listEmoticon.add(":-)");
        listEmoticon.add(":-(");
        listEmoticon.add(":-D");
        listEmoticon.add(";-)");
        listEmoticon.add(":-P");
        listEmoticon.add(":-O");
        listEmoticon.add(":-S");
        listEmoticon.add(":-|");
        listEmoticon.add(":-*");
        listEmoticon.add("t,t");
        listEmoticon.add(":-@");
        listEmoticon.add(":-#");

        Timer timer = new Timer();
        long start = System.nanoTime();
        while ((line = ReadFile.readLine()) != null) {
            lines++;
            String[] wordArray = line.split(" \\s");
            for (String word : wordArray) {
                TotalChatcount += word.length();
                Token++;
                Parindome += isPalindrome(word);
                Emoticon += isEmoticon(word);
                Token += word.length();
                longest = Math.max(longest, word.length());
                }
            }
            long end = System.nanoTime();
            long elapsedTime = (end - start)/1000000;
            double seconds = elapsedTime / 1000.0;
            System.out.println("Total # Character Count : " + TotalChatcount);
            System.out.println("Total # Palindrome Count : " + Parindome);
            System.out.println("Total  Token Count : " + Token);
            System.out.println("Total Number of Emoticon : " + Emoticon );
            System.out.println("Longest Word Length : " + longest + " The averages token size is " + (Token / lines));
            System.out.println("Total Time to excute the program : " + seconds + " seconds");
            System.out.println("Program has been excuted successfully");
            ReadFile.close();
            System.exit(0);
        }
        public static int isPalindrome(String word) {
            int L = 0, R = word.length() - 1;
            while (L < R) {
                if (word.charAt(L) != word.charAt(R)) {
                    return 0;
                }
                L++;
                R--;
            }
            return 1;
     }
     public static int isEmoticon(String word) {
        HashSet<String> listEmoticon = new HashSet<String>();
        listEmoticon.add(":-)");
        listEmoticon.add(":-(");
        listEmoticon.add(":-D");
        listEmoticon.add(";-)");
        listEmoticon.add(":-P");
        listEmoticon.add(":-O");
        listEmoticon.add(":-S");
        listEmoticon.add(":-|");
        listEmoticon.add(":-*");
        listEmoticon.add("t,t");
        listEmoticon.add(":-@");
        listEmoticon.add(":-#");
        return listEmoticon.contains(word) ? 1 : 0;
     }
}