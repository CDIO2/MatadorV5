// Klasse ansvarlig for det enkelte felt.
public class Field 
{
	/*
	 * Variabler
	 */
	int feltVaerdi=0;
	String feltNavn="";
	String feltBesked="";
	int feltPris=0;
	String feltType="";
	boolean feltOwned=false;
	int feltOwner=0;
	/*
	 * Constructor
	 */
	// Instantizere objektet med en custom Constructor.
	public Field(int feltVaerdi, String feltNavn, String feltBesked, int feltPris, String feltType)
	{
		this.feltVaerdi=feltVaerdi;
		this.feltNavn=feltNavn;
		this.feltBesked=feltBesked;
		this.feltPris=feltPris;
		this.feltType=feltType;
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
	// metode som retunere prisen for feltet.
	public int getFeltPris()
	{
		return feltPris;
	}
	// metode som retunere navnet for feltet.
	public String getFeltType()
	{
		return feltType;
	}
	// metode som retunere prisen for feltet.
	public boolean getFeltOwned()
	{
		return feltOwned;
	}
	// metode som retunere navnet for feltet.
	public int getFeltOwner()
	{
		return feltOwner;
	}
	// metode som retunere prisen for feltet.
	public void setFeltOwned(boolean bougtOrLost)
	{
		this.feltOwned=bougtOrLost;
	}
	// metode som retunere navnet for feltet.
	public void setFeltOwner(int spiller)
	{
		this.feltOwner=spiller;
	}
	
}