package ru.efremov.home_work_5;

public abstract class Decorator implements IChat {
	
	private IChat chat;
	
	public Decorator(IChat chat) {
		this.chat = chat;
	}
	
	public void getMessage(){
		chat.getMessage();
	}
	
	public void sendMesssage(){
		chat.sendMesssage();
	}
}
