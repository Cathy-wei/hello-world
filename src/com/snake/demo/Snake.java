package com.snake.demo;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JOptionPane;


// Snake:̰����ģ��

public class Snake implements Runnable {

	GreedSnakeGame gs;

	boolean[][] map;// �������ݱ�����������

	LinkedList nodeArray = new LinkedList();
	LinkedList nodeArray1 = new LinkedList();
	LinkedList point=new  LinkedList();
	Node food;
	Node food1;
	Node food2,food3,food4,food5;
	int s=0;
	int maxX;// �����

	int maxY;// ��󳤶�

	int direction = 2;// ����

	boolean running = false;

	int timeInterval = 100;// ���ʱ�䣨�ٶȣ�

	double speedChangeRate = 0.75;// �ٶȸı�̶�

	boolean paused = false;// ��Ϸ״̬

	int score = 0;

	int countMove = 0;

	public Object speedUp;

	// UP��DOWN��ż����RIGHT��LEFT������
	public static final int UP = 2;

	public static final int DOWN = 4;

	public static final int LEFT = 1;

	public static final int RIGHT = 3;

	// GreedModel():��ʼ������

	public Snake(GreedSnakeGame gs, int maxX, int maxY) {

		this.gs = gs;
		this.maxX = maxX;
		this.maxY = maxY;
		map = new boolean[maxX][];
		for (int i = 0; i < maxX; ++i) {
			map[i] = new boolean[maxY];
			Arrays.fill(map[i], false);// û���ߺ�ʳ��ĵ�����false
		}
		// ��ʼ��̰����
		int initArrayLength = maxX > 20 ? 10: maxX / 2;
		for (int i = 0; i < initArrayLength; ++i) {
			int x = maxX / 2 ;
			int y = maxY / 2+i;
			int x1 = maxX / 2+i ;
			int y1 = maxY / 2;
			nodeArray.addLast(new Node(x, y));
			nodeArray1.addLast(new Node(x1-5, y1-10));
			map[x][y] = true;// ������true
			map[x1][y1] = false;
		}
		//��ʼ��ʳ��
		food = createFood();
		map[food.x][food.y] = true;// ʳ�ﴦ��true
		food1 = createFood();
		map[food1.x][food1.y] = true;
		food2 = createFood();
		map[food2.x][food2.y] = true;		
		food3 = createFood();
		map[food3.x][food3.y] = true;// ʳ�ﴦ��true
		food4 = createFood();
		map[food4.x][food4.y] = true;
		food5 = createFood();
		map[food5.x][food5.y] = true;	
	//��ʼ��ǽ��
			int h= maxX > 20 ? 8: maxX / 4;
			for(int j = 0; j< h; ++j)
			{	
			int x=maxX/6+j;
				int y =maxY/2+j;
			point.addLast(new Node(x, y));
			map[x][y] = true;// ǽ�ڴ���true��
			}	
			
			for(int j=0;j<h;j++)
			{
				int x=maxX-maxX/3+j;
				int y=maxY/3-j;
				point.addLast(new Node(x, y));
				map[x][y] = true;// ǽ�ڴ���true��
			}
	}
	// changeDirection():�ı��˶�����

	public void changeDirection(int newDirection) {

		if (direction % 2 != newDirection % 2) {// �����ͻ
			direction = newDirection;
		}
	}
    
	// moveOn():̰�����˶�����

	public boolean moveOn() {
		//��ȡ̰���ߵ�ͷ���ڵ�
		Node n = (Node) nodeArray.getFirst();
		int x = n.x;
		int y = n.y;
		Node n1 = (Node) nodeArray1.get(5);
		Node n2 = (Node) nodeArray1.get(s);
		
		//���ݷ������λ�Ʊ仯
		switch(direction) {
		case UP:y--;break;
		case DOWN:y++;break;
		case LEFT:x--;break;
		case RIGHT:x++;break;
		}
		if(x<=-1||x>=maxX || y>=maxY||y<=0) return false;
		
		//�Ե�ǽ
		if( x==n1.x && y==n1.y )
			timeInterval-=25;
		else if( x==n2.x && y==n2.y )
			timeInterval+=28;
		//�Ե��Լ�
		if(map[x][y]==true && (x!=food.x && y!=food.y)&& (x!=food1.x && y!=food1.y)&& (x!=food2.x && y!=food2.y)&&(
				x!=food3.x && y!=food3.y)&& (x!=food4.x && y!=food4.y)&& (x!=food5.x && y!=food5.y)) 
    	return false;
		if(x==food.x && y==food.y) {
			nodeArray.addFirst(food);
			map[x][y]=true;
			food=createFood();
			score+=10;
			speedUp();
			s=1;
		}
		else if((x==food3.x&&y==food3.y)||(x==food4.x&&y==food4.y)||(x==food5.x&&y==food5.y))
		{
			nodeArray.addFirst(food3);
			map[x][y]=true;
			food3=createFood();
			food4=createFood();
			food5=createFood();
			score+=10;
		}
		else if(x==food1.x && y==food1.y) {
			nodeArray.addFirst(food1);
		    map[x][y]=true;
			food1=createFood();
			score+=10;
			speedDown();
			s=2;
		}
		else if(x==food2.x && y==food2.y) {
			nodeArray.addFirst(food2);
		    map[x][y]=true;
			food2=createFood();
			score+=10;
			speedDown();
			s=3;
			Node taillast=(Node)nodeArray.removeLast();
		    map[taillast.x][taillast.y]=false;
		}
	
		//���ڵ�������ͷ
		else {
		    nodeArray.addFirst(new Node(x,y));
		    map[x][y]=true;
		    //ȥ��β���ڵ�
		    Node taillast=(Node)nodeArray.removeLast();
		    map[taillast.x][taillast.y]=false;
		    //�����ƶ������λ�ã������жϣ�1-ʲô��û������(true)   2-�Ե�ʳ�� (true) 3-�����Լ�����(false)   4-Խ��
		
		}
		
		return true;
	}

	private void setColor(Color black) {
		// TODO Auto-generated method stub
		
	}


	// run():̰�����˶��߳�

	public void run() {
		running = true;
		while (running) {
			try {
				Thread.sleep(timeInterval);
			} catch (Exception e) {
				break;
			}
			if (!paused) {
				boolean flag=moveOn();
				if (flag) {// δ����
					gs.repaint();
				} 
				else {// ��Ϸ����
					JOptionPane.showMessageDialog(null, "GAME OVER", "Game Over", JOptionPane.INFORMATION_MESSAGE);
					break;
				}
			}
		}
		running = false;
	}

	// createFood():����ʳ�Ｐ���õص�

	Node createFood() {

		int x = 0;
		int y = 0;
		do {
			Random r = new Random();
			x = r.nextInt(maxX);
			y = r.nextInt(maxY);
			
		} while (map[x][y]);
		
		return new Node(x, y);
	}

	// speedUp():�ӿ����˶��ٶ�

	public void speedUp() {
		timeInterval-=30;
	}

	// speedDown():�������˶��ٶ�

	public void speedDown() {
		timeInterval+=30;
		
	}

	// changePauseState(): �ı���Ϸ״̬����ͣ�������

//	public void changePauseState() {
//		
//		
//	}

	public void Stop() {
		if(!this.paused)
			this.paused=true;
		else
			this.paused=false;
	
		
	}
}
