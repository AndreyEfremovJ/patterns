package ru.efremov.home_work_5;

public abstract class Decorator implements IChat {
	
	IChat chat;
	
	public Decorator(IChat chat) {
		this.chat = chat;
	}
}
