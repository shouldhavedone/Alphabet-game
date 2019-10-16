package com_game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CharJFrame extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer ballCount;
	CharPanel charPanel;
	JMenuBar menubar = new JMenuBar();
	JPanel panel = new JPanel();
	JButton exitbutton = new JButton("退出游戏");
	JButton rankbutton = new JButton("排行榜");
	Thread t;
	
	public CharJFrame(Integer ballCount) {
    	this.ballCount = ballCount;
    	charPanel = new CharPanel(ballCount);
    	init();
    	setEvent();
    	setTitle("打字母游戏");
        setBounds(650, 300, 740, 550);
        setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        
        t = new Thread(charPanel);
        t.start();
        charPanel.setThread(t);
        
        if (!charPanel.isFocusable()){
        	charPanel.setFocusable(true);
        }
        if (!charPanel.isFocusOwner()){
        	charPanel.requestFocus();
        }
    }
    public void init(){
    	exitbutton.addActionListener(this);
    	rankbutton.addActionListener(this);
    	panel.add(exitbutton);
    	panel.add(rankbutton);
    	add(panel, BorderLayout.SOUTH);
        add(charPanel);
        charPanel.setBackground(Color.BLACK);
    }
    public void setEvent() {
		CharListener listener = new CharListener();
		addKeyListener(listener);
	}
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == exitbutton){
			System.exit(0);
		}else if(e.getSource() == rankbutton){
			Rank_list rank_list = new Rank_list();
			rank_list.setVisible(true);
		}
	}
}
