import java.util.Scanner;

public class DiceRoll {
	
	public static void main(String[] args) {
	Dice R1 = new Dice(); //Calls the dice class
	
	//Scans for user input and throws errors if specific conditions are called
	Scanner scan = new Scanner(System.in);
	System.out.println("Number of rolls: ");
	int nRoll = scan.nextInt();
	if (nRoll == 0) {
		System.out.println("No roll was made!");
		System.exit(0);
	}
	
	System.out.println("How many sided dice: ");		
	int nSide = scan.nextInt();
	if (nSide == 0) {
		System.out.println("Not a valid Dice!");
		System.exit(0);
	}
	
	System.out.println("Modifiers: ");
	int m = scan.nextInt();
	
	//Calls the dice method and uses the parameters set up the user.
	R1.D(nRoll, nSide, m);		
	}

}
