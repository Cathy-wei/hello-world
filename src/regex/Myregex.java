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
		System.out.println("s�ĸ����� "+c);
		//ͳ�Ƹ��ַ�������ĸs���ֵĴ���
		System.out.println(str.substring(10,14));
		//ȡ�����ַ���"test"  //substring
		char[] ch=str.toCharArray();
		System.out.println(ch);
		//�����ַ������Ƶ�һ���ַ�����Char[] str��.// toCharArray
		for(int i=str.length()-1;i>=0;i--) {
			System.out.print(ch[i]);}
		StringBuffer sb=new StringBuffer(str);
		System.out.println("\n"+sb.reverse());
		//�����ַ�ʽʵ�ָ��ַ����ĵ��������(��StringBuffer��forѭ����ʽ�ֱ�ʵ��)
		Pattern pp=Pattern.compile("([a-z])([a-z]*)",Pattern.CASE_INSENSITIVE);
		Matcher mm=pp.matcher(str);
		StringBuffer sbb=new StringBuffer();
		while(mm.find()) {
		mm.appendReplacement(sbb, mm.group(1).toUpperCase()/*��һ���������*/
				+mm.group(2).toLowerCase()/*�ڶ����������*/);
		}
		System.out.println(mm.appendTail(sbb).toString());
		//���ַ�����ÿ�����ʵĵ�һ����ĸ��ɴ�д��
		String string[]=new String[6];
		int i=0;
		Pattern pat=Pattern.compile("(\\w{1,10})");
		Matcher mat=pat.matcher(str);	
		while(mat.find()) {
			string[i]=mat.group();
			i++;
		}
		for(String t:string)
			System.out.print(t+"\n");		
		//�����ַ���ת����һ���ַ������飬Ҫ��ÿ������Ԫ�ض���һ���������Ӣ�ĵ���,�����������̨
	}

}
