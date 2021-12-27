import java.util.Random;
public class Yahtzee
{
	private Die[] dice; 
	private int[] counts;
	public Yahtzee()
	{
		dice = new Die[5]; //dice is an array of 5 Die objects
			
		for(int i = 0; i < 5; i++)
		{
			dice[i] = new Die();
		} 
		counts = new int[6];
		rollAllDice();
	} 

	public void rollADie(int dieNumber)
    {  
		(dice[dieNumber]).roll(); 
    }
    
	public void rollAllDice()
    { 
		for(int i = 0; i < dice.length; i++)
		{ 
			rollADie(i);  
		}  
		updateCounts();
    }
        
    public int getADie(int dieNumber)
    {
		return dice[dieNumber].getValue();
    }
    
    public String showDice()
    { 
        String diceShow = "";
        diceShow += ("+------+---+---+---+---+---+"); 
        diceShow += ("\n"); 
        diceShow += ("| Dice | 1 | 2 | 3 | 4 | 5 |");  
        diceShow += ("\n");
        diceShow += ("+------+---+---+---+---+---+"); 
        diceShow += ("\n");
        diceShow += ("| Face" + " " + "|" + " " + getADie(0) + " " + "|" + " " + getADie(1) + " " + "|" + " " + getADie(2) + " " + "|" + " " + getADie(3) + " " + "|" + " " + getADie(4) + " " + "|");      
        diceShow += ("\n");
        diceShow += ("+------+---+---+---+---+---+"); 
        return diceShow; 
    }  
    private int countUp(int value)
    {
		int n = 0;
		for(int i = 0; i < dice.length; i++)
		{
			if(dice[i].getValue() == value) //Need getValue because we want just the value of the die in that position of the dice array
			{
				n ++;
			} 
			else
			{ 
				continue;
			}
		} 
		return n;
    }
    private void updateCounts()
    { 
        for(int i = 0; i < 6; i++)
        {
			counts[i] = countUp(i + 1);
        } 
    }  
    public int getScoreOnes()
    {
		int Ones = 0;
		Ones = counts[0] * 1; 
		return Ones;
    }
  
    public int getScoreTwos()
    {
		int Twos = 0;
		Twos = counts[1] * 2; 
		return Twos;
    }
    
	public int getScoreThrees()
	{ 
		int Threes = 0;
		Threes = counts[2] * 3; 
		return Threes;
	}
    
	public int getScoreFours()
	{ 
		int Fours = 0;
		Fours = counts[3] * 4; 
		return Fours;
	}
    
	public int getScoreFives()
	{
		int Fives = 0;
		Fives = counts[4] * 5; 
		return Fives;
	}
    
	public int getScoreSixes()
	{
		int Sixes = 0;
		Sixes = counts[5] * 6; 
		return Sixes;
	} 
	public int getScoreThreeOfAKind()
	{  
		int ThreeOfAKindScore = 0; 
		boolean ThreeOfAKind = false;
		for(int i = 0; i < counts.length; i++)
		{ 
			if(counts[i] >= 3) //if we have a four of a kind, we can also have a 3 of a kind
			{   
				ThreeOfAKind = true; 
				for(int j = 0; j < dice.length; j++) 
				{  
				ThreeOfAKindScore += dice[j].getValue();
				} 
			break;
			}  
		} 
	return ThreeOfAKindScore;         
    }
    
   public int getScoreFourOfAKind()
   {   
		int FourOfAKindScore = 0; 
		boolean FourOfAKind = false;
		for(int i = 0; i < counts.length; i++)
		{ 
			if(counts[i] >= 4)  
			{   
				FourOfAKind = true; 
				for(int j = 0; j < dice.length; j++) 
				{  
					FourOfAKindScore += dice[j].getValue();
				} 
				break;
			}  
		} 
		return FourOfAKindScore;   	
    }
    
    public int getScoreFullHouse()
    { 
		boolean ThreeOfAKind = false;
		for(int i = 0; i < counts.length; i++)
		{ 
			if(counts[i] == 3)  
			{   
				ThreeOfAKind = true; 
				break;
			} 
		}  
		boolean TwoOfAKind = false;
		for(int i = 0; i < counts.length; i++)
		{ 
			if(counts[i] == 2)  
			{   
				TwoOfAKind = true;  
				break;
			} 
		}  
		if(ThreeOfAKind && TwoOfAKind) 
		{  
			return 25;
		} 
		else 
		{ 
			return 0;
		}
    }
    
