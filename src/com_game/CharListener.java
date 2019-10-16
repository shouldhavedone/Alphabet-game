package com_game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CharListener implements KeyListener {
	
	public static int []x = null;
    public static int []y = null;
    public static char []ch = null;
    public static int ballCount;
    public static int truecount = 0;
    
    public void setAbscissa(int[] Abscissa) {
		CharListener.x = Abscissa;
	}
	public void setOrdinate(int[] Ordinate) {
		CharListener.y = Ordinate;
	}
	public void setCh(char[] ch) {
		CharListener.ch = ch;
	}
	public void setBallCount(int ballCount) {
		CharListener.ballCount = ballCount;
	}
	public void keyPressed(KeyEvent e) {
        int yy = -1;
        int index = -1;
        // TODO Auto-generated method stub
        for(int i = 0; i < ballCount; i++) {
            if(e.getKeyChar() == ch[i]) {
                if(yy < y[i]) {
                    yy = y[i];
                    index = i;
                }
            }
        }
        if(index > -1){
        	CharPanel.score += 1;
        	CharPanel.truecount += 1;
        	y[index] = 0;
        	x[index] = (int)(Math.random() * 500);
        	ch[index] = (char)(Math.random() * 26 + 97);
        }
		
		
    }
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
    }
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}