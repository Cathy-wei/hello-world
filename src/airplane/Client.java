package airplane;

import java.io.BufferedReader;

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
		// TODO �Զ����ɵķ������
		
	}
//--------------------���������ַ���--------------------//
	private void processCommand() {
		// TODO �Զ����ɵķ������
		
	}


}
