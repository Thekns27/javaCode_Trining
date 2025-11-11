import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class WhileDemo{
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		// Show Explanation
		System.out.println("==============================="); 
		System.out.println("=========GUESS NUMBER ===========");
		System.out.println("=====================");
		System.out.println();
		
		// loop start 
		// if same => finish loop
		boolean same = false;
		while(!same){

		// get user input 
		System.out.print("Your Number (1 .. 5): ");
		String input = sc.nextLine();
		int userInput = Integer.valueOf(input);

		// generate number
		int generated = ThreadLocalRandom.current().nextInt(1,5);

		

		// print generated nember
		System.out.println("Generated Number : " + generated);

		// print result
		same = userInput == generated ;

		String result = same? "You Win " : "You Loose";

		System.out.println(result);

		}
	}
} 