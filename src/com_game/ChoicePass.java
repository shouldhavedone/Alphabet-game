package com_game;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChoicePass extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel imagePanel =new JPanel();;
	private ImageIcon background = new ImageIcon("images\\1.jpg");
	
	JLabel label = new JLabel("请进行游戏难度选择！");
	JButton choiceOne = new JButton("高    级");
	JButton choiceTwo = new JButton("中    级");
	JButton choiceThree = new JButton("初    级");
	JButton choiceFour = new JButton("自定义");
	Box box = Box.createVerticalBox();
	
	int ballCount;
	public void setballCount(int ballCount){
		this.ballCount = ballCount;
	}
	public ChoicePass(){
		init();
		setVisible(false);
		setLayout(new FlowLayout());
		setResizable(false);
		setTitle("�Ѷ�ѡ��");
		setBounds(750, 320, 400 , 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void init(){
		
		JLabel labelback = new JLabel(background);
		labelback.setBounds(0, 0, 400, 400);
		imagePanel = (JPanel) this.getContentPane();
        imagePanel.setOpaque(false);
        
        label.setFont(new Font("打字母游戏", Font.BOLD, 30));
        box.add(Box.createVerticalStrut(10));
		box.add(choiceOne);
		box.add(Box.createVerticalStrut(10));
		box.add(choiceTwo);
		box.add(Box.createVerticalStrut(10));
		box.add(choiceThree);
		box.add(Box.createVerticalStrut(10));
		box.add(choiceFour);
		imagePanel.add(label);
		imagePanel.add(box);
		
		choiceOne.addActionListener(this);
		choiceTwo.addActionListener(this);
		choiceThree.addActionListener(this);
		choiceFour.addActionListener(this);
		
		getLayeredPane().add(labelback, new Integer(Integer.MIN_VALUE));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "高    级"){
			ballCount = 15;
		}else if(e.getActionCommand() == "中    级"){
			ballCount = 10;
		}else if(e.getActionCommand() == "初    级"){
			ballCount = 5;
		}else if(e.getActionCommand() == "自定义"){
			String str = JOptionPane.showInputDialog("请输入你要挑战的个数");
			ballCount = Integer.parseInt(str);
		}
	}
}
