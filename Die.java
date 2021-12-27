import java.util.Random;
public class Die
{ 
	Random gen; 
	int numDie;
    public Die()
    {
		gen = new Random(); 
		numDie = gen.nextInt(6)+1;  
    }
    
    public void roll()
    {
		gen = new Random();  
		numDie = gen.nextInt(6)+1;
    }
    
    public int getValue()
    { 
		return numDie;
    }
}

