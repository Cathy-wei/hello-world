package regex;

import java.util.regex.*;

public class Regexxxx {

	public static void main(String[] args) {
		// ��1�����һ���绰�����Ƿ����(0000)0000-0000
		Pattern p1=Pattern.compile("\\(\\d{4}\\)(\\d{4})-(\\d{4})");
		String str1="(1111)1232-2333";
		String str2="(11232)-2333";
		Matcher m1=p1.matcher(str1);
		Matcher m2=p1.matcher(str2);
			System.out.println(m1.matches());
			System.out.println(m2.matches());
		//��2����һ���ַ��������е�ip��ַ��ӡ����
		String str3="Ip1:198.122.3.99;Ip2:194.132.2.29";
		Pattern p2=Pattern.compile("(\\d{1,3}\\.){3}(\\d{1,3})");
		Matcher m3=p2.matcher(str3);
		while(m3.find())
		System.out.println(m3.group());
		//��3�����ַ������������ֵ��ַ�ѹ����һ��������aaabbbccccd��ѹ������abcd��
		str1=str1.replaceAll("(.)(\\1)*", "$1");//1�������������ַ���ƥ���ƥ���鱻��һ��ƥ������ƥ����Ӵ��滻
		System.out.println(str1);
		//��4�����������ֵ�abc��һ��abc���档---ѡ��
		String str="abcabcabcabcaaaa";
		System.out.println(str.replaceAll("(abc)(\\1)*", "$1"));
		//��5���ӿ���̨���������ַ����֤�Ƿ�Ϊ�����ַ��
		//��JOptionPane�����������ַ����֤�Ƿ��ǺϷ������䡣----ѡ��
		//��6������һ���ַ������жϸ��ַ����Ƿ���abc��β��
		String str4="sadadadaaaaaabc";
		Pattern p3=Pattern.compile(".*(abc)");
		Matcher m4=p3.matcher(str4);
		System.out.println(m4.matches());
		//��7����ȡhttp://��ַ����һ����ҳ��Դ�ļ�����ȡ��̬��http��ַ��------ѡ��
		//��8����һ���ַ����е�����������ȡ������������һά�����С�
		//���硱ae256dd��w348e6������ȡ��256,348,6��������
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
