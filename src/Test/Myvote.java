package Test;

import java.util.*;

//3.дһ��ͳ��ͶƱ��������3����ѡ�ˣ���10�˲μ�ѡ�٣�ÿ��ѡ��������������ѡ�˵ı�ţ�Ҫ�����������ѡ�˵ĵ�Ʊ����
//��������������10��ѡ�����ύ�ĺ�ѡ�˱��
//��������������ѡ�˱�ż���Ӧ�ĵ�Ʊ��*
//Ҫ����map����ʾͶƱ�����

public class Myvote {
//	public void  ll(){
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
	//	int num[]=new int[3]; num[0]=1;num[1]=2;num[2]=3;
//		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		String num[]=new String[3]; 
	    num[0]="01";num[1]="02";num[2]="03";//��ѡ�߱��
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		map.put(num[0], 0);map.put(num[1], 0);map.put(num[2], 0);
		System.out.println(map);
		for(int k=1;k<=4;k++) {
	    System.out.println("��"+k+"λѡ����������������ѡ�ˣ�");
		for(int i=1;i<=2;i++) {
			Scanner sc=new Scanner(System.in);
			String in=sc.next();
			if(map.containsKey(in)) {
				Integer v=(Integer)map.get(in);
				map.put(in,++v);
			}
//			else
//				map.put(in, 1);
		}
		map.forEach((key,value)->System.out.println("��ѡ�ˣ�"+key+"��"+"   ��Ʊ��"+value));
		}
		System.out.println("ͶƱ������");
	}

	
}
