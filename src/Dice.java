import java.util.Random;

//klasse ansvarlig for at gennerere et tilfældigt tal som en terning.
public class Dice {
	/*
	 *  Variabler
	 */
	private Random generator = new Random();
	private int value;
	
	/*
	 * Metoder
	 */
	
	// kast med en terning.
	public int roll() 
	{
		return value = generator.nextInt(6)+1;
	}
	
	// giver værdien af den kastet terning.
	public int getValue() 
	{
		return value;
	}
}

