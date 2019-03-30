package airplane;

import java.io.*;
import java.util.*;

public class Client {
	private String flightName=null;//航班名
	private int row=0;//座位排数
	private int rowLength=0;//每排座位个数
	private Flight flight=null;//本次航班对象
	private String cmdString=null;//命令字符串
	private BufferedReader br=new BufferedReader(new InputStreamReader(System.in));//获取控制台命令
//--------------------主方法，程序入口--------------------//
	public static void main(String[] args) {
		new Client().commandShell();//命令shell
	}
	private void commandShell() {
		System.out.println("\n\n=====================================");
		System.out.println("Command Shell V2.0 ");
		System.out.println("type'exit'command to exit");
		while (true) {
			readCommand();
			processCommand();
		}
	}	
//--------------------从控制台读入命令--------------------//
	private void readCommand() {
		if(flightName==null) {//若还没有创建航班，提示先创建航班
			System.out.println("***************************");
			System.out.println("航班为空，请先创建航班！");
			System.out.println("使用命令：create flight_name rows rowLength<CR>");
			System.out.println("***************************\n\n");
		}
		System.out.print("\nCOMMAND>");//命令提示符
		try {
			cmdString =br.readLine().trim();//读取命令
		}catch (IOException e) {
			System.out.println("命令错误 Error！  ");
			cmdString=null;
		}
	}
//--------------------分析命令字符串--------------------//
	private void processCommand() {
		String cmds[];//用于包存命令，例如>>cmds[0]="create";cmds[1]="flightName";cmds[2]="rows";cmds[3]="rowLength";
		String cmd;
		if(cmdString!=null) {
			cmds=command(cmdString);//分析命令，分离出各个分量
			if(cmds!=null) {
				cmd=cmds[0].toLowerCase();//将字符串转换为小写
				if(cmd.equals("create")) {//处理create命令
					if(flightName==null)//如果航班还没有创建，则判断命令是否正确并创建航班
						createCommand(cmds);
					else {
						System.out.println("创建错误:不能处理多个航班！");//若航班已经创建则提醒错误
					}
				}else if(cmd.equals("reserve")) {//处理reserve命令
					if(flightName!=null)//当航班创建好以后
						reserveCommand(cmds);//用户预定航班
				}else if(cmd.equals("cancel")) {
					if(flightName!=null)
						cancleCommand(cmds);
				}else if(cmd.equals("list")) {
					if(flightName!=null)
						listCommand(cmds);
				}else if(cmd.equals("exit")) {
					System.out.println("感谢使用，再见！");
					System.exit(0);
				}else {
					System.out.println("错误命令！");
					cmdString=null;
				}
			}
		}		
	}
//--------------------分隔命令字符串--------------------//
    private String[] command(String cmdStr) {
//    	int cc=0;//命令串中分量个数
    	String[] cmd;
//    	StringTokenizer st=new String StringTokenizer(cmdStr);
//    	if((cc=st.countTokens())==0)
//    		return null;
//    	for(int i=0;i<cc;i++)
//    		cmd[i]=st.nextToken();
    	cmd=cmdStr.split(" ");
    	return cmd;
    }
//----------------------创建航班---------------------//  
    private int readInt(String valstr) {//把字符串类型转换为整型
    	int val=0;
    	try {
    		val=Integer.parseInt(valstr);
    	}catch(Exception e) {
    		val=Integer.MIN_VALUE;
    	}
    	return val;
    }
//>>>>
    private void createCommand(String[] cmds) {// 判断命令是否正确
    	if(cmds.length!=4) {
    		System.out.println("命令创建错误！");
    	}
    	else {
    		flightName=cmds[1];
    		row=readInt(cmds[2]);
    		rowLength=readInt(cmds[3]);
    		if(row<=0||rowLength<=0) {
    			System.out.println("创建命令参数错误！");
    			flightName=null;
    			row=0;
    			rowLength=0;
    		}else {
    			try {
    				flight=new Flight(flightName,row,rowLength);//创建航班
    				System.out.println("航班创建成功！");
    			}catch(Exception e) {
    				System.out.println(e);
    				flight=null;
    				flightName=null;
    				row=0;
    				rowLength=0;
    			}
    		}
    	}	
    }
//--------------------用户预订航班座位--------------------//
    private void reserveCommand(String[] cmds) {
    	if(cmds.length<=1) {
    		System.out.println("预定航班错误！reserve error!T_T!");
    		return;
    	}
    	String[]names=new String[cmds.length-1];
    	for(int i=0;i<names.length;i++)
    		names[i]=new String (cmds[i+1]);
    	int[] bn=flight.reserve(names);//处理预订座位
    	if(bn[0]!=-1) {
    		for(int i=0;i<bn.length;i++)
    			System.out.println(names[i]+"的预订座位号为："+bn[i]);
    	}else 
    		System.out.println("当前没有这么多个相邻的位置了QAQ");
    }	
//--------------------用户取消预订航班座位--------------------//
    private void cancleCommand(String[] cmds) { 
    	if(cmds.length!=2) {
    		System.out.println("\n取消航班命令格式错误 QAQ");
    		return;
    	}
    	int bookingNumber=readInt(cmds[1]);
    	if(bookingNumber<=0) {
    		System.out.println("取消航班命令顺序错误 QAQ");
    		return;
    	}
    	boolean state=flight.cancle(bookingNumber);
    	if(state)
    		System.out.println("您的座位已取消！");
    	else
    		System.out.println("此座位未被预定！");
	
    }
//--------------------显示航班座位预订情况--------------------//
    private void listCommand(String[] cmds) {
	if(cmds.length!=1) {
		System.out.println("\n列表格式错误！");
		return;
	}
	Passenger[]Passengerlist=flight.getPassengerList();
	int flag=0;
	System.out.println("姓名                                    预订号                              行数                                位置 ");
	System.out.println("-----------------------------------------------------");
	if(Passengerlist==null||Passengerlist.length<=0)
		System.out.println("当前没有人预订座位！");
	else {
		flag=0;
		for(int b=0;b<Passengerlist.length;b++) {
			if(Passengerlist[b]!=null) {
				flag=1;
				System.out.println(formatStr(Passengerlist[b].getName())+
						formatStr(" "+Passengerlist[b].getBookingNumber())+
						formatStr(" "+Passengerlist[b].getRow())+
						formatStr(" "+Passengerlist[b].getSeatPosition()));
			}
		}
		if(flag==0)
			System.out.println("当前没有人预订座位！");
	}
}
	private String formatStr(String s) {
		for(int i=0;i<16-s.trim().length();i++)
			s+=" ";
		return s;
	}

	




}
