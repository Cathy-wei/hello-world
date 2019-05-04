package lambda;

import java.util.Objects;

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
		//Test t=new Test();
		Apple a1=new Apple("green", 13.0);
		Apple a2=new Apple("red", 10.0);
		Apple[] apps=new Apple[2];
		apps[0]=a1;
		apps[1]=a2;
		//��lambda����ʽ��ɲ���Consumer<Apple> c�Ĵ���
		Test.ConsumerApple(apps, (Apple a)->System.out.println("��ɫ��"+a.color+" ������"+a.weight));
        //�������ڲ������ʽ
		Test.ConsumerApple(apps,new Consumer<Apple>() {

			@Override
			public void accept(Apple t) {
				// TODO �Զ����ɵķ������
				System.out.println("��ɫ��"+t.color+" ������"+t.weight);
			}
			
		});
	}

}

