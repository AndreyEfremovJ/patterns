package ru.efremov.home_work_5;

public class AppDecorator {
	public static void main(String [] arg){
		
		IChat chat = new Message("Maxim", "Alexander", "Hi, how do you do!!!"); 
		
		Decorator dec = new EncryptionDecorator(chat,
				"Encryption", "Unencryption");
		dec.sendMesssage();
		dec.getMessage();
		
		System.out.println("--------------------------------------------------------------");
		
		Decorator dec2 = new HideDecorator(chat, "Hide");
		dec2.sendMesssage();
		dec2.getMessage();
		
		System.out.println("--------------------------------------------------------------");
		
		Decorator dec3 = new EncryptionDecorator(new HideDecorator(chat, "Hide"), "Encryption", "Unencryption");
		dec3.sendMesssage();
		dec3.getMessage();
	}
}
