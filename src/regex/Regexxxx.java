package regex;

import java.util.regex.*;

public class Regexxxx {

	public static void main(String[] args) {
		// （1）检查一个电话号码是否符合(0000)0000-0000
		Pattern p1=Pattern.compile("\\(\\d{4}\\)(\\d{4})-(\\d{4})");
		String str1="(1111)1232-2333";
		String str2="(11232)-2333";
		Matcher m1=p1.matcher(str1);
		Matcher m2=p1.matcher(str2);
			System.out.println(m1.matches());
			System.out.println(m2.matches());
		//（2）将一个字符串中所有的ip地址打印出来
		String str3="Ip1:198.122.3.99;Ip2:194.132.2.29";
		Pattern p2=Pattern.compile("(\\d{1,3}\\.){3}(\\d{1,3})");
		Matcher m3=p2.matcher(str3);
		while(m3.find())
		System.out.println(m3.group());
		//（3）将字符串中连续出现的字符压缩成一个。比如aaabbbccccd，压缩后变成abcd。
		str1=str1.replaceAll("(.)(\\1)*", "$1");//1个或多个与任意字符相匹配的匹配组被第一个匹配组相匹配的子串替换
		System.out.println(str1);
		//（4）将连续出现的abc用一个abc代替。---选做
		String str="abcabcabcabcaaaa";
		System.out.println(str.replaceAll("(abc)(\\1)*", "$1"));
		//（5）从控制台输入邮箱地址，验证是否为邮箱地址。
		//从JOptionPane中输入邮箱地址，验证是否是合法的邮箱。----选做
		//（6）输入一个字符串，判断该字符串是否以abc结尾。
		String str4="sadadadaaaaaabc";
		Pattern p3=Pattern.compile(".*(abc)");
		Matcher m4=p3.matcher(str4);
		System.out.println(m4.matches());
		//（7）截取http://地址。在一个网页的源文件中提取静态的http地址。------选做
		//（8）将一个字符串中的所有整数提取出来，保存在一维数组中。
		//比如”ae256dd—w348e6”，提取出256,348,6三个整数
		int[] a=new int[10];
		String str5="sada211da432daa5a3aa55abc";
		Pattern p4=Pattern.compile("\\d{1,4}");
		Matcher m5=p4.matcher(str5);
		int i=0;
		while(m5.find()) {
			int j;
			j=Integer.parseInt(m5.group());
			a[i]=j;
			i++;
		}
		for(int ai:a)
			System.out.print(ai+",");

	}

}
