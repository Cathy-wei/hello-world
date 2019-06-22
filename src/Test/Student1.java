package Test;

import java.util.Comparator;
import java.util.*;

//1.创建学生类，包含学号、姓名、综合测评总分。使用TreeSet保存学生对象，按测评总分排序。如果分数相同，按姓名排序。 最后再用迭代器输出学生对象。
class Student implements Comparable{
	String sno,name;
	int grade;
	
	public Student(String sno, String name, int grade) {
		// TODO 自动生成的构造函数存根
		this.sno=sno;
		this.name=name;
		this.grade=grade;
	}
	public String toString() {
		return "学号："+sno+"  姓名："+name+"  总分："+grade;
	}

	@Override
	public int compareTo(Object o) {
		// TODO 自动生成的方法存根
		Student s=(Student)o;
		int i=grade>s.grade?-1:(grade==s.grade? 0:1);
		if(i==0)
			i=name.compareTo(s.name);
		return i;
	}
	
}
public class Student1 {
	public static void main(String[] args) {
		Set<Student> set=new TreeSet<Student>(); 
		set.add(new Student("3171104101","西西",100));
		set.add(new Student("3171104112","东东",50));
		set.add(new Student("3171104102","楠楠",100));
		set.add(new Student("3171104139","贝贝",77));
		Iterator<Student> it =set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		 
	}

	

}
