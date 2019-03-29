package text;

abstract class Employee {
	abstract int YearSalary(int a );
}
class DaySalary extends Employee{
	int YearSalary(int a ) {
//		System.out.println("日薪雇员类");
		System.out.println("日薪雇员的年工资："+a*365);
         return a*365;
	}
}
class WeekSalary extends Employee{
	int YearSalary(int b) {
		System.out.println("周薪雇员的年工资："+b*56);
		return b*56;
	}
}
class MonthSalary extends Employee{
	int YearSalary(int b) {
		System.out.println("月薪雇员的年工资："+b*12);
		return b*12;
	}
}

