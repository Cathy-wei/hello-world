package Test;

import java.util.Comparator;

//1.����ѧ���࣬����ѧ�š��������ۺϲ����ܷ֡�ʹ��TreeSet����ѧ�����󣬰������ܷ��������������ͬ������������ ������õ��������ѧ������
class Student{
	String sno,name;
	int grade;
	public String toString() {
		return "ѧ�ţ�"+sno+"  ������"+name+"  �ܷ֣�"+grade;
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
		// TODO �Զ����ɵķ������
		if((s1.grade-s2.grade)>0)
			return -1;
		else if((s1.grade-s2.grade)<0)
			return 1;
		return s1.name.compareTo(s2.name);
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		

		
	}

	

}
