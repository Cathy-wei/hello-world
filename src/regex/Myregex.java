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
		System.out.println(str.substring(10,14));//取出子字符串"test"  //substring
		char[] ch=str.toCharArray();
		System.out.println(ch);//将本字符串复制到一个字符数组Char[] str中.// toCharArray
		for(int i=str.length()-1;i>=0;i--) {
			System.out.print(ch[i]);}
		StringBuffer sb=new StringBuffer(str);
		System.out.println("\n"+sb.reverse());
		//用两种方式实现该字符串的倒序输出。(用StringBuffer和for循环方式分别实现)
		Pattern pp=Pattern.compile("[a-zA-Z]",Pattern.CASE_INSENSITIVE);
		Matcher mm=pp.matcher(str);
		StringBuffer sbb=new StringBuffer();
		while(mm.find()) {
		mm.appendReplacement(sbb, mm.group(1).toUpperCase()+mm.group(2).toLowerCase());
		}
		System.out.println(mm.appendTail(sbb).toString());
		//将字符串中每个单词的第一个字母变成大写，
		
	}

}
