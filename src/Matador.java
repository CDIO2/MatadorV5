import java.util.Scanner;
import desktop_resources.GUI;
// klasse til ansvar for at styre spillet MATADOR
public class Matador {
	/*
	 * Variabler
	 */
	// instanziere de 12 felter fra MATADOR i et array
	private static Felt[] felter = new Felt[11];
	// opretter Spiller 1
	private static Spiller spiller1;
	// opretter Spiller 2
	private static Spiller spiller2;
	// variable til at holde styr på hvilken spillers tur det er.
	private int aktiveSpiller=1;
	// selve spillet bliver oprettet som en vaiabel. (rykket til MAIN METODE)
	//Matador spil;
	// et flag som kontrolere at første spiller er spiller 1, og kun slår en gang.
	static boolean firstRun=true;
	//flag til at kontrollere hvis spilleren har fået ekstra tur !
	boolean specialFlag=false;
	static // flag til at kontroller om en spiller har vundet !
	boolean spillerVundetFlag=false;
	
	/*
	 * Main Metode. bliver kørt når der trykkes RUN
	 */
	public static void main(String[] args) 
	{
		//opretter opjektet spil Af typen Matador. ( selve objektet vi bruger til at spille med )
		Matador spil = new Matador();
		//intializere spiller værdier
		spiller1= new Spiller("Spiller1",1000);
		spiller2= new Spiller("Spiller2",1000);
		//intializere felt værdier
		felter[0]=new Felt(250,"Tower","en besked...");
		felter[1]=new Felt(-200,"Crater","en besked...");
		felter[2]=new Felt(-100,"Palace Gates","en besked...");
		felter[3]=new Felt(-20,"Cold Desert","en besked...");
		felter[4]=new Felt(180,"Walled City","en besked...");
		felter[5]=new Felt(0,"Monastery","en besked...");
		felter[6]=new Felt(-70,"Black Cave","en besked...");
		felter[7]=new Felt(-60,"Huts in the Mountain","en besked...");
		felter[8]=new Felt(-80,"The werewall","werewolfwall? EKSTRA TUR ! en besked...");
		felter[9]=new Felt(-90,"The Pit","en besked...");
		felter[10]=new Felt(650,"Goldmine","en besked...");
		Raflebæger raf = new Raflebæger();	
		// print i ved starten af spillet.
		System.out.println("Velkommen, tryk på Enter for at starte med at kaste");
    	System.out.println("spiller1 s tur");
    	// opretter en scanner der tjekker efter et tryk på BACKSPACE.

		//test om spillet virker.. hardcode
		spil.rykAntalPladser(11);
		spil.rykAntalPladser(7);
		spil.rykAntalPladser(11);
		spil.rykAntalPladser(8);
		spil.rykAntalPladser(11);
		spil.rykAntalPladser(12);
		spil.rykAntalPladser(11);
		spil.rykAntalPladser(12);
		spil.rykAntalPladser(11);
		
    	Scanner tryk = new Scanner (System.in); //Man starter spillet ved at trykke på "enter" og fortsætter med samme tast 
		// kører dette i tilfælde af der trykkes BACKSPACE
		while(!spillerVundetFlag){
			
			raf.roll();
			//int value1 = raf.getvalue1(); //Dette er værdien af første terning
			//int value2 = raf.getvalue2(); //Dette er værdien er anden terning
			int Sum = raf.getSum();	//Dette er summen af begge terninger
			if(firstRun==false)
			{	
				spil.rykAntalPladser(Sum);
			}
			tryk.nextLine();
			firstRun=false;
		}
		tryk.close();
	}
	/*
	 * METODER
	 */
	//metode til at rykke spilleren et antal pladser
	public void rykAntalPladser(int terningResultat)
	{
		// lokal variable bruges kun til at tælle pladser.
		int count = 1;
		// kontroller antal pladser der rykkes.
        while (count <= terningResultat) {
        	if(aktiveSpiller==1)
        	{
        		spiller1.incrementerPlads();
        	}
        	if(aktiveSpiller==2)
            {
        		spiller2.incrementerPlads();
        	}
        	count++;
        }
        // HERUNDER, sættes op til at printe afhængig af hvilken spillers tur det er.
        int tempPlads=0;
        String tempNavn="";
        String tempBesked="";
        if(aktiveSpiller==1)
    	{
        	tempPlads=spiller1.getPlads();
        	System.out.println("Spiller1 er nu på felt "+tempPlads);
        	tempNavn=felter[(tempPlads-1)].getFeltNavn();
        	System.out.println("Du landte på plads "+tempNavn);
        	tempBesked=felter[(tempPlads-1)].getFeltbesked();
        	System.out.println("BESKED: "+tempBesked);
            int tempFeltvaerdi=felter[(tempPlads-1)].getFeltVaerdi();
            spiller1.transaktionTilBalance(tempFeltvaerdi);
            System.out.println("Balance: "+spiller1.getBalance());
            
            if(spiller1.getBalance()>=3000)
            {
            	spillerVundetFlag=true;
            }
    	}
    	else
    	{
    		tempPlads=spiller2.getPlads();
        	System.out.println("Spiller2 er nu på felt "+tempPlads);
        	tempNavn=felter[(tempPlads-1)].getFeltNavn();
        	System.out.println("Du landte på plads "+tempNavn);
        	tempBesked=felter[(tempPlads-1)].getFeltbesked();
        	System.out.println("BESKED: "+tempBesked);
            int tempFeltvaerdi=felter[(tempPlads-1)].getFeltVaerdi();
            spiller2.transaktionTilBalance(tempFeltvaerdi);
            System.out.println("Balance: "+spiller2.getBalance());
            if(spiller2.getBalance()>=3000)
            {
            	spillerVundetFlag=true;
            }
    	}
        if(tempPlads==9){
        	specialFlag=true;
        }
        if(!spillerVundetFlag)
        {
	        if(!specialFlag)
	        {
		        if(aktiveSpiller==1){
		        	aktiveSpiller=2;
		        	System.out.println("spiller2 s tur");
		        	
		        }else{
		        	aktiveSpiller=1;
		        	System.out.println("spiller1 s tur");
		        }
	        }else{
	        	specialFlag=false;
	        }   
        }else{
        	System.out.println("SPILLER "+aktiveSpiller+" HAR VUNDET!!!");
        	System.out.println("START NYT SPIL ! (KØR IGEN)");
        }
	}	
}
