package airplane;

import java.io.BufferedReader;
import java.io.IOException;

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
			cmd=command(cmdString);//分析命令，分离出各个分量
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
						reserveCommand(cmds);
				}else if(cmd.equals("cancle")) {
					if(flightName!=null)
						cancleCommand(cmds);
				}else if(cmd.equals("list")) {
					if(flightName!=null)
						listCommand(cmds)
				}else if(cmd.equals("exit")) {
					System.out.println("感谢预订，再见！");
					System.exit(0);
				}else {
					System.out.println("错误命令！");
					cmdString=null;
				}
			}
		}		
	}
    private void listCommand(String[] cmds) {
	// TODO 自动生成的方法存根
	
}
	private void cancleCommand(String[] cmds) {
	// TODO 自动生成的方法存根
	
}
	private void reserveCommand(String[] cmds) {
	// TODO 自动生成的方法存根ss
	
}
	private void createCommand(String[] cmds) {
	// TODO 自动生成的方法存根
	
    }
//--------------------分隔命令字符串--------------------//
    private String command(String cmdStr) {
    	
    }


}
