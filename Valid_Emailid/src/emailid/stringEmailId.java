package emailid;

import java.util.Arrays;
import java.util.Scanner;

public class stringEmailId {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] emails = {"john@example.com", "iris@example.com", "bob@example.com", "alice@example.com"};
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter email to search\n");
		String searchEmailId = sc.nextLine();
		
		if(Arrays.asList(emails).contains(searchEmailId)) {
			System.out.println("EmailId found");
		}
		else {
			System.out.println("EmailId not found");
		}
		
	}

}
