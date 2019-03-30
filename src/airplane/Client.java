package airplane;

import java.io.*;
import java.util.*;

public class Client {
	private String flightName=null;//������
	private int row=0;//��λ����
	private int rowLength=0;//ÿ����λ����
	private Flight flight=null;//���κ������
	private String cmdString=null;//�����ַ���
	private BufferedReader br=new BufferedReader(new InputStreamReader(System.in));//��ȡ����̨����
//--------------------���������������--------------------//
	public static void main(String[] args) {
		new Client().commandShell();//����shell
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
			cmds=command(cmdString);//��������������������
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
						reserveCommand(cmds);//�û�Ԥ������
				}else if(cmd.equals("cancel")) {
					if(flightName!=null)
						cancleCommand(cmds);
				}else if(cmd.equals("list")) {
					if(flightName!=null)
						listCommand(cmds);
				}else if(cmd.equals("exit")) {
					System.out.println("��лʹ�ã��ټ���");
					System.exit(0);
				}else {
					System.out.println("�������");
					cmdString=null;
				}
			}
		}		
	}
//--------------------�ָ������ַ���--------------------//
    private String[] command(String cmdStr) {
//    	int cc=0;//����з�������
    	String[] cmd;
//    	StringTokenizer st=new String StringTokenizer(cmdStr);
//    	if((cc=st.countTokens())==0)
//    		return null;
//    	for(int i=0;i<cc;i++)
//    		cmd[i]=st.nextToken();
    	cmd=cmdStr.split(" ");
    	return cmd;
    }
//----------------------��������---------------------//  
    private int readInt(String valstr) {//���ַ�������ת��Ϊ����
    	int val=0;
    	try {
    		val=Integer.parseInt(valstr);
    	}catch(Exception e) {
    		val=Integer.MIN_VALUE;
    	}
    	return val;
    }
//>>>>
    private void createCommand(String[] cmds) {// �ж������Ƿ���ȷ
    	if(cmds.length!=4) {
    		System.out.println("���������");
    	}
    	else {
    		flightName=cmds[1];
    		row=readInt(cmds[2]);
    		rowLength=readInt(cmds[3]);
    		if(row<=0||rowLength<=0) {
    			System.out.println("���������������");
    			flightName=null;
    			row=0;
    			rowLength=0;
    		}else {
    			try {
    				flight=new Flight(flightName,row,rowLength);//��������
    				System.out.println("���ഴ���ɹ���");
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
//--------------------�û�Ԥ��������λ--------------------//
    private void reserveCommand(String[] cmds) {
    	if(cmds.length<=1) {
    		System.out.println("Ԥ���������reserve error!T_T!");
    		return;
    	}
    	String[]names=new String[cmds.length-1];
    	for(int i=0;i<names.length;i++)
    		names[i]=new String (cmds[i+1]);
    	int[] bn=flight.reserve(names);//����Ԥ����λ
    	if(bn[0]!=-1) {
    		for(int i=0;i<bn.length;i++)
    			System.out.println(names[i]+"��Ԥ����λ��Ϊ��"+bn[i]);
    	}else 
    		System.out.println("��ǰû����ô������ڵ�λ����QAQ");
    }	
//--------------------�û�ȡ��Ԥ��������λ--------------------//
    private void cancleCommand(String[] cmds) { 
    	if(cmds.length!=2) {
    		System.out.println("\nȡ�����������ʽ���� QAQ");
    		return;
    	}
    	int bookingNumber=readInt(cmds[1]);
    	if(bookingNumber<=0) {
    		System.out.println("ȡ����������˳����� QAQ");
    		return;
    	}
    	boolean state=flight.cancle(bookingNumber);
    	if(state)
    		System.out.println("������λ��ȡ����");
    	else
    		System.out.println("����λδ��Ԥ����");
	
    }
//--------------------��ʾ������λԤ�����--------------------//
    private void listCommand(String[] cmds) {
	if(cmds.length!=1) {
		System.out.println("\n�б��ʽ����");
		return;
	}
	Passenger[]Passengerlist=flight.getPassengerList();
	int flag=0;
	System.out.println("����                                    Ԥ����                              ����                                λ�� ");
	System.out.println("-----------------------------------------------------");
	if(Passengerlist==null||Passengerlist.length<=0)
		System.out.println("��ǰû����Ԥ����λ��");
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
			System.out.println("��ǰû����Ԥ����λ��");
	}
}
	private String formatStr(String s) {
		for(int i=0;i<16-s.trim().length();i++)
			s+=" ";
		return s;
	}

	




}
