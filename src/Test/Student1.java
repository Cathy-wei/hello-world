package Test;

import java.util.Comparator;

//1.创建学生类，包含学号、姓名、综合测评总分。使用TreeSet保存学生对象，按测评总分排序。如果分数相同，按姓名排序。 最后再用迭代器输出学生对象。
class Student{
	String sno,name;
	int grade;
	public String toString() {
		return "学号："+sno+"  姓名："+name+"  总分："+grade;
	}
	public boolean equals(Object o) {
		if(!(o instanceof Student))
			return false;
		Student s=(Student) o;
		if((sno.equals(s.sno)) && (name.equals(s.name)) && (grade==s.grade))
			return true;
		return false;
	}
	public int hashCode() {
		int result;
		result=(sno==null? 0:name.hashCode());
		return result;
	}
}
public class Student1 implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {
		// TODO 自动生成的方法存根
		if((s1.grade-s2.grade)>0)
			return -1;
		else if((s1.grade-s2.grade)<0)
			return 1;
		return s1.name.compareTo(s2.name);
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		

		
	}

	

}
