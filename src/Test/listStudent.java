package Test;

import java.util.*;

//5.创建学生类，包含学号、姓名、综合测评总分，使用ArrayList保存学生对象。
//先对学生对象按综合测评总分升序排列，再使用Iterator的next方法输出List中的元素。
//再按学生的学号从小到大排序，使用Iterator的forEachRemaining方法输出
//--提示，将学生类实现Comparable接口，按学号排序采用自然排序。按综测排序，采用指定比较器排序
class Stu implements Comparable {
	String name;
	int grade;
	String sno;
	
   Stu(String sno, String name, int grade) {
		this.sno=sno;
		this.name=name;
		this.grade=grade;
	}
   public String toString() {
	   return "学号："+sno+" 姓名："+name+" 综测："+grade;
   }

	@Override
	public int compareTo(Object o) {
		// TODO 自动生成的方法存根
		int result;
		Stu s=(Stu)o;
		result=s.grade>this.grade? -1:(s.grade==this.grade? 0:1);
		if(result==0)
			result= s.sno.compareTo(sno);
		return result;
	}
}
public class listStudent {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		List<Stu> array = new ArrayList<Stu>();
		array.add(new Stu("11","西西",90));
		array.add(new Stu("1","小兰",70));
		array.add(new Stu("31","小蜜",80));
		System.out.println(array);
		Iterator<Stu> it = array.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		Collections.sort(array);
		System.out.println("默认比较器：\n"+array);
//		it.forEachRemaining(s->System.out.println(s));
	}

}
