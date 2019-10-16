package com_game;

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Iterator;
import java.util.List;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Rank_list extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	User user = null;
	List<User> users = UserDao.query();
	private JPanel imagePanel =new JPanel();;
	private ImageIcon background = new ImageIcon("images\\1.jpg");
	
	JLabel title = new JLabel("排行榜");
	
	Box box = Box.createVerticalBox();
	Box boxH = Box.createHorizontalBox();
	Box boxHone = Box.createVerticalBox();
	Box boxHtwo = Box.createVerticalBox();
	Box boxHthree = Box.createVerticalBox();
	JLabel nameJL = new JLabel("姓名");
	JLabel truecount = new JLabel("正确数");
	JLabel scoreJL = new JLabel("分数");
	
	public Rank_list(){
		init();
		setVisible(false);
		setLayout(new FlowLayout());
		setResizable(false);
		setTitle("打字母游戏");
		setBounds(750, 320, 400 , 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void init(){
		JLabel labelback = new JLabel(background);
		labelback.setBounds(0, 0, 400, 400);
		imagePanel = (JPanel) this.getContentPane();
        imagePanel.setOpaque(false);
        
        title.setFont(new Font("楷体", Font.BOLD, 30));
        Font f1 = new Font("楷体", Font.BOLD, 22);
        Font f2 = new Font("楷体", Font.BOLD, 20);
        nameJL.setFont(f1);
        truecount.setFont(f1);
        scoreJL.setFont(f1);
        box.add(title);
        box.add(Box.createVerticalStrut(10));
        
        boxHone.add(nameJL);
        boxHtwo.add(truecount);
        boxHthree.add(scoreJL);
        
        Iterator<User> it = users.iterator();
        while(it.hasNext()){
        	user = (User)it.next();
        	JLabel name = new JLabel(user.getName());
        	JLabel truenum = new JLabel("" + user.getTruecount());
        	JLabel score = new JLabel("" + user.getScore());
        	name.setFont(f2);
        	truenum.setFont(f2);
        	score.setFont(f2);
        	
        	boxHone.add(name);
        	boxHtwo.add(truenum);
        	boxHthree.add(score);
        }
        
        boxH.add(boxHone);
        boxH.add(Box.createHorizontalStrut(30));
        boxH.add(boxHtwo);
        boxH.add(Box.createHorizontalStrut(30));
        boxH.add(boxHthree);
        box.add(boxH);
        imagePanel.add(box);
        getLayeredPane().add(labelback, new Integer(Integer.MIN_VALUE));
	}
}
