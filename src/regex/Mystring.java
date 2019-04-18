package regex;

public class Mystring {
	// 写一个例子，练习String对象与StringBuffer对象互相转换
	public static void main(String[] args) {
		String str = "My String!";
		StringBuffer sb = new StringBuffer(str);
	    System.out.println("string类型转为stringbuffer类型：\n"+sb);
	    StringBuffer sbuff = new StringBuffer("My stringbuffer!");
	    System.out.println("stringbuffer类型转为string类型：\n"+sbuff.toString());
	    //测试StringBuffer类的添加、插入、删除、反转操作。
	  
	    System.out.println("stringbuffer的插入:"+sb.insert(2," First"));
	    System.out.println("stringbuffer的删除:"+sb.delete(0,3));
	    System.out.println("stringbuffer的添加:"+sb.append("添加！！"));
	    System.out.println("stringbuffer的反转:"+sb.reverse());
	}

}
