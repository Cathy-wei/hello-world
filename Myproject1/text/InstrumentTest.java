package text;
public class InstrumentTest {
	public static void main(String[] args) {
		InstrumentPlay ip=new InstrumentPlay();
		//ʵ���ڲ���   ��ͨ��
		InstrumentPlay.Inner in= ip.new Inner();
		in.print();	
		//ʵ���ڲ���  �ӿ�
		Instrument ins1=ip.new Piano();
		ip.playInstrument(ins1);
		//�ֲ��ڲ���
		ip.Part(2);
		//��̬�ڲ���
		InstrumentPlay.StaticInner si=new InstrumentPlay.StaticInner();
		si.Static();
		//�����ڲ���  ����̳�
		InstrumentPlay.Inner  name1=ip.new Inner(){
//			{System.out.println("�����ڲ���ʵ����ʼ�������");}
			public void print(){
			System.out.println("�����ڲ���̳и���ɹ���");
			}
		} ;
		name1.print();
		//�����ڲ���  �ӿ�ʵ��
		Instrument  name2=new Instrument(){
//			{System.out.println("�����ڲ���ʵ����ʼ�������");}
			public void play(){
			System.out.println("�����ڲ��� �ӿ�ʵ�ֳɹ���");
			}
		} ;
		name2.play();
	}

}
