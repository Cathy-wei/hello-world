package text;

public class EmployTest {

	public static void main(String[] args) {
		DaySalary daySalary=new DaySalary();
		WeekSalary weekSalary=new WeekSalary();
		MonthSalary monthSalary=new MonthSalary();
		Company company=new Company();
		//һλ��н��Ա���깤��
		company.employees[0]=daySalary.YearSalary(100);
		//һλ��н��Ա���깤��
		company.employees[1]=weekSalary.YearSalary(500);
		//һλ��н��Ա���깤��
		company.employees[2]=monthSalary.YearSalary(2000);
		//��˾����λԱ������н�ܶ�
		int c=company.CountSalary( company.employees);
		System.out.println("��˾ÿ���нˮ�ܶ�   "+c);
		
	}

}
