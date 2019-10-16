package com_game;

public class User {
	public String name;
	public int score;
	public int time;
	public int truecount;
	
	public User() {}
	public User(String name, int truecount, int score) {
		this.name = name;
		this.truecount = truecount;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getTruecount() {
		return truecount;
	}
	public void setTruecount(int truecount) {
		this.truecount = truecount;
	}
}
