package test4;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
class Students implements Comparable{
	String name;
	Date date;
	String sex;
	DateFormat df=new SimpleDateFormat("yyyy-mm-dd");
	Students(String name,String date,String sex) throws ParseException{
		this.name=name;
		this.sex=sex;
		this.date=df.parse(date);
	}
	public String toString() {
		return "������"+name+" �������ڣ�"+df.format(date)+" �Ա�"+sex;
	}
/*	public boolean equals(Object o) {
		if (!(o instanceof Students))
			return false;
		Students s=(Students) o;
		if((this.name.equals(s.name)) && (this.date.equals(s.date)) && (this.sex.equals(s.sex)))
			return true; 
		else
			return false;
	}
	public int hashCode() {
		int i=(name==null ? 0 : name.hashCode());
		return i;
	}*/
	public int compareTo(Object o) {
		// TODO �Զ����ɵķ������
		Students stu=(Students) o;
		int result;
		result=date.compareTo(stu.date);
		if(result==0) 
			result=name.compareTo(stu.name);
		return result;
	}
	
}
public class TreeSetDemo{

	public static void main(String[] args) throws ParseException {
		Set<Students> set=new TreeSet<Students>();
		Students stu0=new Students("����","1992-02-12","Ů");
		Students stu1=new Students("����","1993-04-22","Ů");
		Students stu2=new Students("С��","1999-06-01","Ů");
		set.add(stu0);set.add(stu1);set.add(stu2);
		set.add(new Students("ѼѼ","1999-06-01","Ů"));
	//	System.out.println(set);
		Iterator<Students> it= set.iterator();
		while(it.hasNext()) {
			Students ss=it.next();
			System.out.println(ss);
		}
	//ɾ��������
		set.remove(stu0);
		if(set.contains(stu0)) {
			System.out.println("�ҵ���:\n"+stu0);
		}
		else System.out.println("δ�ҵ�\n");
	}
	//����

}
