package Test;

import java.util.Comparator;
import java.util.*;

//1.����ѧ���࣬����ѧ�š��������ۺϲ����ܷ֡�ʹ��TreeSet����ѧ�����󣬰������ܷ��������������ͬ������������ ������õ��������ѧ������
class Student implements Comparable{
	String sno,name;
	int grade;
	
	public Student(String sno, String name, int grade) {
		// TODO �Զ����ɵĹ��캯�����
		this.sno=sno;
		this.name=name;
		this.grade=grade;
	}
	public String toString() {
		return "ѧ�ţ�"+sno+"  ������"+name+"  �ܷ֣�"+grade;
	}

	@Override
	public int compareTo(Object o) {
		// TODO �Զ����ɵķ������
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
		set.add(new Student("3171104101","����",100));
		set.add(new Student("3171104112","����",50));
		set.add(new Student("3171104102","��",100));
		set.add(new Student("3171104139","����",77));
		Iterator<Student> it =set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		 
	}

	

}
