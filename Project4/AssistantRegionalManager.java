/**
 * This Class contains the constructor(s), variables, and methods that are necessary for Assistant Regional Manager
 */
public class AssistantRegionalManager extends Employee {
	
	private RegionalManager manager;
	private int minimumTask;
	
	public AssistantRegionalManager(int IDNumber, String name, Task[] taskList, RegionalManager manager, int minimumTask){
		super(IDNumber,name,taskList);
		this.manager = manager;
		this.minimumTask = minimumTask;
	}
	
	public void setManager(RegionalManager r){
		manager = r;
	}
	
	public RegionalManager getManager(){
		return manager;
	}
	
	
	public void setMinimumTask(int i){
		minimumTask = i;
	}
	
	public int getMinimumTask(){
		return minimumTask;
	}
	
	public String toString(){
		String s="Assistant Regional Manager\nName: "+super.getName()+"\nID: "+super.getIDNumber()+"\nTask List: \n";
		for(int i = 0; i<super.getTaskList().length;i++){
			if (super.getTaskList()[i]!=null){
				s+=super.getTaskList()[i].toString()+"\n";
			}
		}
		s+="Regional Manager: "+ manager.getName()+"\nMinimum Task Level: "+minimumTask;
		
		return s;
	}
	
	public boolean equals(AssistantRegionalManager r){
		boolean equal = super.equals(r);
		equal = equal && (r.getMinimumTask() == minimumTask);
		equal = equal && (r.getManager().equals(manager));
		return equal;
	}

}
