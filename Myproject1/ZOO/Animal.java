package ZOO;
//����
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
		System.out.println("������������");
	}
	public void eat(Food food) {
		setName("��ͷ");
		System.out.println("dog���ڳ���������� "+getName());
	}
}
class Tiger extends Animal{
	public Tiger(String name) {
		super(name);
	}
	public void shout() {
		System.out.println("(�ϻ���)��");
	}
	public void eat(Food food) {
		setName("����");
		System.out.println("tiger���ڳ���������� "+getName());
	}
}
class Bone implements Food {
	public String getName() {
		return "��ͷ";
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
		System.out.println("(����)������������!");
	}
	public void eat(Food food) {
		
	}	
}
