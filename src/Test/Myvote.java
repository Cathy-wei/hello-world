package Test;

import java.util.*;

//3.写一个统计投票程序。设有3个候选人，有10人参加选举，每个选举人输入两个候选人的编号，要求输出各个候选人的得票数。
//输入描述：输入10个选举人提交的候选人编号
//输出描述：输出候选人编号及对应的得票。*
//要求，用map来表示投票结果。

public class Myvote {
//	public void  ll(){
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
	//	int num[]=new int[3]; num[0]=1;num[1]=2;num[2]=3;
//		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		String num[]=new String[3]; 
	    num[0]="01";num[1]="02";num[2]="03";//候选者编号
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		map.put(num[0], 0);map.put(num[1], 0);map.put(num[2], 0);
		System.out.println(map);
		for(int k=1;k<=4;k++) {
	    System.out.println("第"+k+"位选举人请输入两个候选人：");
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
		map.forEach((key,value)->System.out.println("候选人："+key+"号"+"   得票："+value));
		}
		System.out.println("投票结束！");
	}

	
}
