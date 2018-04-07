/**
 * This Class contains the constructor(s), variables, and methods that are necessary for the Employee @super class.
 * RegionalManager, AssistantRegionalManager, SalesAssociate, and Receptionist all extend from this class 
 */
public abstract class Employee {
	private String name;
	private int IDNumber;
	private Task[] taskList;
	
	public Employee(int IDNumber, String name, Task[] taskList){
		this.IDNumber = IDNumber;
		this.name = name;
		this.taskList = taskList;
	}
	
	public void setName(String s){
		name = s;
	}
	
	public void setIDNumber(int i){
		IDNumber = i;
	}
	
	public void setTaskList(Task[] t){
		taskList = t;
	}
	
	public String getName(){
		if(name!=null)
			return name;
		else return"";
	}
	
	public int getIDNumber(){
		return IDNumber;
	}
	
	public Task[] getTaskList(){
		if(taskList!=null){
			return taskList;
		} else return taskList = new Task[0];
	}
	
	public String toString(){
		String s="Name: "+getName()+"\nID: "+getIDNumber()+"\nTask List: \n";
		for(int i = 0; i<getTaskList().length;i++){
			if (getTaskList()[i]!=null){
				s+=getTaskList()[i].toString();
				if(i<getTaskList().length-1)
					s+="\n";
			}
		}
		
		System.out.println(s);
		return s;
	}
	
	//equals method. Do not edit!
		public boolean equals(Employee e){
			boolean equal = true;
			equal = equal && (e.getIDNumber() == IDNumber);
			equal = equal && (e.getName().equals(name));
			for(int i = 0; i < taskList.length; i++){
				equal = equal && (taskList[i].equals(e.getTaskList()[i]));
			}
			return equal;
		}
	}

