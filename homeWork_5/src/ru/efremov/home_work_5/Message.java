package ru.efremov.home_work_5;

public class Message implements IChat{
	
	String autor;
	String recipient;
	String text;
	
	public Message (String autor, String recipient, String text){
		this.autor = autor;
		this.recipient = recipient;
		this.text = text;
	}

	public void getMessage() {
		System.out.println(autor);
		System.out.println(recipient);
		System.out.println(text);
	}

	public void sendMesssage() {
		System.out.println(autor);
		System.out.println(recipient);
		System.out.println(text);
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public String toString(){
		return autor + "\n" + recipient + "\n" + text;
	}
}
