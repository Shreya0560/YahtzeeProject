import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Yahtzee yahtzee = new Yahtzee();
        System.out.println(yahtzee.getScoreCard()); 
		Scanner scanner = new Scanner(System.in); 
		for(int i = 0; i < 2; i++) 
		{
			System.out.print("Enter die number(s) to keep (separated by a space):");
			String keepDice = scanner.nextLine(); 
			
			for(int j = 0; j < 5; j++) //looping through each index 0-4 in the array 1-5 checking if it is in the string KeepDice
			{  
				String k = ""  + (j + 1); //creates a string variable of k, doesn't turn it into a string
				if(keepDice.contains(k) != true)  
				{  
					yahtzee.rollADie(j); //reroll
				} 
			} 
			System.out.println(yahtzee.getScoreCard());  
		}
    }
} 

 
 