    public int getScoreSmallStraight() //poss = 1234, 2345, 3456
    {
		int SmallStraightScore = 0; 
		boolean Straight1234 = false;  
		if(counts[0] > 0 &&  counts[1] > 0 && counts[2] > 0 && counts[3] > 0)
		{ 
			Straight1234 = true;
		}  
		
		boolean Straight2345 = false; 
		if(counts[1] > 0 &&  counts[2] > 0 && counts[3] > 0 && counts[4] > 0)
		{ 
			Straight2345 = true;
		}   
		
		boolean Straight3456 = false;
		if(counts[2] > 0 &&  counts[3] > 0 && counts[4] > 0 && counts[5] > 0)
		{ 
			Straight3456 = true;
		}  
		
		if(Straight1234 == true || Straight2345 == true || Straight3456 == true) 
		{  
			SmallStraightScore = 30;
		}  
		return SmallStraightScore;
    }
    
    public int getScoreLargeStraight() //poss = 12345, 23456
    {  
		int LargeStraightScore = 0; 
		boolean Straight12345 = false; 
		if(counts[0] > 0 &&  counts[1] > 0 && counts[2] > 0 && counts[3] > 0 && counts[4] > 0)
		{ 
			Straight12345 = true;
		}  
		
		boolean Straight23456 = false; 
		if(counts[1] > 0 &&  counts[2] > 0 && counts[3] > 0 && counts[4] > 0 && counts[5] > 0)
		{ 
			Straight23456 = true;
		}   
		
		if(Straight12345 == true || Straight23456 == true) 
		{  
			LargeStraightScore = 30;
		}  
		return LargeStraightScore;
    }
    
    public int getScoreChance()
    { 
		int total = 0; 
		for(int i = 0; i < dice.length; i++ ) 
		{  
			total += dice[i].getValue(); 
		} 
		return total;
    }
    
    public int getScoreYahtzee()
    { 
		int YahtzeeScore = 0; 
		boolean Yahtzee = false;
		for(int i = 0; i < counts.length; i++)
		{ 
			if(counts[i] >= 5)
			{   
				Yahtzee = true;
				break;				
			}  
			else 
			{  
				Yahtzee = false;
			}
		} 
		if(Yahtzee) 
		{  
			YahtzeeScore = 50; 
		}  
		return YahtzeeScore;
	}  
	public String getScoreCard()
    { 
	  String ScoreCard = "";
      ScoreCard += ("+------+---+---+---+---+---+"); 
      ScoreCard += ("\n"); 
      ScoreCard += ("| Dice | 1 | 2 | 3 | 4 | 5 |");  
      ScoreCard += ("\n");
      ScoreCard += ("+------+---+---+---+---+---+"); 
      ScoreCard += ("\n");
      ScoreCard += ("| Face" + " " + "|" + " " + getADie(0) + " " + "|" + " " + getADie(1) + " " + "|" + " " + getADie(2) + " " + "|" + " " + getADie(3) + " " + "|" + " " + getADie(4) + " " + "|");      
      ScoreCard += ("\n");
	  ScoreCard += ("+------+---+---+---+---+---+");   
	  ScoreCard += ("\n"); 
	  ScoreCard += ("\n");
	  ScoreCard += ("           Ones: " + this.getScoreOnes()); 
	  ScoreCard += ("\n");
      ScoreCard += ("           Twos: " + this.getScoreTwos()); 
	  ScoreCard += ("\n");
      ScoreCard += ("         Threes: " + this.getScoreThrees()); 
	  ScoreCard += ("\n");
      ScoreCard += ("          Fours: " + this.getScoreFours()); 
	  ScoreCard += ("\n");
      ScoreCard += ("          Fives: " + this.getScoreFives()); 
	  ScoreCard += ("\n");
      ScoreCard += ("          Sixes: " + this.getScoreSixes());  
	  ScoreCard += ("\n");
	  ScoreCard += ("\n");
	  ScoreCard += ("Three of a Kind: " + this.getScoreThreeOfAKind()); 
	  ScoreCard += ("\n");
      ScoreCard += (" Four of a Kind: " + this.getScoreFourOfAKind()); 
	  ScoreCard += ("\n");
      ScoreCard += ("     Full House: " + this.getScoreFullHouse()); 
	  ScoreCard += ("\n");
      ScoreCard += (" Small Straight: " + this.getScoreSmallStraight()); 
	  ScoreCard += ("\n");
      ScoreCard += (" Large Straight: " + this.getScoreLargeStraight()); 
	  ScoreCard += ("\n");
      ScoreCard += ("         Chance: " + this.getScoreChance()); 
	  ScoreCard += ("\n");
      ScoreCard += ("        Yahtzee: " + this.getScoreYahtzee());  
	  return ScoreCard;
    }
}
 

    