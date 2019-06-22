package Test;

import java.util.*;

//6.HashSet是如何检测是否有重复元素的，并写程序验证

class hash{
	int num;
	String str;
	hash(int num,String str){
		this.num=num;
		this.str=str;
	}
	public String toString() {
		return "num:"+num+" str:"+str;
	}
	public boolean equals(Object o) {
		if(!(o instanceof hash))
			return false;
		hash h=(hash)o;
		return num==h.num && str.equals(str);
	}
	public int hashCode() {
		return str.hashCode()+num;
	}
	
}

public class Hashdemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Set<hash> hs=new HashSet<hash>();
		hs.add(new hash(1,"one"));
		System.out.println("first:"+hs);
		hs.add(new hash(2,"two"));
		System.out.println("second:"+hs);
		hs.add(new hash(2,"two"));
		System.out.println("2号添加重复:"+hs);
	}

}
