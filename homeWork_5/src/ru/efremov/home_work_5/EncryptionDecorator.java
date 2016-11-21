package ru.efremov.home_work_5;

public class EncryptionDecorator extends Decorator {

	
	private String encrypt;
	private String unencrypt;
	
	public EncryptionDecorator(IChat chat, String enc, String unenc){
		super(chat);
		this.encrypt = enc;
		this.unencrypt = unenc;
	} 

	public void getMessage(){
		System.out.println(unencrypt);
		super.getMessage();
		System.out.println(unencrypt); 
	}

	@Override
	public void sendMesssage() {
		System.out.println(encrypt);
		super.sendMesssage()
		;System.out.println(encrypt); 	
	}

}
