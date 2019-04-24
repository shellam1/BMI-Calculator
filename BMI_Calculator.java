import java.util.Scanner;

public class BMI_Calculator {
/*
* This is initializing the the private objects for both scanners. 
*/
	private static Scanner input;
	private static Scanner scnr;

	public static void main(String[] args) {
		input = new Scanner (System.in);
		scnr = new Scanner(System.in);
		/*
		*Within the main method a string is printed out to the user, asking whether they'd like to continue and this method and used 
		* to run through the while loop calculator whenever the usesr would like to reenter more values.
		*/
		
		String command = "quit";
		System.out.print("Press Enter if you would to continue or type QUIT to exit: ");
		command = input.nextLine();
		while (!command.equalsIgnoreCase ("quit")) {
		/*
		*The user will be prompted to enter their weight in pounds
		*/
		System.out.print("Enter weight in pounds: ");
		int numWeight = scnr.nextInt();
		numWeight *= 703;
		/*
		*The user will be prompted to enter their height in feet
		*/
		System.out.print("Enter height in feet: ");
		int numFeet =  scnr.nextInt();
		/*
		*The user will be prompted to enter their height in inches
		*/
		System.out.print("             in inches: ");
		int numInches =  scnr.nextInt();
		/*
		*The program will than perform the calculations for the user's body Mass index
		*/
		int numHeight = (numFeet * 12) + numInches;
		double bodyMassIndex = numWeight / (Math.pow(numHeight, 2));
		/*
		*The program will now use if and else statements to determine and display which body type the calculated BMI falls under
		* along with their index
		*/
		if (bodyMassIndex < 18.5) {
			System.out.printf("%.2f\n", bodyMassIndex);
			System.out.println("You are underweight.");
		}
		else if (bodyMassIndex <= 25.9) {
			System.out.printf("%.2f\n", bodyMassIndex);
			System.out.println("You are normal weight");
		}
		else if (bodyMassIndex <= 29.9) {
			System.out.printf("%.2f\n", bodyMassIndex);
			System.out.println("You are overweight");
		}
		else {
			System.out.printf("%.2f\n", bodyMassIndex);
			System.out.println("You are obese");
		}
	/*
	*The program will now exit the loop and and ask the user whether they'd like to continue entering values. The program will 
	* end if the type "QUIT".
	*/
	System.out.print("Press Enter if you would to continue or type QUIT to exit: ");
	command = input.nextLine();
		}
	}
}
