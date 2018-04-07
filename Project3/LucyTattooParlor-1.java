import java.util.*;

/*Blas Kojusner
*COP 3502
*Dr. Boyer
*4-3-2017
*/

public class LucyTattooParlor {
	
	public static void main(String [] args){
		//Declaring all the variables for the main class
		String workerNumber = args[0];
		int workerNum = Integer.parseInt(workerNumber);
		String customerPerArtist = args[1];
		int customerNum = Integer.parseInt(customerPerArtist);
		TattooCustomer[][] a = new TattooCustomer[workerNum][customerNum];
		
		//Initializing Scanner and boolean for the while loop menu
		Scanner input = new Scanner(System.in);
		boolean start = true;
		while (start){
			//Menu pop up to add customer
			System.out.println("Welcome to Lucy's!");
			System.out.println("~~~~~~~~~~~~~~~~~~");
			System.out.println("Type add to add a Customer ");
			String option = input.nextLine();
			System.out.println();
			
			//If customer puts add this is executed
			if (option.equalsIgnoreCase("add")){
				//Inputs are requested
				Scanner input1 = new Scanner(System.in);
				System.out.println("Please input Name: ");
				String name = input1.next();
				
				Scanner inputT = new Scanner(System.in);
				System.out.println("Please describe Tattoo: ");
				String tattoo = inputT.next();
				
				Scanner inputN = new Scanner(System.in);
				System.out.println("There are " + args[0] + " technicians working today");
				System.out.println("Waitlist capacity is: " + args[1]);
				System.out.println("Please enter Technician Number: (Press -1 for fastest Tech)");
				int artistNum = inputN.nextInt();
				
				Scanner inputM = new Scanner(System.in);
				System.out.println("Please enter expected Tattoo time: ");
				int min = inputM.nextInt();
				
				//Value c for the parameters is assigned here
				TattooCustomer c = new TattooCustomer(name, tattoo, min);
					
				//determines whether or not the method should execute the code
				//for the shortest waitlist
				if(artistNum == -1){
					addCustomer(a, c);
				}
				else{
					addCustomer(a, c, artistNum);
				}
	
			}	
			
			//if customer puts "Print Waitlist" this is executed
			else if(option.equalsIgnoreCase("print waitlist")) {
				
				//for loop printing out the 2-D array
				for(int n = 0; n < a.length; n++){
					for(int m = 0; m < a[n].length; m++){
						if (a[n][m]!= null){
						System.out.print("Artist : " + n);
						System.out.print("\n\tCustomer : " + m);
						System.out.print("\n\tName: " + a[n][m].getName() + "\n\tTattoo Type: " + a[n][m].getTattoo() + "\n\tMinutes Expected: " + a[n][m].getMinutes() + " \n");
						System.out.println("");
						}
					}
					System.out.println();
				}
				//exits the while loop
				start = false;
			}
		}
	}
	
	public static int computeMinutesOfWork(TattooCustomer [] a) {  
		
		//Simply calculates the time that is in a list to determine
		//if a person can be added or not
		int minutes = 0;
		
		for(int i = 0; i < a.length - 1; i++){
			if(a[i] != null){
				minutes += a[i].getMinutes();
			}
		}
		return minutes;
	} 

	public static boolean addCustomer(TattooCustomer [][] a, TattooCustomer c, int artistNum) {  
		
		//initializing variables
		boolean addCusto = true;
		int spotWaitList = 0;
		int occupiedSlots = 0;
		
		//Determines if the current spot is occupied or not for reference purposes
		for(int n = 0; n < a[artistNum].length; n++){
			if(a[artistNum][n] == null){
				occupiedSlots = n + 1;
				break;
			}
			else{
				occupiedSlots = n;
			}
		}
		
		//Assigns the spot on the waitlist the value of y for the next if-statement
		for(int y = 0; y < a[artistNum].length; y++){
			if(a[artistNum][y] == null){
				spotWaitList = y;
				break;
			}
		}
		
		//determines if the spot on the waitlist can add a customer to a spot or not
		if((computeMinutesOfWork(a[artistNum]) + c.getMinutes() <= 480)){
			//assigns the value of c to a certain spot on the array
			a[artistNum][spotWaitList] = c;
			System.out.println("");
		}else{
			//since there is not possibility of adding a person, it requests to try another list
			System.out.println("Oops! Please try another list");
		}		
		
		return addCusto;
	}
		
	public static boolean addCustomer(TattooCustomer [][] a, TattooCustomer c) { 
		
		//initializing variables
		int rowShort = 0; 
		int colShort = 0;
		int timeWait = 480;
		boolean timeWaitFinal = false;
		
		//loop determining which will be the fastest list
		for(int col = 0; col < a.length; col++){
			for(int row = 0; row < a.length; row++){
				if(a[row][col] != null){
					continue;
				}else if(a[row] != null && computeMinutesOfWork(a[row]) < timeWait){
					timeWaitFinal = true;
					timeWait = computeMinutesOfWork(a[row]);
					rowShort = row;
					colShort = col;
				}
			}
		}
		
		//assigns the values of c to the list of shortest length
		if(timeWaitFinal){
			if(computeMinutesOfWork(a[rowShort]) + c.getMinutes() <= 480){
				a[rowShort][colShort] = c;
				System.out.println("");
				return true;
			}
		}
		
		//if the statement is not met then we get an error message and the return is false
		System.out.println("Oops! Please try another list");
		return false;
	}

}