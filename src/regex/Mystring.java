package regex;

public class Mystring {
	// дһ�����ӣ���ϰString������StringBuffer������ת��
	public static void main(String[] args) {
		String str = "My String!";
		StringBuffer sb = new StringBuffer(str);
	    System.out.println("string����תΪstringbuffer���ͣ�\n"+sb);
	    StringBuffer sbuff = new StringBuffer("My stringbuffer!");
	    System.out.println("stringbuffer����תΪstring���ͣ�\n"+sbuff.toString());
	    //����StringBuffer�����ӡ����롢ɾ������ת������
	  
	    System.out.println("stringbuffer�Ĳ���:"+sb.insert(2," First"));
	    System.out.println("stringbuffer��ɾ��:"+sb.delete(0,3));
	    System.out.println("stringbuffer�����:"+sb.append("��ӣ���"));
	    System.out.println("stringbuffer�ķ�ת:"+sb.reverse());
	}

}
