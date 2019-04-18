package regex;

public class Myobj {

	public static void main(String[] args) {
		// 3. 写一个例子，实现包装类与基本数据类型之间转换；
		char cc='c';
		Character cha=new Character(cc);
		System.out.println("基本转包装"+cha);
		Integer in=new Integer(3);
		int n=in+3;//n=in.intValue();
		System.out.println("包装转基本"+n);
		//实现包装类与字符串相互转换；实现基本数据类型与字符串之间相互转换
		String s=String.valueOf(cc)+"+string";
		System.out.println("包装转基本"+s);
		String str="12";
		int ii=Integer.valueOf(str)+10;
		System.out.println("基本转包装"+ii);
	}

}
