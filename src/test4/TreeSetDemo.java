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
		return "姓名："+name+" 出生日期："+df.format(date)+" 性别："+sex;
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
		// TODO 自动生成的方法存根
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
		Students stu0=new Students("阿华","1992-02-12","女");
		Students stu1=new Students("西西","1993-04-22","女");
		Students stu2=new Students("小红","1999-06-01","女");
		set.add(stu0);set.add(stu1);set.add(stu2);
		set.add(new Students("鸭鸭","1999-06-01","女"));
	//	System.out.println(set);
		Iterator<Students> it= set.iterator();
		while(it.hasNext()) {
			Students ss=it.next();
			System.out.println(ss);
		}
	//删除、查找
		set.remove(stu0);
		if(set.contains(stu0)) {
			System.out.println("找到了:\n"+stu0);
		}
		else System.out.println("未找到\n");
	}
	//排序

}
