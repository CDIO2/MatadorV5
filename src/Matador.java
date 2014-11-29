import java.util.Scanner;

import javax.xml.bind.ValidationEvent;

import desktop_resources.GUI;
// klasse til ansvar for at styre spillet MATADOR
public class Matador {
	/*
	 * Variabler
	 */
	// instanziere de 12 felter fra MATADOR i et array
	private static Field[] felter = new Field[21];
	// instanziere et array til spillere
	private static Spiller[] spillere = null;
	// antal spillere i spillet
	private static int numberOfPlayers=0;
	// antal spillere i live
	private static int numberOfActivePlayers=0;
	// variable til at holde styr på hvilken spillers tur det er.
	private static int aktiveSpiller=1;
	// selve spillet bliver oprettet som en vaiabel. (rykket til MAIN METODE)
	//Matador spil;
	// et flag som kontrolere at første spiller er spiller 1, og kun slår en gang.
	private static boolean firstRun=true;	
	// et flag som kontrolere at korekte antal spiller vælges
	private static boolean playersselected=false;
	//flag til at kontrollere hvis spilleren har fået ekstra tur !
	private boolean specialFlag=false;
	// flag til at kontroller om en spiller har vundet !
	private static boolean spillerVundetFlag=false;
	private static Raflebæger raf = new Raflebæger();	

