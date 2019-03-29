package text;

import java.net.*;
public class GetMacAddress {

 
private static void getLocalMac(InetAddress ia)throws SocketException {
	 byte [] mac =NetworkInterface.getByInetAddress(ia).getHardwareAddress();
	 System.out.println("mac数组长度："+mac.length);
	 StringBuffer sb=new StringBuffer("");
	 for(int i=0;i<mac.length;i++) {
		 if(i!=0) 
			 sb.append("-");
	
//字节转化
    int temp =mac[i]&0xff;
    String str=Integer.toHexString(temp);
    System.out.println("每8位："+str);
    if(str.length()==1) {
	 sb.append("0"+str);
    }else {
	    sb.append(str);
    }
    }
	 System.out.println("本机MAC地址："+sb.toString().toUpperCase());

}
public static void main(String[] args) throws UnknownHostException, SocketException {

	InetAddress ia = InetAddress.getLocalHost();
	//输出计算机名和IP
	System.out.println(ia);

	getLocalMac(ia);

}
}