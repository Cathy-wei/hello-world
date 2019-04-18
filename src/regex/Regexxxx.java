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
	}

}
