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
	}

}
