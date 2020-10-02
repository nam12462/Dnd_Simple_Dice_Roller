import java.util.Arrays;

public class Dice {
	int Roll = 0; //Number of rolls to be made
	int Max = 0; //The max number of sides on a dice
	int Min = 1; //The dice cannot have a value less than 1
	int Mod = 0; //A modifier value that is specific to character.
	int[] arr; //An array to store the number of rolls made.
	
	public void D(int roll, int Max, int Mod) {
		//Create a new array that is n size and then fill the array
		//With random values between 1 and n based on
		// the number of sides on a dice roll.
		arr = new int[roll];
		for (int i = 0; i<roll;i++) {
			int Dice_roll = (int)(Math.random() * Max) + Min;
			arr[i] = Dice_roll;
		}
		//Prints out the stored values inside the array.
		System.out.println("Roll: " + Arrays.toString(arr)); 
		//Prints out the sum values of the array with a modifier at the end.
		System.out.println("Sum: " + Arrays.stream(arr).sum() + " + " +  Mod);	
	}
}
