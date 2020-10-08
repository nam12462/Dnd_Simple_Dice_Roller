import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

public class Dice_GUI extends JFrame implements ActionListener{
	int MinValue = 1; //Minimum roll value cannot be less than 1
	int MaxValue = 0; //Max value will be set by the user.
	int RollStart = 0; //Used to determine how many rolls the user wants.
	int sum = 0; //The total value of all the rolls made.
	int Mod = 0; //The modifier value the user sets.
	int integer;
	private static final int [] Dice_Sides = {3,4,6,8,10,12,20,100};
	int[] storage; //Used to store where the rolls are made.
	
	private TextField RollCount;
	private TextField Modifier;
	private TextField resultField;
	private TextField Total;
	private TextArea PastResultArea;
	private ButtonGroup BGroup;
	
	public Dice_GUI() {
		//Initial setup of a GUI
		setTitle("DnD Dice Roller");
		setLayout(new FlowLayout());
		setSize(500, 400);
		setResizable(false);

		//Panel that takes in user input of how many dice will be rolled.
		JPanel ND= new JPanel();
		ND.add(new JLabel("Number of Dice: "));
		ND.add(RollCount = new TextField(5));
		RollCount.addActionListener(this);
		add(ND);
		
		//Panel that fills in the radio button with information and added to a 
		//button group so that only one button can be selected at a time.
		JPanel sides = new JPanel();
		sides.add(new JLabel("Dice Sides: "));
		BGroup =new ButtonGroup();
		JRadioButton[] diceS = new JRadioButton[8];
		for(int i =0; i<Dice_Sides.length;i++) {
			diceS[i] = new JRadioButton(String.valueOf(Dice_Sides[i]));
			diceS[i].addActionListener(this);
			sides.add(diceS[i]);
			BGroup.add(diceS[i]);
		}
		add(sides);
		
		//Field to put in modifier value
		JPanel ModVal = new JPanel();
		ModVal.add(new JLabel("Modifier: "));
		ModVal.add(Modifier = new TextField(5));
		Modifier.addActionListener(this);
		add(ModVal);
		
		//Buttons for rolling, clearing, or exiting
		JPanel buttons = new JPanel();
		JButton Roll = new JButton("Roll");
		Roll.addActionListener(this);
		buttons.add(Roll);
		
		JButton Clear = new JButton("Clear");
		Clear.addActionListener(this);
		buttons.add(Clear);
		
		JButton exit = new JButton("Exit");
		exit.addActionListener(this);
		buttons.add(exit);
		add(buttons);
		
		//Area to display the all of the roll values.
		JPanel results = new JPanel();
		results.setLayout(new GridLayout(0,1));
		results.add(new JLabel("Results: "));
		resultField = new TextField(50);
		resultField.setEditable(false);
		results.add(resultField);	
		
		//Area to display the sum of the results.
		results.add(new JLabel("Total: "));
		Total = new TextField(50);
		Total.setEditable(false);
		results.add(Total);
		add(results);		
		
		//This is the area to display all of the past results
		JPanel pastArea = new JPanel();
		pastArea.setLayout(new BorderLayout());
		pastArea.add(new JLabel("All Past Results: "), BorderLayout.NORTH);
		PastResultArea = new TextArea(5, 50);
		PastResultArea.setEditable(false);
		JScrollPane Panel = new JScrollPane(PastResultArea);
		pastArea.add(Panel, BorderLayout.CENTER);
		add(pastArea);
	}
	
	public void Dice_Roll(int nRoll, int dSides) {
		//First create an array and make it size N (N being 
		//the number of dice that will be rolled). Then iterate
		//through the array and filling in the values with random 
		//numbers between the max value selected by the user
		// and the minimum value of 1 (because the lowest value on a 
		//dice is 1).
		storage = new int[nRoll];
		for(int i =0;i<nRoll;i++) {
			int q = (int)(Math.random()*dSides) + MinValue;
			storage[i] = q;
		}
		//A new loop to iterate though the array and get the sum.
		for(int i=0;i<storage.length;i++) {
			sum += storage[i];
		}
	}
	
	public void result() {
		//Basically fills the results sections
		resultField.setText(Arrays.toString(storage));
		Total.setText(String.valueOf(sum) + " + " + Mod);
		
		//Take the information from result fields and convert them into strings,
		//then adds it into a textarea to show all past results by appending
		//and setting a new line with "\n".
		String text = resultField.getText();
		String num = Total.getText();
		PastResultArea.append("Rolls: " + text + " Sum: " +  num + "\n");
	}
	
	//Checks to see if no input was provided by the user
	//otherwise the program will operate.
	public void check_input(){
		if(RollCount.getText().isEmpty()) {
			error();
			return;
		}
	}
	
	//Clears all the fields.
	public void clear_input(){
		MaxValue = 0;
		sum = 0;
		RollCount.setText("");
		Modifier.setText("");
		BGroup.clearSelection();
		resultField.setText("");
		Total.setText("");
		PastResultArea.setText("");
	}
	
	//Throw an error in the cases where no input is provide,
	//Therefore a roll could not have been made.	
	public void error() {
		resultField.setText("No Roll Was Made! Try Again");
	}
	
	public void notInt() {
		resultField.setText("Value is not an integer! Try Again!");
	}
	
	public void actionPerformed(ActionEvent e) {
		String arg = e.getActionCommand();
		
		//If a certain radio button is press the Max value is then set.
		//There has to be a cleaner way of setting this up, right?
		if(arg.equals("3")) {MaxValue = 3;}
		if(arg.equals("4")) {MaxValue = 4;}
		if(arg.equals("6")) {MaxValue = 6;}
		if(arg.equals("8")) {MaxValue = 8;}
		if(arg.equals("10")) {MaxValue = 10;}
		if(arg.equals("12")) {MaxValue = 12;}
		if(arg.equals("20")) {MaxValue = 20;}
		if(arg.equals("100")) {MaxValue = 100;}
		
		//Adding functionality of the buttons.
		if(arg.equals("Roll")) {
			//Checks to see if user provided anything other than an 
			//integer to the input fields
			try {integer = Integer.parseInt(RollCount.getText());
			}catch (NumberFormatException error) {
				notInt();
				return;
			}
			try {integer = Integer.parseInt(Modifier.getText());
			}catch (NumberFormatException error) {
				notInt();
				return;
			}
			//Tried to move the input checker into it's own method,
			//but numberformatexception error will be thrown when
			//it is move out of this function. 
			
			check_input();
			RollStart=Integer.parseInt(RollCount.getText());
			if(Modifier.getText().isEmpty()) {Mod = 0;}
			else {Mod=Integer.parseInt(Modifier.getText());}
			Dice_Roll(RollStart,MaxValue);
			result();
			sum=0;
			}
				
		}else if(arg.equals("Clear")) {
			clear_input();
		}else if(arg.equals("Exit")) {
			System.exit(0);
		}
	}



}
