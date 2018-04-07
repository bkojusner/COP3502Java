/**
 * This Class contains the constructor(s), variables, and methods that are necessary for Sales Associates
 */
public class SalesAssociate extends Employee {
	private int numClients;
	private String[] products;
	private RegionalManager supervisor;
	
	SalesAssociate(int IDNumber, String name, Task[] taskList, int numClients, String[] products, RegionalManager supervisor){
		super(IDNumber,name,taskList);
		this.numClients = numClients;
		this.products = products;
		this.supervisor = supervisor;
	}
	
	public void setProducts(String[] s){
		products = s;
	}
	
	public void setNumClients(int i){
		numClients= i;
	}
	
	public void setSupervisor(RegionalManager r){
		supervisor = r;
	}
	
	public String[] getProducts(){
		return products;
	}
	
	public int getNumClients(){
		return numClients;
	}
	
	public RegionalManager getSupervisor(){
		return supervisor;
	}
	
	public String toString(){
		String s="Sales Associate\nName: "+super.getName()+"\nID: "+super.getIDNumber()+"\nTask List: \n";
		for(int i = 0; i<super.getTaskList().length;i++){
			if (super.getTaskList()[i]!=null){
				s+=super.getTaskList()[i].toString()+"\n";
			}
		}
		s+="Regional Manager: "+ supervisor.getName()+"\nNumber of clients: "+numClients+"\nProducts to sell: \n";
		for (int i=0;i<products.length;i++){
			if(products[i]!=null){
				s+="\t"+products[i];
				if(i<products.length-1){
					if(products[i+1]!=null)
						s+="\n";
				}
			}
		}
		
		return s;
	}
	
	public boolean equals(SalesAssociate s){
		boolean equal = super.equals(s);
		equal = equal && (s.getNumClients() == numClients);
		equal = equal && (s.getSupervisor().equals(supervisor));
		
		for(int i = 0; i < products.length; i++){
			equal = equal && (products[i].equals(s.getProducts()[i]));
		}
		return equal;
	}
	
}
