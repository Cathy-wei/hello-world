package regex;
import java.util.Scanner;
import java.util.regex.*;
public class Myregex {

	public static void main(String[] args) {
		String str="this is a test of java";
		Pattern p=Pattern.compile("s{1}");
		Matcher m=p.matcher(str);
		int c=0;
		while(m.find())
			c++;
		System.out.println("s的个数有 "+c);//统计该字符串中字母s出现的次数
		System.out.println(str.substring(9,14));//取出子字符串"test"  //substring
		char[] ch=str.toCharArray();
		System.out.println(ch);//将本字符串复制到一个字符数组Char[] str中.// toCharArray
//		char cc = ' ';
//		int c=str.length()
//		for(c=;c>=0;c--) {
//			 cc=str.charAt(c);
//			System.out.println(cc);}
		//用两种方式实现该字符串的倒序输出。(用StringBuffer和for循环方式分别实现)
		
	}

}
