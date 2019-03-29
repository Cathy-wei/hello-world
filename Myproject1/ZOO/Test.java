package ZOO;
//测试
public class Test {
	public static void main(String[] args) {
		Feeder feeder=new Feeder("花花");
		feeder.speak();
		Dog dog=new Dog("小布丁");
		Food food=new Bone();
		feeder.feed(dog, food);
		Tiger tiger=new Tiger("小猫咪");
		Food f=new Chicken("小鸡仔");
		feeder.feed(tiger, f);	
	}

}
