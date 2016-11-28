package ru.efremov.patterns;

public class BancomatMain {
	public static void main(String [] args){
	int [] ruBanknote = {5000, 1000, 500, 100, 50};
	int [] usBanknote = {100, 50, 20, 5};
		
	 Delivery dev1 = new SpecificDelivery();
	 Delivery dev2 = new SpecificDelivery();
	 Delivery dev3 = new SpecificDelivery();
	 Delivery dev4 = new SpecificDelivery();
	 Delivery dev5 = new SpecificDelivery();
	 dev1.setNextDelivery(dev2);
	 dev2.setNextDelivery(dev3);
	 dev3.setNextDelivery(dev4);
	 dev4.setNextDelivery(dev5);
	
	 dev1.delivery(new Money(8950, ruBanknote), 0);
	 System.out.println("---------------------------------------------------------------------");
	 dev1.delivery(new Money(8955, usBanknote), 0);
 }
}

abstract class Delivery{
	
	public Delivery nextDelivery;
	private int step = 0;
	abstract void delivery(Money money, int step);
	
	void setNextDelivery(Delivery dev){
		nextDelivery = dev;
	}
}

class Money{
	private int sum;
	private int [] banknote;
	
	public Money(int sum, int [] banknote){
		setSum(sum, banknote);
		setBanknote(banknote);
	}
	public void setSum(int sum, int [] banknote){
		if(sum>0 && sum%banknote[banknote.length - 1]==0){
			this.sum = sum;
		}else{
		throw new RuntimeException("Невалидная сумма");
		}
	}
	public int getSum(){
		return sum;
	}
	public void setBanknote(int [] banknote){
		this.banknote = banknote;
	}
	public int [] getBanknote(){
		return banknote;
	}
}


class SpecificDelivery extends Delivery{
	
	void delivery(Money money, int step) {
		int count = money.getSum()/money.getBanknote()[step];
		int balance = money.getSum()%money.getBanknote()[step];
		if(count > 0){
			System.out.println(money.getBanknote()[step] + "x" + count);
		}
		if(balance>0 && nextDelivery != null){
			step++;
			nextDelivery.delivery(new Money(balance, money.getBanknote()), step);
		}else{}
	}
}
