package com.snake.demo;
import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

//Main Class

public class GreedSnakeGame extends KeyAdapter {

	JFrame mainFrame;

	Canvas paintCanvas;

	JLabel labelScore;// 计分牌

	Snake snake = null;// 蛇

	private Node[] food3;

	public static final int DEFAULT_WIDTH = 1024;

	public static final int DEFAULT_HEIGHT = 1000;

	public static final int nodeWidth = 15;

	public static final int nodeHeight = 15;

	private static final int UP = 0;

	private static final int RIGHT = 0;

	private static final int LEFT = 0;

	private static final int DOWN = 0;

	// GreedSnake():初始化游戏界面

	public GreedSnakeGame() {
		/******	试一试1：修改界面的信息*****/
		// 设置界面元素
		mainFrame = new JFrame("贪吃蛇游戏");
		Container cp = mainFrame.getContentPane();
		labelScore = new JLabel("所得分数为:", JLabel.CENTER);
		cp.add(labelScore, BorderLayout.NORTH);
		paintCanvas = new Canvas();
		paintCanvas.setSize(DEFAULT_WIDTH + 1, DEFAULT_HEIGHT + 1);
		paintCanvas.addKeyListener(this);
		cp.add(paintCanvas, BorderLayout.CENTER);
		JPanel panelButtom = new JPanel();
		panelButtom.setLayout(new BorderLayout());
		JLabel labelHelp;// 帮助信息
		labelHelp = new JLabel("按 PageUP 或 PageDown 键改变速度", JLabel.CENTER);
		panelButtom.add(labelHelp, BorderLayout.NORTH);
		labelHelp = new JLabel("按 Enter 或 S 键重新开始游戏", JLabel.CENTER);
		panelButtom.add(labelHelp, BorderLayout.CENTER);
		labelHelp = new JLabel("按 SPACE 键或 P 键暂停游戏", JLabel.CENTER);
		panelButtom.add(labelHelp, BorderLayout.SOUTH);
		cp.add(panelButtom, BorderLayout.SOUTH);
		mainFrame.addKeyListener(this);
		mainFrame.pack();
		mainFrame.setResizable(false);// 设置窗口大小不能变化
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		//开发游戏
		begin();
	}

	// keyPressed():按键检测

	public void keyPressed(KeyEvent e) {
		
		/*********试一试2：在keyPressed()事件里写一些打印信息********/
		int keyCode = e.getKeyCode();
		if (snake.running)
			switch (keyCode) {
			case KeyEvent.VK_UP:
				//键盘向上 事件
				System.out.println("向上走....");
				snake.changeDirection(Snake.UP);
				break;
			case KeyEvent.VK_DOWN:
				//键盘向 下事件
				System.out.println("向下走....");
				snake.changeDirection(Snake.DOWN);
				break;
			case KeyEvent.VK_LEFT:
				//键盘向左事件
				System.out.println("向左走....");
				snake.changeDirection(Snake.LEFT);
				break;
			case KeyEvent.VK_RIGHT:
				//键盘向右事件
				System.out.println("向右走....");
				snake.changeDirection(Snake.RIGHT);
				break;
  		  case KeyEvent.VK_1:
				snake.speedDown();
				break;
			case KeyEvent.VK_2:
				snake.speedUp();
				break;
			case KeyEvent.VK_SPACE:
				snake.Stop();
				break;
			default:
			}
		// 重新开始
		if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_ENTER) {
			snake.running = false;
			begin();
		}
	}

	// repaint（）：绘制游戏界面（包括蛇和食物）

	void repaint() {
		Graphics g = paintCanvas.getGraphics();
		// 画背景
		g.setColor(Color.pink);
		g.fillRect(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT);
		/*********试一试3：在GreedSnakeGame 类中的repaint() 方法里试着画几个点********/	
		g.setColor(Color.black);
		LinkedList snakelist=snake.nodeArray;
	    for(int i=0;i< snakelist.size() ;i++){
		    Node node=(Node)snakelist.get(i);
	        drawNode(g, node);
        }   
	    //画蛇
	    if(snake.s==1)
        {	g.setColor(Color.green);
            g.fillRect(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT);
            g.setColor(Color.black);
        	for(int i=0;i<snakelist.size();i++){
        		Node node=(Node)snakelist.get(i);
        	    drawNode(g, node);
           }    
        }
	    else if(snake.s==2) {
           g.setColor(Color.yellow);
           g.fillRect(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT);
           g.setColor(Color.black);
       	for(int i=0;i<snakelist.size();i++) {
       		Node node=(Node)snakelist.get(i);
       	    drawNode(g, node);
          }    
	    }
	    else if(snake.s==3){
	    	g.setColor(Color.gray);
	    	snakelist=snake.nodeArray;
	    	for(int i=0;i< snakelist.size() ;i++){
			    Node node=(Node)snakelist.get(i);
		        drawNode(g, node);
	    	}
	    }
	   
	// 吃食物
	g.setColor(Color.red);
	LinkedList snakelist1=snake.nodeArray1;
	for(int i=0;i<snakelist1.size();i++){
		Node node=(Node)snakelist1.get(i);
	    drawNode(g, node);
    } //画墙
	LinkedList wall=snake.point;
	g.setColor(Color.black);
	for(int i=0;i<wall.size();i++)
	{
	Node snode=(Node)wall.get(i);
	drawNode(g,snode);
	}//qiang
	g.setColor(Color.cyan);
	drawNode(g,(Node) snakelist1.get(5));
	g.setColor(Color.BLACK);
	drawNode(g,(Node) snakelist1.get(snake.s));
	//撞墙
	g.setColor(Color.white);
	drawNode(g, snake.food);
	g.setColor(Color.CYAN);
	drawNode(g, snake.food1);
	g.setColor(Color.BLACK);
	drawNode(g, snake.food2);
	g.setColor(Color.red);
	drawNode(g, snake.food3);
	g.setColor(Color.red);
	drawNode(g, snake.food4);
	g.setColor(Color.red);
	drawNode(g, snake.food5);
		// 画食物
	updateScore();
		// 修改分数
	}

	// drawNode（）：绘画某一结点（蛇身或食物）

	private void drawNode(Graphics g, Node n) {
		g.fillRect(n.x * nodeWidth, n.y * nodeHeight, nodeWidth-1, nodeHeight -1);
	}

	// updateScore（）：改变计分牌

	public void updateScore() {
		String s = "所得分数为: " + snake.score;
		labelScore.setText(s);
	}

	// begin（）：游戏开始，放置贪吃蛇

	void begin() {

		if (snake == null || !snake.running) {
			snake = new Snake(this, DEFAULT_WIDTH / nodeWidth, DEFAULT_HEIGHT / nodeHeight);
			(new Thread(snake)).start();
		}
	}

	// main（）：主函数

	public static void main(String[] args) {

		GreedSnakeGame gs = new GreedSnakeGame();
	}
}



