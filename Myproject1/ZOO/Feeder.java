package ZOO;
//����Ա
public class Feeder {
	private String name;
	public Feeder(String name) {
		this.name=name;
	}
	public void speak() {
		System.out.println("��ӭ��������԰��");
		System.out.println("��������Ա "+getName());
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
