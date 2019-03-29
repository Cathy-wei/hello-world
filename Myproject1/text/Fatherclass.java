package text;

public class Fatherclass {
	class Father{
		int x=3;
		void a() {System.out.println("x="+x);}
		void Fatherclass() {System.out.println("我是爸爸");}
		}
    class Sun extends Father{
    	void Fatherclass(){System.out.println("我是爸爸的儿子");}
    	void a() {System.out.println("xx="+x);}
    }
	public static void main(String[] args) {
		Fatherclass f=new Fatherclass();
		Fatherclass.Father ff=f.new Father();
		ff.a();
		ff.Fatherclass();
	}

}
