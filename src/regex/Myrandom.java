package regex;

import java.util.*;

public class Myrandom {

	public static void main(String[] args) {
//		ʹ�����������ʮ��������0--99��������һ�������У�
		Random r=new Random();
		int a[]=new int[10];
		for(int i=0;i<10;i++) {
			a[i]=r.nextInt(100);
			System.out.print(a[i]+",");
		}
//		Ȼ��ʹ������ʵ���࣬������Ԫ�ظ��Ƶ�����һ�����飻
		int a1[]=new int [10];
		System.arraycopy(a, 0, a1, 0, 10);
		System.out.println("\n���ƺ�:");
		for(int i1=0;i1<10;i1++)
			System.out.print(a1[i1]+",");
//		������Ԫ�ؽ�������
		Arrays.parallelSort(a1);
		System.out.println("\n�����:");
		for(int i1=0;i1<10;i1++)
			System.out.print(a1[i1]+",");
//		����һ����ֵ���ٲ��Ҹ������������ĸ�λ��
		Scanner sc=new Scanner(System.in);
		System.out.println("\n������Ҫ���ҵ�ֵ:");
		int key=sc.nextInt();
		int position=-1;
		position=Arrays.binarySearch(a1, key);
		if(position>-1) {
			System.out.println("�ҵ�����λ��:"+position+"λ��");
		}else
			System.out.println("δ�ҵ���");
			
	}

}
