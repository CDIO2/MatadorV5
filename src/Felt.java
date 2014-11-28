// Klasse ansvarlig for det enkelte felt.
public class Felt 
{
	/*
	 * Variabler
	 */
	int feltVaerdi=0;
	String feltNavn="";
	String feltBesked="";
	/*
	 * Constructor
	 */
	// Instantizere objektet med en custom Constructor.
	public Felt(int feltVaerdi, String feltNavn, String feltBesked)
	{
		this.feltVaerdi=feltVaerdi;
		this.feltNavn=feltNavn;
		this.feltBesked=feltBesked;
	}
	/*
	 * Metoder
	 */
	// Metode til at modtage værdien for pladsen ( points )
	public int getFeltVaerdi()
	{
		return feltVaerdi;
	}
	// metode til at modtage beskeden som skal udsendes for feltet.
	public String getFeltbesked()
	{
		return feltBesked;
	}
	// metode som retunere navnet for feltet.
	public String getFeltNavn()
	{
		return feltNavn;
	}
}