package airplane;

import java.io.BufferedReader;
import java.io.IOException;

public class Client {
	private String flightName=null;//������
	private int row=0;//��λ����
	private int rowLength=0;//ÿ����λ����
	private Flight flight=null;//���κ������
	private String cmdString=null;//�����ַ���
	private BufferedReader br=new BufferedReader(new InputStremReader(System.in));//��ȡ����̨����
//--------------------���������������--------------------//
	public static void main(String[] args) {
		new Flight().commandShell();//����shell
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
//--------------------�ӿ���̨��������--------------------//
	private void readCommand() {
		if(flightName==null) {//����û�д������࣬��ʾ�ȴ�������
			System.out.println("***************************");
			System.out.println("����Ϊ�գ����ȴ������࣡");
			System.out.println("ʹ�����create flight_name rows rowLength<CR>");
			System.out.println("***************************\n\n");
		}
		System.out.print("\nCOMMAND>");//������ʾ��
		try {
			cmdString =br.readLine().trim();//��ȡ����
		}catch (IOException e) {
			System.out.println("������� Error��  ");
			cmdString=null;
		}
	}
//--------------------���������ַ���--------------------//
	private void processCommand() {
		String cmds[];//���ڰ����������>>cmds[0]="create";cmds[1]="flightName";cmds[2]="rows";cmds[3]="rowLength";
		String cmd;
		if(cmdString!=null) {
			cmd=command(cmdString);//��������������������
			if(cmds!=null) {
				cmd=cmds[0].toLowerCase();//���ַ���ת��ΪСд
				if(cmd.equals("create")) {//����create����
					if(flightName==null)//������໹û�д��������ж������Ƿ���ȷ����������
						createCommand(cmds);
					else {
						System.out.println("��������:���ܴ��������࣡");//�������Ѿ����������Ѵ���
					}
				}else if(cmd.equals("reserve")) {//����reserve����
					if(flightName!=null)//�����ഴ�����Ժ�
						reserveCommand(cmds);
				}else if(cmd.equals("cancle")) {
					if(flightName!=null)
						cancleCommand(cmds);
				}else if(cmd.equals("list")) {
					if(flightName!=null)
						listCommand(cmds)
				}else if(cmd.equals("exit")) {
					System.out.println("��лԤ�����ټ���");
					System.exit(0);
				}else {
					System.out.println("�������");
					cmdString=null;
				}
			}
		}		
	}
    private void listCommand(String[] cmds) {
	// TODO �Զ����ɵķ������
	
}
	private void cancleCommand(String[] cmds) {
	// TODO �Զ����ɵķ������
	
}
	private void reserveCommand(String[] cmds) {
	// TODO �Զ����ɵķ������ss
	
}
	private void createCommand(String[] cmds) {
	// TODO �Զ����ɵķ������
	
    }
//--------------------�ָ������ַ���--------------------//
    private String command(String cmdStr) {
    	
    }


}
