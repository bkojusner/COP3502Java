/**
 * This Class contains the constructor(s), variables, and methods that are necessary for Regional Manager
 */
public class RegionalManager extends Employee {
	
	private int RegionNum;
	private int minimumTask;
	private Employee[] subordinates;
	
	public  RegionalManager(int IDNumber, String name, Task[] taskList, int RegionNum, Employee[] subordinates, int minimumTask){
		super(IDNumber,name,taskList);
		this.minimumTask = minimumTask;
		this.RegionNum = RegionNum;
		this.subordinates = subordinates;
	}
	
	RegionalManager(int IDNumber, String name, Task[] taskList, int RegionNum, int minimumTask){
		super(IDNumber,name,taskList);
		this.minimumTask = minimumTask;
		this.RegionNum = RegionNum;
	}
	
	public void setRegionNum(int i){
		RegionNum = i;
	}
	
	public void setMinimumTask(int i){
		minimumTask = i;
	}
	
	public void setSubordinates(Employee[] s){
		subordinates = s;
	}
	
	public int getRegionNum(){
		return RegionNum;
	}
	
	public int getMinimumTask(){
		return minimumTask;
	}
	
	public Employee[] getSubordinates(){
		if(subordinates!=null){
			return subordinates;
		} else return subordinates = new Employee[0];
	}
	
	public String toString(){
		String s="Regional Manager\nName: "+super.getName()+"\nID: "+super.getIDNumber()+"\nTask List: \n";
		for(int i = 0; i<super.getTaskList().length;i++){
			if (super.getTaskList()[i]!=null){
				s+=super.getTaskList()[i].toString()+"\n";
			}
		}
		s+="Region Number: "+RegionNum+"\nMinimum Task Level: "+minimumTask+"\nEmployees: \n";
		for(int i =0;i<getSubordinates().length;i++){
			if (getSubordinates()[i]!=null){
				s+=getSubordinates()[i].toString();
				if(i<getSubordinates().length-1)
					s+="\n";
			}
		}
		
		return s;
	}
	
	public boolean equals(RegionalManager r){
		boolean equal = super.equals(r);
		equal = equal && (r.getRegionNum() == RegionNum);
		equal = equal && (r.getMinimumTask() == minimumTask);
		for(int i = 0; i < subordinates.length; i++){
			equal = equal && (subordinates[i].equals(r.getSubordinates()[i]));
		}
		return equal;
	}

}
