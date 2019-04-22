package fault;

class MyException extends Exception{

	public MyException(String str) {
		// TODO 自动生成的构造函数存根
		super(str);
	}
	
	
}
class Tool{
	public static int parseInt(String str) throws MyException {
		int n = 0;
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(ch>='0' && ch<='9') n=n*10+ch-'0';
			else throw new MyException(str);
		}
		return n;
	}
}
public class MyTest{
	
	public static void main(String[] args) {
		try {
			System.out.println(Tool.parseInt("123q"));
		}catch(MyException e) {
			e.printStackTrace();
		}
		
			System.out.print(" ");
		
		
	}

}
