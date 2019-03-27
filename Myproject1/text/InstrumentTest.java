package text;
public class InstrumentTest {
	public static void main(String[] args) {
		InstrumentPlay ip=new InstrumentPlay();
		//实例内部类   普通类
		InstrumentPlay.Inner in= ip.new Inner();
		in.print();	
		//实例内部类  接口
		Instrument ins1=ip.new Piano();
		ip.playInstrument(ins1);
		//局部内部类
		ip.Part(2);
		//静态内部类
		InstrumentPlay.StaticInner si=new InstrumentPlay.StaticInner();
		si.Static();
		//匿名内部类  父类继承
		InstrumentPlay.Inner  name1=ip.new Inner(){
//			{System.out.println("匿名内部类实例初始化代码块");}
			public void print(){
			System.out.println("匿名内部类继承父类成功！");
			}
		} ;
		name1.print();
		//匿名内部类  接口实现
		Instrument  name2=new Instrument(){
//			{System.out.println("匿名内部类实例初始化代码块");}
			public void play(){
			System.out.println("匿名内部类 接口实现成功！");
			}
		} ;
		name2.play();
	}

}
