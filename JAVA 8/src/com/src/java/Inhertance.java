package com.src.java;

public class Inhertance {
	int a = 10;

	public void show() {
		System.out.println("parent method called");
	}

	public void run() {
		System.out.println("run method called");
	}
}

class Inn extends Inhertance {
	@Override
	public void show() {
		System.out.println("child calling");
		super.run();
	}
}