	/*
	 * Main Metode. bliver kørt når der trykkes RUN
	 */
	public static void main(String[] args) 
	{
		//opretter opjektet spil Af typen Matador. ( selve objektet vi bruger til at spille med )
		Matador spil = new Matador();
		//intializere felt værdier
		felter[0]=new Field(-100		,"Tribe Encampment"		,"betal RENT"		,1000	,"Territory");
		felter[1]=new Field(-300		,"Crater"				,"betal RENT"		,1500	,"Territory");
		felter[2]=new Field(-500		,"Mountain"				,"betal RENT"		,2000	,"Territory");
		felter[3]=new Field(-700		,"Cold Desert"			,"betal RENT"		,3000	,"Territory");
		felter[4]=new Field(-1000		,"Black cave"			,"betal RENT"		,4000	,"Territory");
		felter[5]=new Field(-1300		,"The Werewall"			,"betal RENT"		,4300	,"Territory");
		felter[6]=new Field(-1600		,"Mountain village"		,"betal RENT"		,4750	,"Territory");
		felter[7]=new Field(-2000		,"South Citadel"		,"betal RENT"		,5000	,"Territory");
		felter[8]=new Field(-2600		,"Palace gates"			,"betal RENT"		,5500	,"Territory");
		felter[9]=new Field(-3200		,"Tower"				,"betal RENT"		,6000	,"Territory");
		felter[10]=new Field(-4000		,"Castle"				,"betal RENT"		,8000	,"Territory");
		felter[11]=new Field(5000		,"Walled city"			,"Få penge"			,0		,"Refuge");
		felter[11].setFeltOwned(true);
		felter[12]=new Field(500		,"Monastery"			,"Få penge"			,0		,"Refuge");
		felter[12].setFeltOwned(true);
		felter[13]=new Field(-100		,"Huts in the mountain"	,"betal 100x terning",2500	,"Labor camp");
		felter[14]=new Field(-100		,"The pit"				,"betal 100x terning",2500	,"Labor camp");
		felter[15]=new Field(-2000		,"Goldmine"				,"betal SKAT"		,0		,"Tax");
		felter[15].setFeltOwned(true);
		felter[16]=new Field(-4000		,"Caravan"				,"betal SKAT / 4000",0		,"Tax");
		felter[16].setFeltOwned(true);
		felter[17]=new Field(-500		,"Second Sail"			,"betal 500-4000"	,4000	,"Fleet");
		felter[18]=new Field(-500		,"Sea Grover"			,"betal 500-4000"	,4000	,"Fleet");
		felter[19]=new Field(-500		,"The Buccaneers"		,"betal 500-4000"	,4000	,"Fleet");
		felter[20]=new Field(-500		,"Privateer armade"		,"betal 500-4000"	,4000	,"Fleet");
		
		
		//intializere spiller værdier
		while(!playersselected){
			Scanner scan= new Scanner(System.in);
			System.out.println("Vælg antal spillere");
			System.out.println("indtast 2-6 og tryk Retur");
			int num = scan.nextInt();
			if(2<=num && num<=6){
				System.out.println("antal spillere valgt: "+num);
				spillere= new Spiller[num+1];
				//System.out.println("a: ");
				for(int i =1;i<=num;i++)
				{	
					spillere[i]=new Spiller(("Spiller"+i),30000);
					//System.out.println("noget: "+i);
				}
				numberOfActivePlayers=num;
				numberOfPlayers=num;
				System.out.println("");
				//scan.close();
				playersselected=true;
			}else{
				System.out.println("ugyldigt antal spillere !");
				System.out.println("");
			}
		}
		// print i ved starten af spillet.
		System.out.println("Velkommen, tryk på Enter for at starte med at kaste");
    	System.out.println(""+spillere[aktiveSpiller].getNavn()+"'s tur");

		//test om spillet virker.. hardcode
    	/*spil.rykAntalPladser(11);
    	spil.rykAntalPladser(10);
    	spil.rykAntalPladser(1);

    	spil.rykAntalPladser(21);
    	spil.rykAntalPladser(21);
    	spil.rykAntalPladser(21);
    	spil.rykAntalPladser(21);
    	spil.rykAntalPladser(21);
    	spil.rykAntalPladser(21);
    	spil.rykAntalPladser(21);
    	spil.rykAntalPladser(21);
    	spil.rykAntalPladser(21);
    	spil.rykAntalPladser(21);
    	spil.rykAntalPladser(21);
    	spil.rykAntalPladser(21);
    	spil.rykAntalPladser(21);
    	spil.rykAntalPladser(21);
    	spil.rykAntalPladser(21);
    	spil.rykAntalPladser(21);
    	spil.rykAntalPladser(21);
    	spil.rykAntalPladser(21);
    	spil.rykAntalPladser(21);
    	spil.rykAntalPladser(21);//*/


    	Scanner tryk = new Scanner (System.in);
    	//Man starter spillet ved at trykke på "enter" og fortsætter med samme tast 
    	// kører dette i tilfælde af der trykkes Enter
		while(!spillerVundetFlag){
			raf.roll();
			int Sum = raf.getSum();	//Dette er summen af begge terninger
			if(firstRun==false)
			{	
				//System.out.println("11");
				spil.rykAntalPladser(Sum);
				//System.out.println("22");
			}
			//System.out.println("1");
			tryk.nextLine();
			//System.out.println("2");
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
		int value1 = raf.getvalue1(); //Dette er værdien af første terning
		int value2 = raf.getvalue2(); //Dette er værdien er anden terning
		System.out.println("du slog: "+value1+" & "+value2+" : "+terningResultat);
		// lokal variable bruges kun til at tælle pladser.
		int count = 1;
		// kontroller antal pladser der rykkes.
        while (count <= terningResultat) {
        	spillere[aktiveSpiller].incrementerPlads();
        	count++;
        }
        // HERUNDER, sættes op til at printe afhængig af hvilken spillers tur det er.
        int tempPlads=0;
        String tempNavn="";
        String tempBesked="";
        int tempBalance=0;
        
        tempPlads=spillere[aktiveSpiller].getPlads();
    	tempNavn=felter[(tempPlads-1)].getFeltNavn();
    	//System.out.println("Du landte på plads "+tempNavn);
    	//tempBesked=felter[(tempPlads-1)].getFeltbesked();
    	//System.out.println("BESKED: "+tempBesked);
    	System.out.println(""+spillere[aktiveSpiller].getNavn()+" er nu på felt "+tempPlads+" '"+tempNavn+"' ");
    	int tempFeltvaerdi=felter[(tempPlads-1)].getFeltVaerdi();
    	tempBalance= spillere[aktiveSpiller].getBalance();
    	//tjek om grund kan købes osv
    	//feltet er ejet. (enten af spiller eller kan ikke købes.)
    	if(felter[(tempPlads-1)].getFeltOwned())
    	{
    		//specielt eftersom hvor mange fleet har samme ejere !
    		if(felter[(tempPlads-1)].getFeltType()=="Fleet")
        	{
    			int tempInt= checkNumberOfFleets(felter[(tempPlads-1)].feltOwner);
    			spillere[aktiveSpiller].transaktionTilBalance(tempFeltvaerdi*tempInt);
    	        System.out.println("Pung: "+tempBalance+" & "+(tempFeltvaerdi*tempInt)+" : "+spillere[aktiveSpiller].getBalance());
        	}
    		//specielt eftersom mulighed for betale 4000 eller 10%
    		else if(felter[(tempPlads-1)].getFeltType()=="Tax")
        	{
    			if((tempPlads-1)==15)
    			{
    				
    			}
    			else if((tempPlads-1)==16)
    			{
    				//mulighed for at betale skat på 10% eller 4000.
    			}
        	}
    		//specielt eftersom der skal ganges med et antal der slås på terning.
    		// og yderliere ganges med antal labor camps med samme ejer.
    		else if(felter[(tempPlads-1)].getFeltType()=="Labor camp")
        	{
        		
        	}
    		else{
        	// alt andet.. betal eller få penge.
    			
    		}
    	}
    	else if(!felter[(tempPlads-1)].getFeltOwned())
    	{
    		if(felter[(tempPlads-1)].getFeltType()=="Territory")
        	{
        		
        	}
    		else if(felter[(tempPlads-1)].getFeltType()=="Labor camp")
        	{
        		
        	}
    		else if(felter[(tempPlads-1)].getFeltType()=="Fleet")
        	{
        		
        	}
    	}
    	
        spillere[aktiveSpiller].transaktionTilBalance(tempFeltvaerdi);
        System.out.println("Pung: "+tempBalance+" & "+tempFeltvaerdi+" : "+spillere[aktiveSpiller].getBalance());
        if(spillere[aktiveSpiller].getBalance()<=0)
        {
        	System.out.println("*"+spillere[aktiveSpiller].getNavn()+" DU HAR IKKE FLERE PENGE OG ER IKKE LÆNGERE MED I SPILLET*");
        }
        System.out.println("");
        
        if(spillere[aktiveSpiller].getBalance()<=0)
        {
        	if(spillere[aktiveSpiller].getPlayerActive()==true)
        	{
        		numberOfActivePlayers--;
        	}
        	spillere[aktiveSpiller].setPlayerActive(false);
        }
        
        if(numberOfActivePlayers<=1)
        {
        	spillerVundetFlag=true;
        }
        //skift spiller tur.
        skiftSpillerTur();
	        
        
        System.out.println(""+spillere[aktiveSpiller].getNavn()+"'s tur");
        
        if(spillerVundetFlag)
        {
        	System.out.println(""+spillere[aktiveSpiller].getNavn()+" HAR VUNDET!!!");
        	System.out.println("START NYT SPIL ! (KØR IGEN)");
        }
	}	
	private void skiftSpillerTur()
	{
		if(aktiveSpiller<spillere.length-1){
			aktiveSpiller++;
        	if((spillere[aktiveSpiller].getPlayerActive())==false)
        	{
        		skiftSpillerTur();
        	}
        }else{
        	aktiveSpiller=1;
        	if((spillere[aktiveSpiller].getPlayerActive())==false)
        	{
        		skiftSpillerTur();
        	}
        }
	}
	private int checkNumberOfFleets(int player)
	{
		int tempInt=0;
		for(int i=17;i<=20;i++){
			if(felter[i].getFeltOwner()==player)
			{
				tempInt++;
			}
		}
		return tempInt;
	}
}
