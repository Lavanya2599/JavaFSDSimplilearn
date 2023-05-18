package operations;

import java.util.Scanner;

public class arithmeticCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int choice;
		double num1,num2,result;
		
		System.out.print("Enter first number:");
		num1 = sc.nextDouble();
		
		System.out.print("Enter second number:");
		num2 = sc.nextDouble();
		
		System.out.println("\nSelect an operation:\n1. Addition\n2. Subtraction\n3. Mulitiplication\n4. Division\n");
		choice = sc.nextInt();
		
		switch (choice) {
		case 1:
			result = num1 + num2;
			System.out.println("\nAddition: " + result);
			break;
		case 2:
			result = num1 - num2;
			System.out.println("\nSubtraction: " + result);
			break;
		case 3:
			result = num1 * num2;
			System.out.println("\nMultiplication: " + result);
			break;
		case 4:
			result = num1 / num2;
			System.out.println("\nDivision: " + result);
			break;
		default:
			System.out.println("\nInvalid Choice");
			break;
		}
		 
	}

}
