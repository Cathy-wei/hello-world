package Test;

import java.util.*;
import java.util.Map.Entry;

//2.ÿһ��ѧ�����ж�Ӧ�Ĺ����ء�??ѧ��Student����ַString��??ѧ�����ԣ����������䡣?
//ע�⣺������������ͬ����Ϊͬһ��ѧ����?��֤ѧ����Ψһ�ԡ�����map������
//��ѧ����Ϊ������ַ��Ϊֵ����map���ֱ�ʹ��keySet��entrySet����map��Ԫ��

class Students{
	String name;
	int age;
	public Students(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String toString() {
		return "������"+this.name+" ���䣺"+this.age;
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
		// TODO �Զ����ɵķ������
		HashMap <Students,String> map = new HashMap<Students,String>();
		map.put(new Students("����",18), "����");
		map.put(new Students("����",20), "����");
		map.put(new Students("С��",21), "�Ϻ�");
		System.out.println(map);
		//entrySet����
		Set<Entry<Students,String>> set = map.entrySet();
		Iterator<Entry<Students,String>> it = set.iterator();
		while(it.hasNext()) {
			Entry<Students,String> next = it.next();
			System.out.println(next.getKey()+" = "+next.getValue());
		}
		//keySet����

	}

}
