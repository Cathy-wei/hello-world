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

	JLabel labelScore;// �Ʒ���

	Snake snake = null;// ��

	private Node[] food3;

	public static final int DEFAULT_WIDTH = 1024;

	public static final int DEFAULT_HEIGHT = 1000;

	public static final int nodeWidth = 15;

	public static final int nodeHeight = 15;

	private static final int UP = 0;

	private static final int RIGHT = 0;

	private static final int LEFT = 0;

	private static final int DOWN = 0;

	// GreedSnake():��ʼ����Ϸ����

	public GreedSnakeGame() {
		/******	��һ��1���޸Ľ������Ϣ*****/
		// ���ý���Ԫ��
		mainFrame = new JFrame("̰������Ϸ");
		Container cp = mainFrame.getContentPane();
		labelScore = new JLabel("���÷���Ϊ:", JLabel.CENTER);
		cp.add(labelScore, BorderLayout.NORTH);
		paintCanvas = new Canvas();
		paintCanvas.setSize(DEFAULT_WIDTH + 1, DEFAULT_HEIGHT + 1);
		paintCanvas.addKeyListener(this);
		cp.add(paintCanvas, BorderLayout.CENTER);
		JPanel panelButtom = new JPanel();
		panelButtom.setLayout(new BorderLayout());
		JLabel labelHelp;// ������Ϣ
		labelHelp = new JLabel("�� PageUP �� PageDown ���ı��ٶ�", JLabel.CENTER);
		panelButtom.add(labelHelp, BorderLayout.NORTH);
		labelHelp = new JLabel("�� Enter �� S �����¿�ʼ��Ϸ", JLabel.CENTER);
		panelButtom.add(labelHelp, BorderLayout.CENTER);
		labelHelp = new JLabel("�� SPACE ���� P ����ͣ��Ϸ", JLabel.CENTER);
		panelButtom.add(labelHelp, BorderLayout.SOUTH);
		cp.add(panelButtom, BorderLayout.SOUTH);
		mainFrame.addKeyListener(this);
		mainFrame.pack();
		mainFrame.setResizable(false);// ���ô��ڴ�С���ܱ仯
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		//������Ϸ
		begin();
	}

	// keyPressed():�������

	public void keyPressed(KeyEvent e) {
		
		/*********��һ��2����keyPressed()�¼���дһЩ��ӡ��Ϣ********/
		int keyCode = e.getKeyCode();
		if (snake.running)
			switch (keyCode) {
			case KeyEvent.VK_UP:
				//�������� �¼�
				System.out.println("������....");
				snake.changeDirection(Snake.UP);
				break;
			case KeyEvent.VK_DOWN:
				//������ ���¼�
				System.out.println("������....");
				snake.changeDirection(Snake.DOWN);
				break;
			case KeyEvent.VK_LEFT:
				//���������¼�
				System.out.println("������....");
				snake.changeDirection(Snake.LEFT);
				break;
			case KeyEvent.VK_RIGHT:
				//���������¼�
				System.out.println("������....");
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
		// ���¿�ʼ
		if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_ENTER) {
			snake.running = false;
			begin();
		}
	}

	// repaint������������Ϸ���棨�����ߺ�ʳ�

	void repaint() {
		Graphics g = paintCanvas.getGraphics();
		// ������
		g.setColor(Color.pink);
		g.fillRect(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT);
		/*********��һ��3����GreedSnakeGame ���е�repaint() ���������Ż�������********/	
		g.setColor(Color.black);
		LinkedList snakelist=snake.nodeArray;
	    for(int i=0;i< snakelist.size() ;i++){
		    Node node=(Node)snakelist.get(i);
	        drawNode(g, node);
        }   
	    //����
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
	   
	// ��ʳ��
	g.setColor(Color.red);
	LinkedList snakelist1=snake.nodeArray1;
	for(int i=0;i<snakelist1.size();i++){
		Node node=(Node)snakelist1.get(i);
	    drawNode(g, node);
    } //��ǽ
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
	//ײǽ
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
		// ��ʳ��
	updateScore();
		// �޸ķ���
	}

	// drawNode�������滭ĳһ��㣨�����ʳ�

	private void drawNode(Graphics g, Node n) {
		g.fillRect(n.x * nodeWidth, n.y * nodeHeight, nodeWidth-1, nodeHeight -1);
	}

	// updateScore�������ı�Ʒ���

	public void updateScore() {
		String s = "���÷���Ϊ: " + snake.score;
		labelScore.setText(s);
	}

	// begin��������Ϸ��ʼ������̰����

	void begin() {

		if (snake == null || !snake.running) {
			snake = new Snake(this, DEFAULT_WIDTH / nodeWidth, DEFAULT_HEIGHT / nodeHeight);
			(new Thread(snake)).start();
		}
	}

	// main������������

	public static void main(String[] args) {

		GreedSnakeGame gs = new GreedSnakeGame();
	}
}



