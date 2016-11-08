package ru.efremov.home_work_5;

public class EncryptionDecorator extends Decorator {

	public EncryptionDecorator(IChat chat) {
		super(chat);
	}

	public Message getMessage() {
		return (Message) chat;
	}

	@Override
	public void sendMesssage() {
	
		chat.getMessage().setText("<Encrypted>" + chat.getMessage().text + "</encrypted>");
		chat.sendMesssage();	
	}

}
