package airplane;

import java.io.BufferedReader;

public class Client {
	private String flightName=null;//航班名
	private int row=0;//座位排数
	private int rowLength=0;//每排座位个数
	private Flight flight=null;//本次航班对象
	private String cmdString=null;//命令字符串
	private BufferedReader br=new BufferedReader(new InputStremReader(System.in));//获取控制台命令
//--------------------主方法，程序入口--------------------//
	public static void main(String[] args) {
		new Flight().commandShell();//命令shell
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
		// TODO 自动生成的方法存根
		
	}
//--------------------分析命令字符串--------------------//
	private void processCommand() {
		// TODO 自动生成的方法存根
		
	}


}
