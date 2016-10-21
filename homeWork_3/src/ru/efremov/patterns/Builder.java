package ru.efremov.patterns;

public class Builder {
	public static void main(String[] args) {
		Letter letter = new LetterBuilder("Fred", "Hello fred")
					.appendRecipient("Alex")
					.appendTopic("quickly")
					.build();
		System.out.println(letter);
	}
}

 class Letter {
	 String recipient;
	 String letterBody;
	 String topic;
	
	 public void setRecipient(String recipient) {
	 this.recipient = recipient;
	 }
	
	 public void setLetterBody(String letterBody) {
	 this.letterBody = letterBody;
	 }
	
	 public void setTopic(String topic) {
	 this.topic = topic;
	 }	 
	 
	@Override
	public String toString() {
		return "recipient=" + recipient + "; " + "\n" + "topic=" + topic + ";" + "\n" + "letterBody=" + letterBody;
	}
 }

class LetterBuilder {

	String rec;
	String body;
	String top = null;

	LetterBuilder(String rec, String body) {
		this.rec = rec;
		this.body = body;
	}

	LetterBuilder appendRecipient(String rec) {
		this.rec += (", " + rec);
		return this;
	}

	LetterBuilder appendTopic(String top) {
		if (this.top == null)
			this.top = top;
		return this;
	}
	
	Letter build(){
		Letter letter = new Letter();
		letter.setRecipient(rec);
		letter.setLetterBody(body);
		letter.setTopic(top);
		return letter;
	};
}