package text;

abstract class Employee {
	abstract int YearSalary(int a );
}
class DaySalary extends Employee{
	int YearSalary(int a ) {
//		System.out.println("��н��Ա��");
		System.out.println("��н��Ա���깤�ʣ�"+a*365);
         return a*365;
	}
}
class WeekSalary extends Employee{
	int YearSalary(int b) {
		System.out.println("��н��Ա���깤�ʣ�"+b*56);
		return b*56;
	}
}
class MonthSalary extends Employee{
	int YearSalary(int b) {
		System.out.println("��н��Ա���깤�ʣ�"+b*12);
		return b*12;
	}
}

