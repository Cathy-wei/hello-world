package Test;

import java.util.*;

public class ListDemo {
	//实现队列
	public static void printQ(Queue queue) {
		while(queue.peek()!=null) 
			System.out.print(queue.remove()+",");

		System.out.println();
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

	}

}
