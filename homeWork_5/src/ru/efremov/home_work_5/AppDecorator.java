package ru.efremov.home_work_5;

public class AppDecorator {
	public static void main(String [] arg){
		
		IChat chat = new Message("Maxim", "Alexander", "Hi, how do you do!!!"); 
		chat.sendMesssage();
		
		System.out.println("--------------------------------------------------------------");
		
		IChat chat1 = new HideDecorator(new Message("Maxim", "Alexander", "Hi, how do you do!!!"));
		chat1.sendMesssage();
		
		System.out.println("--------------------------------------------------------------");
		
		IChat chat2 = new EncryptionDecorator(new Message("Maxim", "Alexander", "Hi, how do you do!!!"));
		chat2.sendMesssage();

	}
}
