package text;

public class Company{
	int[] employees=new int [3] ;
	private int Salary=0;
	int CountSalary(int [] employees) {
		for (int cs:employees)
			Salary+=cs;
	    return Salary;
	}
	
}