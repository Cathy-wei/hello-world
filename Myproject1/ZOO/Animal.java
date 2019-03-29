package ZOO;
//动物
public abstract class Animal {
	private String name;
	public Animal(String name) {
		this.name=name;
	}
	public abstract void shout();
	public abstract void eat(Food food);
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}

}
class Dog extends Animal {
	public Dog(String name) {
		super(name);
	}
	public void shout() {
		System.out.println("汪汪汪汪汪！");
	}
	public void eat(Food food) {
		setName("骨头");
		System.out.println("dog正在吃着香喷喷的 "+getName());
	}
}
class Tiger extends Animal{
	public Tiger(String name) {
		super(name);
	}
	public void shout() {
		System.out.println("(老虎叫)吼！");
	}
	public void eat(Food food) {
		setName("鸡仔");
		System.out.println("tiger正在吃着香喷喷的 "+getName());
	}
}
class Bone implements Food {
	public String getName() {
		return "骨头";
	}
}
class Chicken extends Animal implements Food{
	private String name;
	public Chicken(String name) {
		super(name);		
	}
	public String getName() {
		return name;
	}
	public void shout() {
		System.out.println("(鸡叫)咕咕咕咕！！!");
	}
	public void eat(Food food) {
		
	}	
}
