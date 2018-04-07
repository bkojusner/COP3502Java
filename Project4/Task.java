/**
 * This Class contains the constructor(s), variables, and methods that are necessary for the task class
 */
public class Task {
	private String name;
	private int level;
	
	public Task(String name, int level){
		this.name=name;
		this.level=level;
	}
	
	public String getName(){
		return name;
		}
	
	public int getLevel(){
		return level;
	}
	
	public String toString(){
		return "\tTask: "+ name +"\tLevel: "+level;
	}
	
	public boolean equals(Task t){
		return ((t.getLevel() == level) && (t.getName().equals(name)));
	}
}
