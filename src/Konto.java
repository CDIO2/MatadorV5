// Klassen Konto er ansvarlig for at holde styr p� indholdet af balancen
public class Konto
{
	/*
	 * Variabler
	 */
   private int balance=0;
   /*
    * Metoder
    */
   // metode til at retunere balancen p� kontoen.
   public int getBalance()
   {
	   return balance;
   }
   // metode til at �ndre balancen til en specifik v�rdi. ( ikke under nul, KRAV FRA OPGAVEN )
   public String setBalance(int balance)
   {
	   String resultat="fejl";
	   if(balance<0)
	   {
		   this.balance= 0;
		   resultat="intastet var mindre end nul. Balance sat til nul.";
	   }
	   else
	   {
		   this.balance= balance;
		   resultat="Balance korrekt �ndret";
	   }
	   return resultat;
   }
   // metode til at �ge balancen med et givent tal.
   public String incrementBalance(int balance)
   {
	   String resultat="fejl";
	   if( (this.balance+balance)<0 )
	   {
		   this.balance= 0;
		   resultat="Balance blev negativ. Balance er nu sat til nul.";
	   }
	   else
	   {
		   this.balance+= balance;
		   resultat="Balance korrekt �ndret";
	   }
	   return resultat;
   }
   // metode til at tr�kke et givent tal fra balancen.
   public String decrementBalance(int balance)
   {
	   String resultat="fejl";
	   if( (this.balance-balance)<0 )
	   {
		   this.balance= 0;
		   resultat="Balance blev negativ. Balance er nu sat til nul.";
	   }
	   else
	   {
		   this.balance-= balance;
		   resultat="Balance korrekt �ndret";
	   }
	   return resultat;
   }
   // Metode til at �ndre balancen med et givent tal. ( b�de negativ og positiv )
   public String transaktionTilBalance(int balance)
   {
	   String resultat="fejl";
	   if( (this.balance+balance)<0 )
	   {
		   this.balance= 0;
		   resultat="Balance blev negativ. Balance er nu sat til nul.";
	   }
	   else
	   {
		   this.balance+= balance;
		   resultat="Balance korrekt �ndret";
	   }
	   return resultat;
   }
}