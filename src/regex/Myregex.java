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
		System.out.println("s�ĸ����� "+c);//ͳ�Ƹ��ַ�������ĸs���ֵĴ���
		System.out.println(str.substring(9,14));//ȡ�����ַ���"test"  //substring
		char[] ch=str.toCharArray();
		System.out.println(ch);//�����ַ������Ƶ�һ���ַ�����Char[] str��.// toCharArray
//		char cc = ' ';
//		int c=str.length()
//		for(c=;c>=0;c--) {
//			 cc=str.charAt(c);
//			System.out.println(cc);}
		//�����ַ�ʽʵ�ָ��ַ����ĵ��������(��StringBuffer��forѭ����ʽ�ֱ�ʵ��)
		
	}

}
