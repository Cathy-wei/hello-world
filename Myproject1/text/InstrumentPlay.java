package text;

public class InstrumentPlay {
	//实例内部类
	public class Piano implements Instrument{
		public void play() {
			System.out.println("实例内部类调用了！");
		}	
	}	
	void playInstrument(Instrument ins) {
		ins.play();
		System.out.println("playInstrument方法成功调用！");
		}
	public class Inner{
		void print() {
		System.out.println("调用实例内部类了！");
		}
	}
	//局部内部类
	int x=1;
    void Part(final int y) {
			final int z=3;
			class In{
				void println(){
					System.out.println("x="+x+" y="+y+" z="+z);
					System.out.println("局部内部类成功调用！");
				}		
			}
		In in1=new In();
		in1.println();
	}
  //静态内部类
    public static class StaticInner{
    	void Static() {
		System.out.println("静态内部类调用成功！");
    	}
    }
   
}
