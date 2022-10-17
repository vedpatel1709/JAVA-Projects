package work;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Task1{
	
    public static void Hangman() throws Exception {
    	Scanner sc = new Scanner(System.in);
    	BufferedReader bread;
    	BufferedWriter bwrite;
    	Vector<String> tries = new Vector<>();
        Random rnd = new Random();
        int misses = 0;
        char yn;

        System.out.println("\nGame starts\n");

        do {
            String YNinput = "";
            String file = "Hangman.txt";
            bread = new BufferedReader(new FileReader(file));
            Vector<String> words = new Vector<>();
            String line;

            while ((line = bread.readLine()) != null) {
                words.add(line);
            }
            bread.close();
            String answer = words.get(rnd.nextInt(words.size()));
            String hiddenAns = new String();

            for (int i = 0; i < answer.length(); i++) {
                hiddenAns += '*';
            }

            while (hiddenAns.indexOf("*") != -1) {
                System.out.printf("(Guess) Enter a letter in word %s > ", hiddenAns);
                String guess = sc.next();

                for (int i = 0; i < answer.length(); i++) {
                    if (hiddenAns.charAt(i) == guess.charAt(0)) {
                        System.out.println("        " + guess + " is already in the word" );
                    }
                }
                tries.add(guess);
                if (answer.indexOf(guess) != -1) {
                    String copy = hiddenAns;
                    hiddenAns = "";
                    for (int i = 0; i < answer.length(); i++) {
                        if (answer.charAt(i) == guess.charAt(0)) {
                            hiddenAns += answer.charAt(i);
                        } else {
                            hiddenAns += copy.charAt(i);
                        }
                    }
                } else {
                    System.out.println("        " + guess + " is not in the word");
                    misses++;
                }
            }
            System.out.printf("The word is %s. You missed %s %s\n", answer, misses, (misses == 1 ? "time" : "times"));
            System.out.print("Enter a new word to be added in the memory> ");
            String word = " ";
            word = sc.nextLine();
            word += sc.nextLine();
            bwrite = new BufferedWriter(new FileWriter(file, true));
            bwrite.write(word + "\n");
            bwrite.close();

            do {
                System.out.print("Do you want to guess another word? Enter y or n> ");
                YNinput = sc.next();
                yn = YNinput.charAt(0);
            }
            while((yn != 'Y' && yn != 'y' && yn != 'N' && yn != 'n'));
        }
        while(yn == 'Y' || yn == 'y');
        sc.close();
        System.out.println("\nGood buy.");
    }
}