package text;

public class InstrumentPlay {
	//ʵ���ڲ���
	public class Piano implements Instrument{
		public void play() {
			System.out.println("ʵ���ڲ�������ˣ�");
		}	
	}	
	void playInstrument(Instrument ins) {
		ins.play();
		System.out.println("playInstrument�����ɹ����ã�");
		}
	public class Inner{
		void print() {
		System.out.println("����ʵ���ڲ����ˣ�");
		}
	}
	//�ֲ��ڲ���
	int x=1;
    void Part(final int y) {
			final int z=3;
			class In{
				void println(){
					System.out.println("x="+x+" y="+y+" z="+z);
					System.out.println("�ֲ��ڲ���ɹ����ã�");
				}		
			}
		In in1=new In();
		in1.println();
	}
  //��̬�ڲ���
    public static class StaticInner{
    	void Static() {
		System.out.println("��̬�ڲ�����óɹ���");
    	}
    }
   
}
