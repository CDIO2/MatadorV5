// Klasse ansvarlig for at holde styr p� en Spiller Samt hans konto.
public class Spiller 
{
	/*
	 * Variabler
	 */
	// Opretter en variable af typen Konto.
   private Konto balanceKonto= new Konto();
   // Opretter en variable til at navngive Spilleren
   private String navn="";
   // Opretter en variable til at holde �je med hvor langt spilleren er n�et i spillet.
   private int boardPlads=0;
   
   /*
    * Metoder
    */
   
   // Constructor som bruges til at oprette Spiller med parameterene navn og balance.
   public Spiller(String navn,int balance)
   {
	   this.navn=navn;
	   balanceKonto.setBalance(balance);
   }
   // metode til at give hvilken plads spilleren er p� i spillet.
   public int getPlads()
   {
	   return boardPlads;
   }
   // metode til at s�tte spillerens plads hvis spilleren skal rykkes til en specifik plads.
   public void setPlads(int boardPlads)
   {
	   this.boardPlads=boardPlads;
   }   
   // metode til at rykke spilleren et antal pladser frem.
   public void incrementerPlads()
   {
	   // tjekker loop for spillet Matador.
	   if(boardPlads>=11)
	   {
		   this.boardPlads=1;
	   }else{
		   boardPlads++;
	   }
   }
   // metode til at give navnet p� spilleren.
   public String getNavn()
   {
	   return navn;
   }
   // metode til at give spillerens balance.
   public int getBalance()
   {
	   return balanceKonto.getBalance();
   }
   // metode til at �ndre spillerens balance til en given balance.
   public String setBalance(int balance)
   {
	   return balanceKonto.setBalance(balance);
   }
   // metode til at �ndre balancen uafh�ngigt af fortegn.
   public String transaktionTilBalance(int balance)
   {
	   return balanceKonto.transaktionTilBalance(balance);
   }
   // metode til at pludse balancen med et givent tal
   public String incrementBalance(int balance)
   {
	   return balanceKonto.incrementBalance(balance);
   }
   // metode til at tr�kke fra balancen.
   public String decrementBalance(int balance)
   {
	   return balanceKonto.decrementBalance(balance);
   }
}