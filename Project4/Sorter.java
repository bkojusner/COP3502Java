

public class Sorter {

	public static Employee[] sort(Employee[] e) {
		Employee flag;
		Employee[] sort = new Employee[e.length];
		//sorts the array in Alphabetic order
		for (int i = 1; i < e.length; i++) {
			for (int j = i; j > 0; j--) {
				if ((e[j]!=null)&&(e[j].getName().compareToIgnoreCase(e[j - 1].getName())) < 0) {
						flag = e[j];
						e[j]=e[j-1];
						e[j-1]=flag;					
				}
			}
			
		}
		return e;
	}
}
