package Test;

import java.util.*;

public class ListDemo {
	//实现队列
	public static void printQ(Queue queue) {
		while(queue.peek()!=null) 
			System.out.print(queue.remove()+",");

		System.out.println();
	}
	//堆栈
	LinkedList linkedlist = new LinkedList();
	public void push(Object o) {
		linkedlist.addFirst(o);
	}
	public Object pop() {
		return linkedlist.removeFirst();
	}
	public Object peek() {
		return linkedlist.getFirst();
	}
	public boolean empty() {
		return linkedlist.isEmpty();
	}

	public static void main(String[] args) {
		Queue<Integer>queue = new LinkedList<Integer>();
		Random rand = new Random(9);
		for(int i=0;i<10;i++)
			queue.offer(rand.nextInt(i+11));
		printQ(queue);
		Queue<Character> qc = new LinkedList<Character>();
		for(char c:"apple".toCharArray())
			qc.offer(c);
		printQ(qc);
		//堆栈
		ListDemo l= new ListDemo();
		l.push("push1");
		l.push("push2");
		l.push("push3");
		System.out.println(l.pop());
		System.out.println(l.peek());
		System.out.println(l.pop());
		System.out.println(l.pop());
		System.out.println(l.empty());
	
		

	}

}
