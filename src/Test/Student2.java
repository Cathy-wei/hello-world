package Test;

import java.util.*;
import java.util.Map.Entry;

//2.每一个学生都有对应的归属地。??学生Student，地址String。??学生属性：姓名，年龄。?
//注意：姓名和年龄相同的视为同一个学生。?保证学生的唯一性。定义map容器，
//将学生作为键，地址作为值存入map。分别使用keySet与entrySet遍历map中元素

class Students{
	String name;
	int age;
	public Students(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String toString() {
		return "姓名："+this.name+" 年龄："+this.age;
	}
	public boolean equal(Object o) {
		if(!(o instanceof Students)) return false;
		Students s = (Students) o;
		if((s.age==age) && s.name.equals(name) )
			return true;
		else
			return false;
	}
	public int hashCode() {
		return this.name.hashCode()+age*37;
	}
}

public class Student2 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		HashMap <Students,String> map = new HashMap<Students,String>();
		map.put(new Students("西西",18), "北京");
		map.put(new Students("阿花",20), "北京");
		map.put(new Students("小明",21), "上海");
		System.out.println(map);
		//entrySet遍历
		Set<Entry<Students,String>> set = map.entrySet();
		Iterator<Entry<Students,String>> it = set.iterator();
		while(it.hasNext()) {
			Entry<Students,String> next = it.next();
			System.out.println(next.getKey()+" = "+next.getValue());
		}
		//keySet遍历

	}

}
