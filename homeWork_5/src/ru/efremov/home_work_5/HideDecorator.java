package ru.efremov.home_work_5;

public class HideDecorator extends Decorator{
	
	public HideDecorator(IChat chat){
		super(chat);
	} 

	public Message getMessage() {
		return (Message) chat;
	}

	@Override
	public void sendMesssage() {
        chat.getMessage().setAutor("XXX");
        chat.getMessage().setRecipient("YYY");
		chat.sendMesssage();		
	}

}
