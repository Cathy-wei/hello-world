package lambda;
class Apple{
	String color="red";
	double weight=10.0;
	public Apple(String c,double w) {
		this.color=c;
		this.weight=w;
	}
}
class Test {
	public static void ConsumerApple(Apple[] apps,Consumer<Apple> c){
		 for(Apple app:apps){
			 c.accept(app);
		 }
	 }
}
public class MyApple {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}

