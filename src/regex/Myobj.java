package regex;

public class Myobj {

	public static void main(String[] args) {
		// 3. дһ�����ӣ�ʵ�ְ�װ���������������֮��ת����
		char cc='c';
		Character cha=new Character(cc);
		System.out.println("����ת��װ"+cha);
		Integer in=new Integer(3);
		int n=in+3;//n=in.intValue();
		System.out.println("��װת����"+n);
		//ʵ�ְ�װ�����ַ����໥ת����ʵ�ֻ��������������ַ���֮���໥ת��
		String s=String.valueOf(cc)+"+string";
		System.out.println("��װת����"+s);
		String str="12";
		int ii=Integer.valueOf(str)+10;
		System.out.println("����ת��װ"+ii);
	}

}
