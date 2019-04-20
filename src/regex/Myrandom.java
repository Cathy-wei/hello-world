package regex;

import java.util.*;

public class Myrandom {

	public static void main(String[] args) {
//		使用随机数生成十个整数（0--99）保存在一个数组中，
		Random r=new Random();
		int a[]=new int[10];
		for(int i=0;i<10;i++) {
			a[i]=r.nextInt(100);
			System.out.print(a[i]+",");
		}
//		然后使用数组实用类，将数组元素复制到另外一个数组；
		int a1[]=new int [10];
		System.arraycopy(a, 0, a1, 0, 10);
		System.out.println("\n复制后:");
		for(int i1=0;i1<10;i1++)
			System.out.print(a1[i1]+",");
//		将数组元素进行排序；
		Arrays.parallelSort(a1);
		System.out.println("\n排序后:");
		for(int i1=0;i1<10;i1++)
			System.out.print(a1[i1]+",");
//		输入一个数值，再查找该数在数组中哪个位置
		Scanner sc=new Scanner(System.in);
		System.out.println("\n请输入要查找的值:");
		int key=sc.nextInt();
		int position=-1;
		position=Arrays.binarySearch(a1, key);
		if(position>-1) {
			System.out.println("找到该数位于:"+position+"位置");
		}else
			System.out.println("未找到！");
			
	}

}
