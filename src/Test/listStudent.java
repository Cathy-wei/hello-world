package Test;

import java.util.*;

//5.����ѧ���࣬����ѧ�š��������ۺϲ����ܷ֣�ʹ��ArrayList����ѧ������
//�ȶ�ѧ�������ۺϲ����ܷ��������У���ʹ��Iterator��next�������List�е�Ԫ�ء�
//�ٰ�ѧ����ѧ�Ŵ�С��������ʹ��Iterator��forEachRemaining�������
//--��ʾ����ѧ����ʵ��Comparable�ӿڣ���ѧ�����������Ȼ���򡣰��۲����򣬲���ָ���Ƚ�������
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
	   return "ѧ�ţ�"+sno+" ������"+name+" �۲⣺"+grade;
   }

	@Override
	public int compareTo(Object o) {
		// TODO �Զ����ɵķ������
		int result;
		Stu s=(Stu)o;
		result=s.grade>this.grade? -1:(s.grade==this.grade? 0:1);
		if(result==0)
			result= s.sno.compareTo(sno);
		return result;
	}
}
class comprator implements Comparator<Stu>{

	@Override
	public int compare(Stu o1, Stu o2) {
		// TODO �Զ����ɵķ������
		return o1.sno.compareTo(o2.sno);
	}
	
}
public class listStudent {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		List<Stu> array = new ArrayList<Stu>();
		array.add(new Stu("11","����",90));
		array.add(new Stu("1","С��",70));
		array.add(new Stu("31","С��",80));
		Stu s= new Stu("31","С��",80);
//		array.sort();
		System.out.println(array);
		System.out.println("���۲��������򣬲���ָ���Ƚ�������:");
		Collections.sort(array);
		Iterator<Stu> it = array.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("��ѧ����ѧ�Ŵ�С��������,������Ȼ����:");
		comprator com=new comprator();
		array.sort(com);
		Iterator<Stu> itsno = array.iterator();
		itsno.forEachRemaining(String->System.out.println(String));
	}

}