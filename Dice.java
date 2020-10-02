import java.util.Arrays;

public class Dice {
	int Roll = 0;
	int Max = 0;
	int Min = 1;
	int Mod = 0;
	int[] arr;
	
	public void D(int roll, int Max, int Mod) {
		arr = new int[roll];
		for (int i = 0; i<roll;i++) {
			int q = (int)(Math.random() * Max) + Min;
			arr[i] = q;
		}
		System.out.println("Roll: " + Arrays.toString(arr));
		System.out.println("Sum: " + Arrays.stream(arr).sum() + " + " +  Mod);	
	}
}
