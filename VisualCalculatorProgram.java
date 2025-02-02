   package mulyo;

import java.util.Scanner;

public class VisualCalculatorProgram {

	public static void main(String[] args) {
		// Visual Calculator Program
		int operator, n1, n2;
		System.out.println("1-Add \n 2 - Subrtract \n 3 - Multiply \n 4 - Divide");

		System.out.println("Choose operator: ");
		Scanner scanner = new Scanner(System.in);
		operator = scanner.nextInt();
		System.out.println("Enter first number : ");
		n1 = scanner.nextInt();
		System.out.println("Enter second number : ");
		n2 = scanner.nextInt();
		
		
		int result = 0;
		
		switch(operator) {
		case 1:
			result = n1 + n2;
			break;
			
		case 2:
			result = n1-n2;
			break;
		case 3:
			result = n1 * n2;
			break;
		case 4:
			result = n1 / n2;
			break;
			
			default:
				System.out.println("Entered operator is not valid");
		}
		
		System.out.println("The value is : " + result);
		scanner.close();
		
	// GO HATTERS
	// Cornelius Mulyokela
		
	}
}
