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
	/*public boolean equals(Object o) {
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
	*/
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
public class Student1 {/*implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {
		// TODO �Զ����ɵķ������
		if((s1.grade-s2.grade)>0)
			return -1;
		else if((s1.grade-s2.grade)<0)
			return 1; 
		return s1.name.compareTo(s2.name);
	}*/
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
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
