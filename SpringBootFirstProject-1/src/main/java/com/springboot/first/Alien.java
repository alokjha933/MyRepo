package com.springboot.first;


public class Alien {

	private int rollNo;

	Computer com;

	public Computer getCom() {
		return com;
	}

	public void setCom(Computer com) {
		this.com = com;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	void show() {
		System.out.println("Working");
		com.show();
	}
}
