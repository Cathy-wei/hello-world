package text;

import java.net.*;
public class GetMacAddress {

 
private static void getLocalMac(InetAddress ia)throws SocketException {
	 byte [] mac =NetworkInterface.getByInetAddress(ia).getHardwareAddress();
	 System.out.println("mac���鳤�ȣ�"+mac.length);
	 StringBuffer sb=new StringBuffer("");
	 for(int i=0;i<mac.length;i++) {
		 if(i!=0) 
			 sb.append("-");
	
//�ֽ�ת��
    int temp =mac[i]&0xff;
    String str=Integer.toHexString(temp);
    System.out.println("ÿ8λ��"+str);
    if(str.length()==1) {
	 sb.append("0"+str);
    }else {
	    sb.append(str);
    }
    }
	 System.out.println("����MAC��ַ��"+sb.toString().toUpperCase());

}
public static void main(String[] args) throws UnknownHostException, SocketException {

	InetAddress ia = InetAddress.getLocalHost();
	//������������IP
	System.out.println(ia);

	getLocalMac(ia);

}
}