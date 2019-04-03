package com.snake.demo;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JOptionPane;


// Snake:贪吃蛇模型

public class Snake implements Runnable {

	GreedSnakeGame gs;

	boolean[][] map;// 界面数据保存在数组里

	LinkedList nodeArray = new LinkedList();
	LinkedList nodeArray1 = new LinkedList();
	LinkedList point=new  LinkedList();
	Node food;
	Node food1;
	Node food2,food3,food4,food5;
	int s=0;
	int maxX;// 最大宽度

	int maxY;// 最大长度

	int direction = 2;// 方向

	boolean running = false;

	int timeInterval = 100;// 间隔时间（速度）

	double speedChangeRate = 0.75;// 速度改变程度

	boolean paused = false;// 游戏状态

	int score = 0;

	int countMove = 0;

	public Object speedUp;

	// UP和DOWN是偶数，RIGHT和LEFT是奇数
	public static final int UP = 2;

	public static final int DOWN = 4;

	public static final int LEFT = 1;

	public static final int RIGHT = 3;

	// GreedModel():初始化界面

	public Snake(GreedSnakeGame gs, int maxX, int maxY) {

		this.gs = gs;
		this.maxX = maxX;
		this.maxY = maxY;
		map = new boolean[maxX][];
		for (int i = 0; i < maxX; ++i) {
			map[i] = new boolean[maxY];
			Arrays.fill(map[i], false);// 没有蛇和食物的地区置false
		}
		// 初始化贪吃蛇
		int initArrayLength = maxX > 20 ? 10: maxX / 2;
		for (int i = 0; i < initArrayLength; ++i) {
			int x = maxX / 2 ;
			int y = maxY / 2+i;
			int x1 = maxX / 2+i ;
			int y1 = maxY / 2;
			nodeArray.addLast(new Node(x, y));
			nodeArray1.addLast(new Node(x1-5, y1-10));
			map[x][y] = true;// 蛇身处置true
			map[x1][y1] = false;
		}
		//初始化食物
		food = createFood();
		map[food.x][food.y] = true;// 食物处置true
		food1 = createFood();
		map[food1.x][food1.y] = true;
		food2 = createFood();
		map[food2.x][food2.y] = true;		
		food3 = createFood();
		map[food3.x][food3.y] = true;// 食物处置true
		food4 = createFood();
		map[food4.x][food4.y] = true;
		food5 = createFood();
		map[food5.x][food5.y] = true;	
	//初始化墙壁
			int h= maxX > 20 ? 8: maxX / 4;
			for(int j = 0; j< h; ++j)
			{	
			int x=maxX/6+j;
				int y =maxY/2+j;
			point.addLast(new Node(x, y));
			map[x][y] = true;// 墙壁处置true；
			}	
			
			for(int j=0;j<h;j++)
			{
				int x=maxX-maxX/3+j;
				int y=maxY/3-j;
				point.addLast(new Node(x, y));
				map[x][y] = true;// 墙壁处置true；
			}
	}
	// changeDirection():改变运动方向

	public void changeDirection(int newDirection) {

		if (direction % 2 != newDirection % 2) {// 避免冲突
			direction = newDirection;
		}
	}
    
	// moveOn():贪吃蛇运动函数

	public boolean moveOn() {
		//获取贪吃蛇的头部节点
		Node n = (Node) nodeArray.getFirst();
		int x = n.x;
		int y = n.y;
		Node n1 = (Node) nodeArray1.get(5);
		Node n2 = (Node) nodeArray1.get(s);
		
		//根据方向进行位移变化
		switch(direction) {
		case UP:y--;break;
		case DOWN:y++;break;
		case LEFT:x--;break;
		case RIGHT:x++;break;
		}
		if(x<=-1||x>=maxX || y>=maxY||y<=0) return false;
		
		//吃到墙
		if( x==n1.x && y==n1.y )
			timeInterval-=25;
		else if( x==n2.x && y==n2.y )
			timeInterval+=28;
		//吃到自己
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
	
		//将节点纳入蛇头
		else {
		    nodeArray.addFirst(new Node(x,y));
		    map[x][y]=true;
		    //去除尾部节点
		    Node taillast=(Node)nodeArray.removeLast();
		    map[taillast.x][taillast.y]=false;
		    //根据移动后的新位置，进行判断：1-什么都没有碰到(true)   2-吃到食物 (true) 3-碰到自己身体(false)   4-越界
		
		}
		
		return true;
	}

	private void setColor(Color black) {
		// TODO Auto-generated method stub
		
	}


	// run():贪吃蛇运动线程

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
				if (flag) {// 未结束
					gs.repaint();
				} 
				else {// 游戏结束
					JOptionPane.showMessageDialog(null, "GAME OVER", "Game Over", JOptionPane.INFORMATION_MESSAGE);
					break;
				}
			}
		}
		running = false;
	}

	// createFood():生成食物及放置地点

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

	// speedUp():加快蛇运动速度

	public void speedUp() {
		timeInterval-=30;
	}

	// speedDown():放慢蛇运动速度

	public void speedDown() {
		timeInterval+=30;
		
	}

	// changePauseState(): 改变游戏状态（暂停或继续）

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
