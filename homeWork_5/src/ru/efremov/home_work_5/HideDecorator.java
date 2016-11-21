package ru.efremov.home_work_5;

public class HideDecorator extends Decorator{
	
	private String hide;
	
	public HideDecorator(IChat chat, String hide){
		super(chat);
		this.hide = hide;
	} 

	public void getMessage(){
		if(hide != null)
			super.getMessage();
	}

	@Override
	public void sendMesssage() {
		System.out.println(hide);
		super.sendMesssage();
		System.out.println(hide); 	
	}

}
