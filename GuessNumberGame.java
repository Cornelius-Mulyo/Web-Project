package acornapplication;
import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {

	public static void main(String[] args) {
		// Guess the Number Game
		Scanner scanner = new Scanner(System.in);
		System.out.println("You are Welcome to the Guess Number Game 5000!!");
		System.out.println("\nInstructions: The goal of the game is to guess the numeber between 1-100 ");
		System.out.println("\nIf you get it correct, you win. If it is too high or too low, you will be givem another attempt. You only have 7 attempts ");
		System.out.println("\nEnjoy the game, you got this!! ");
		System.out.println("\nPlEASE ENTER YOUR NAME ?");
		String name = scanner.nextLine();
		
		System.out.println("well, " + name + ", I am thinking of number between 1 and 100!");
		int myNumber = getRandomNumber(1,101);
		
		for (int i =0; i<7; i++) {
			
			Scanner scanner2 = new Scanner(System.in);
			System.out.println("Take a guess.");
			int yourGuess = scanner2.nextInt();
			
			if (yourGuess == myNumber) {
				System.out.println("You guessed correctly!");
				scanner.close();
				scanner2.close();
				break;
			}
			else if (yourGuess < myNumber) {
				// if the user guessed lower than the answer
				System.out.println("Your guess is too low!");
				
			}
			else if(yourGuess >myNumber) {
				System.out.println("Your guess is too high!");
			}
			
			if(i>=5) {
				
				// if the user gets the answer wrong too many times
				
				System.out.println();
				System.out.println("Nope. The number I was thinking of was " + myNumber + "!" );
				
				
			}
		
		}
		
	}
		
	
	
	
	public static int getRandomNumber(int min, int max) {
		
		Random random = new Random();
		return random.ints(min,max).findFirst().getAsInt();
		
		// GO HATTERS
		// Program By: Cornelius Mulyokela
	

	}
	

}
