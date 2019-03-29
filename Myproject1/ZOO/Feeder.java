package ZOO;
//饲养员
public class Feeder {
	private String name;
	public Feeder(String name) {
		this.name=name;
	}
	public void speak() {
		System.out.println("欢迎来到动物园！");
		System.out.println("我是饲养员 "+getName());
	}
	public void feed(Animal animal,Food food) {
		animal.eat(food);
		if(food instanceof Animal) {
			((Animal) food).shout();			
		}
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}

}
