import java.util.Scanner;

public class DiceRoll {
	
	public static void main(String[] args) {
	Dice R1 = new Dice();
	
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
	int mod = scan.nextInt();
	
	R1.D(nRoll, nSide, mod); //Calls the function in the Dice Method		
	}

}
