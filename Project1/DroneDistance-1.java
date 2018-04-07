//Blas Kojusner
//1A64
//Prof. Boyer
//February 1, 2017
//This program determines whether or not drones need to be closer or farther apart in flight.

//importing necessary classes for code to execute appropriately
import java.util.Scanner;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

//Declaring the DroneDistance class
public class DroneDistance {
	
	public static void main(String[] args){
		
		//Declaring the Scanner class and variables to be used		
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the x coordinate of Drone 1:");
		double droneOneX = input.nextDouble();	
		System.out.println("Please enter the y coordinate of Drone 1:");
		double droneOneY = input.nextDouble();
		System.out.println("Please enter the altitude coordinate of Drone 1:");
		double droneOneAlt = input.nextDouble();
		System.out.println("Please enter the x coordinate of Drone 2:");
		double droneTwoX = input.nextDouble();
		System.out.println("Please enter the y coordinate of Drone 2:");
		double droneTwoY = input.nextDouble();
		System.out.println("Please enter the altitude coordinate of Drone 2:");
		double droneTwoAlt = input.nextDouble();
		
		//Calculating distance of drones in 3D space
		double distanceX = droneTwoX - droneOneX;
		double distanceY = droneTwoY - droneOneY;
		double finalDistance = sqrt(pow(distanceX,2) + pow(distanceY,2));
		double differenceInSum = droneTwoAlt - droneOneAlt;
		double distanceAlt = sqrt(pow(distanceX,2) + pow(distanceY,2) + pow(differenceInSum,2));
		
		//Doing if-else statement for the drones on the (x,y) plane
		if(finalDistance < 1){
		System.out.println("The two drones are " + finalDistance + " feet apart in (x,y) coordinates. They need to move farther apart in (x,y).");
		}
		else if(1 < finalDistance && finalDistance < 500){
		System.out.println("The two drones are " + finalDistance + " feet apart in (x,y) coordinates. They do not need to move farther apart or closer in (x,y).");
		}
		else if(500 < finalDistance){
			System.out.println("The two drones are " + finalDistance + " feet apart in (x,y) coordinates. They need to move closer together in (x,y).");
		}
		
		//Doing the if-else statement for the drones in altitude
		if(distanceAlt < 1){
		System.out.println("The two drones are " + distanceAlt + " feet apart in altitude coordinates. They need to move farther apart in altitude.");
		}
		else if(1 < distanceAlt && distanceAlt < 500){
		System.out.println("The two drones are " + distanceAlt + " feet apart in altitude coordinates. They do not need to move farther apart or closer in altitude.");
		}
		else if(500 < distanceAlt){
		System.out.println("The two drones are " + distanceAlt + " feet apart in altitude coordinates. They need to move closer together in altitude.");
		}
		
	}
	
}
