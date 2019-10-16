package com_game;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StartJFrame extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel imagePanel = new JPanel();
    private ImageIcon background = new ImageIcon("images\\1.jpg");
	
	JButton startbutton = new JButton("开始游戏");
	JButton choicebutton = new JButton("难度选择");
	JButton ranklist = new JButton("排  行  榜");
	JButton endbutton = new JButton("退出游戏");
	JLabel label = new JLabel("欢迎来到打字母游戏！");
	Box box = Box.createVerticalBox();
	
	ChoicePass choice = new ChoicePass();
	int ballCount;
	public StartJFrame() {
		init();
		setVisible(true);
		setLayout(new FlowLayout());
		setResizable(false);
		setTitle("打字母游戏");
		setBounds(750, 300, 400, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void init(){
		
		JLabel labelback = new JLabel(background);
		labelback.setBounds(0, 0, 400, 400);
		imagePanel = (JPanel) this.getContentPane();
        imagePanel.setOpaque(false);
		
		startbutton.addActionListener(this);
		ranklist.addActionListener(this);
		choicebutton.addActionListener(this);
		endbutton.addActionListener(this);
		
		label.setFont(new Font("楷体", Font.BOLD, 30));
		box.add(Box.createVerticalStrut(10));
		imagePanel.add(label);
		box.add(Box.createVerticalStrut(20));
		box.add(startbutton);
		box.add(Box.createVerticalStrut(10));
		box.add(ranklist);
		box.add(Box.createVerticalStrut(10));
		box.add(choicebutton);
		box.add(Box.createVerticalStrut(10));
		box.add(endbutton);
		imagePanel.add(box);
		
		getLayeredPane().add(labelback, new Integer(Integer.MIN_VALUE));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "开始游戏"){
			this.setVisible(false);
			ballCount = choice.ballCount;
			if(ballCount == 0){
				ballCount = 5;
			}
			new CharJFrame(ballCount);
		}else if(e.getActionCommand() == "排  行  榜"){
			Rank_list rank_list = new Rank_list();
			rank_list.setVisible(true);
		}else if(e.getActionCommand() == "难度选择"){
			choice.setballCount(ballCount);
			choice.setVisible(true);
		}else if(e.getActionCommand() == "退出游戏"){
			System.exit(0);
		}
	}
}
