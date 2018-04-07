import java.util.*;
/*Blas Kojusner
*COP 3502
*Dr. Boyer
*4-3-2017
*/
public class TattooCustomer {
	
	//initializing private variables
	private String name;
	private String tattoo;
	private int min;
	
	//making constructor
	public TattooCustomer(String name, String tattoo, int min){
		this.name = name;
		this.tattoo = tattoo;
		this.min = min;
	}
	
	//getter methods
	public String getName(){
		return name;
	}
	
	public String getTattoo(){
		return tattoo;
	}
	
	public int getMinutes(){
		return min;
	}
}
