package ca.senecacollege.workshop4;

//imports
import java.io.File;
import java.util.Scanner;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class Hangman {
	public static void hangman() throws IOException {
		File file = new File("words.txt"); 
		Scanner input = new Scanner(file);
		String[] listOfWords = new String[1]; 
          
		while(input.hasNext()) {
			String data = input.nextLine();
			int i = 0;
          
			listOfWords[listOfWords.length - 1] = data;
			String[] temp = new String[listOfWords.length];
              
			temp = listOfWords;
              
			listOfWords = new String[listOfWords.length+1];
			listOfWords[listOfWords.length -1] = data;
              
			for(String a : temp) {
				listOfWords[i++]= a;
			}
		}       
		input.close(); 
          
		//Testing purposes to see if text file contents are in an array
		/*for (String a: listOfWords) {
			System.out.println(a);
		}*/
      
		///////////////////////////////////// Game Begins ///////////////////////////////////////////////////////
		Random random = new Random();
		boolean playing = true;
      
		Scanner userInput = new Scanner(System.in); 
      
		while(playing) {
			System.out.println("Welcome to Nisha's game of Hangman!");
			System.out.println("If you wish to exit game at any point, enter an exclamaintion mark (!)");
			System.out.println("The game is about to start... Goodluck!");
			System.out.println();
          
			char[] randomWord = listOfWords[random.nextInt(listOfWords.length)].toUpperCase().toCharArray();
			//System.out.println(randomWord); //testing to see which word it is -> remove later
			int numOfGuesses = randomWord.length; 
			char[] userGuess = new char[numOfGuesses]; 
			char[] guessedWords = new char[numOfGuesses];
          
			//set each field to an asterisk
			for (int i = 0; i < userGuess.length; i++) {
				userGuess[i] = '*'; 
			}
          
			boolean gotWord = false; 
			int attempts = 0; 
			int wrongGuess = 0;
              
			
			while(!gotWord && attempts != numOfGuesses) {
				currentNumOfGuesses(userGuess); 
				System.out.println("You have " + (numOfGuesses - attempts) + " guesses");
				System.out.print("\n(Guess) Enter a letter in this word: >");
				char in = userInput.nextLine().toUpperCase().charAt(0); 
				boolean duplicateWord = false;
				for (char c : guessedWords) {
					if (c == in) {
						System.out.println("Sorry, you already tried " + in);
						duplicateWord = true;
						break;
					} 
				}
				guessedWords[attempts] = in;
				
				if (!duplicateWord) {
                  attempts++;
				}
              
				if(in == '!') { 
					playing = false;
					gotWord = true; 
				}
				else {
					boolean match = false;
					for(int i = 0; i < randomWord.length; i++) {
						if(randomWord[i] == in) {
							userGuess[i] = in;
							match = true;
						}
					}   
                  
					if (!match && !duplicateWord){
						System.out.println("Sorry, " + in + " is not in the word");
						wrongGuess++;
					}

					if(didUserGuess(userGuess)) {
						gotWord = true;
                      
						System.out.println("\nCongratulations! You Won!!!!");
						System.out.print("The word was: ");
						System.out.print(randomWord); 
						System.out.println(". You Missed " + wrongGuess + " time(s)");
                      
						System.out.println("Enter a new word here to be added in Memory: ");
						String usersNewWord = userInput.nextLine();
						File file2 = new File("words.txt");
						printWordToFile(usersNewWord, file2);
                  }
              }
          }
			
          if(!gotWord) {
              System.out.println("\nOh no, you ran out of Guesses!");
              System.out.print("The word was: ");
              System.out.print(randomWord); 
              System.out.println(". You Missed " + wrongGuess + " time(s)");
              System.out.println("Enter a new word here to be added in Memory: ");
              String usersNewWord = userInput.nextLine();
              File file3 = new File("words.txt");
              printWordToFile(usersNewWord, file3);
          }
          
          System.out.println("Do you want to guess another word? Enter (y or n): ");
          char nextGame = userInput.nextLine().charAt(0);
          if(nextGame == 'n') {
              playing = false;
          
          }
      
		}
		System.out.println("You are Exiting the game! Goodbye.");    
	}
  
	public static void currentNumOfGuesses(char[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
  
	public static boolean didUserGuess(char[] array) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == '*') {
				return false;
			}
		}
		return true;
	}
  
	public static void printWordToFile(String s, File f) throws IOException{
		FileWriter output = new FileWriter(f, true);
		output.write("\n" + s);
		output.close();
      
	}

}