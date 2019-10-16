package com_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


class CharPanel extends JPanel implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int ballCount = 100;
	
    int []x = new int[ballCount];
    int []y = new int[ballCount];
    char []ch = new char[ballCount];
    public static int score = 50;
    public static int truecount = 0;
    
    public int speed = 1;
    public int count = 1;
    public String name = null;
    public int time = 100;  
    public int timecount = 0;
    Thread thread;
	CharListener charListener = new CharListener();
    
    public CharPanel(int ballCount){
    	this.ballCount = ballCount;
        for(int i = 0; i < ballCount; i++){
        	x[i] = (int)(100 + Math.random() * 520);
        	y[i] = (int)(Math.random() * 300);
            ch[i] = (char)(Math.random() * 26 + 97);
        }
        setEvent();
    }
    public Thread getThread() {
		return thread;
	}
	public void setThread(Thread thread) {
		this.thread = thread;
	}
	
    public void setEvent() {
    	charListener.setAbscissa(x);
    	charListener.setOrdinate(y);
    	charListener.setCh(ch);
    	charListener.setBallCount(ballCount);
    	addKeyListener(charListener);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        ImageIcon icon1 = new ImageIcon("images\\2.jpg");
        ImageIcon icon2 = new ImageIcon("images\\3.jpg");
        Font f1 = new Font("楷体",Font.BOLD,30);
        Font f2 = new Font("楷体",Font.BOLD,28);
        g.setColor(Color.RED);
        g.setFont(f2);
        if(time <= 0 || score <= 0){
        	thread.stop();
        	name = JOptionPane.showInputDialog("请输入你的名字");
        	if(name != null){
        		User user = new User(name, truecount, score);
        		UserDao.save(user);
        	}
        	g.drawImage(icon2.getImage(), 0, 0, getSize().width, getSize().height, this);
            return ;
        }
        
        g.drawImage(icon1.getImage(), 0, 0, getSize().width, getSize().height, this);
        g.drawString("分数：" + score, 10, 30);
        g.drawString("正确数:" + truecount, 200, 30);
        g.drawString("时间：" + time, 500, 30);
        g.setFont(f1);
        g.setColor(Color.BLUE);
        for(int i = 0; i < ballCount; i++){
            g.drawString("" + (char)ch[i], x[i], y[i]);
        }
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
    	int num;
    	if(ballCount <= 5){
    		num = 250;
    	}else if(ballCount <= 10 && ballCount > 5){
    		num = 500;
    	}else{
    		num = 750;
    	}
        while(true){
            for(int i = 0; i < ballCount; i++){
            	count++;
            	timecount++;
            	y[i] += speed;
                if(y[i] > 500){
                	y[i] = 0;
                    score -= 1;
                }
                if(count > 5000){
                	speed += 1;
                	count = 1;
                }
                if(timecount > num){
                	time--;
                	timecount = 0;
                }
            }
            try{
                Thread.sleep(30);
            }catch(Exception e){}
            repaint();
        }
    }
	
}
