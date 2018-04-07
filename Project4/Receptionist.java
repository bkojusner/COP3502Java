/**
 * This Class contains the constructor(s), variables, and methods that are necessary for Receptionist
 */
public class Receptionist extends Employee {
	private AssistantRegionalManager supervisor;
	private int maxTaskComplexityLevel;
	
	public Receptionist(int IDNumber, String name, Task[] taskList, AssistantRegionalManager supervisor, int maxTaskComplexityLevel){
		super(IDNumber,name,taskList);
		this.supervisor = supervisor;
		this.maxTaskComplexityLevel = maxTaskComplexityLevel;
	}
	
	public void setSupervisor(AssistantRegionalManager r){
		supervisor = r;
	}
	
	public void setMaxTaskComplexityLevel(int i){
		maxTaskComplexityLevel=i;
	}
	
	public AssistantRegionalManager getSupervisor(){
		return supervisor;
	}
	
	public int getMaxTaskComplexityLevel(){
		return maxTaskComplexityLevel;
	}
	
	public String toString(){
		String s="Receptionist\nName: "+super.getName()+"\nID: "+super.getIDNumber()+"\nTask List: \n";
		for(int i = 0; i<super.getTaskList().length;i++){
			if (super.getTaskList()[i]!=null){
				s+=super.getTaskList()[i].toString()+"\n";
			}
		}
		s+="Assistant Regional Manager: "+ supervisor.getName() +"\nMax Task Level: "+maxTaskComplexityLevel;
		
		return s;
	}
	
	public boolean equals(Receptionist r){
		boolean equal = super.equals(r);
		equal = equal && (r.getSupervisor().equals(supervisor));
		equal = equal && (r.getMaxTaskComplexityLevel() == maxTaskComplexityLevel);
		return equal;
	}
}
