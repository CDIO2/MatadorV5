// klasse med ansvar for at slå 2 terninger på samme tid.
public class Raflebæger {
/*
 * Variabler
 */
	// der instanizeres to terninger af typen Dice, med deres default constructor.
	private Dice dice1 = new Dice();
	private Dice dice2 = new Dice();
	/*
	 * Metoder
	 */
	//metode til at slå to terninger
	public void roll()
	{
		dice1.roll();
		dice2.roll();
	}
	// metode til at returnere terning 1's værdi
	public int getvalue1()
	{
		return dice1.getValue();
	}
	// metode til at returnere terning 2's værdi
	public int getvalue2()
	{
		return dice2.getValue();
	}
	// metode til at returnere summen af terningernes værdier.
	public int getSum()
	{
		return dice1.getValue() + dice2.getValue();
	}
}
