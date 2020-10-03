import java.util.Arrays;

public class Dice {
	int Roll = 0; //Number of rolls that will be made
	int Max = 0; //The total number of sides on the dice
	int Min = 1; //The lowest value a dice can have is 1
	int Mod = 0; //Modifier value that is specified by a character
	int[] arr; //An array to store the number of rolls made.
	
	public void D(int roll, int Max, int Mod) {
		//Create an array with size equal to the number of rolls that will be made
		arr = new int[roll]; 
		
		//loop that will fill the array with random numbers between 1 and n, 
		//n being the number of sides on the specific dice.
		for (int i = 0; i<roll;i++) {
			int q = (int)(Math.random() * Max) + Min;
			arr[i] = q;
		}
		//Prints all the values stored in the array
		System.out.println("Roll: " + Arrays.toString(arr));
		//Prints the sum of the array and then adding the modifier
		System.out.println("Sum: " + Arrays.stream(arr).sum() + " + " +  Mod);	
	}
}
