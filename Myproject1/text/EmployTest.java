package text;

public class EmployTest {

	public static void main(String[] args) {
		DaySalary daySalary=new DaySalary();
		WeekSalary weekSalary=new WeekSalary();
		MonthSalary monthSalary=new MonthSalary();
		Company company=new Company();
		//一位日薪雇员的年工资
		company.employees[0]=daySalary.YearSalary(100);
		//一位周薪雇员的年工资
		company.employees[1]=weekSalary.YearSalary(500);
		//一位月薪雇员的年工资
		company.employees[2]=monthSalary.YearSalary(2000);
		//公司内三位员工的年薪总额
		int c=company.CountSalary( company.employees);
		System.out.println("公司每年的薪水总额   "+c);
		
	}

}
