package ru.efremov.patterns;

import java.util.Scanner;

public class StateApp {
	public static void main(String[] args) {
		CopyStation copyStation = new CopyStation();
		copyStation.setState(new Initial());
		copyStation.action();
	}
}

class CopyStation{
	public static int price = 20;
	private State state;
	private int sum;
	
	public void setState(State s){this.state = s;}
	
	public void setSum(int sum){
		this.sum = sum;
	}
	
	public int getSum() {
		return sum;
	}
	
	public void action(){
		state.action(this);
	}
}

interface State{
	void action(CopyStation cs);
}
class Initial implements State{

	public void action(CopyStation cs) {
		Scanner in = new Scanner(System.in);
		System.out.print("Внесите сумму(1 - для выхода): ");
		int input = in.nextInt();
		if(input != 1){
			cs.setSum(input);
			cs.setState(new Payment());
			cs.action();
		}else{
			System.out.println("До свидания!");
		}
	}
}
class Payment implements State{
	public void action(CopyStation cs) {
		if(cs.getSum() >= CopyStation.price){
			System.out.println("Оплаченно");
			cs.setSum(cs.getSum() - CopyStation.price);
			cs.setState(new ChoiseDevice());
		}else{
			System.out.println("Недостаточно средств. Минимальная сумма " + CopyStation.price);
			cs.setState(new Initial());
		}
			cs.action();
	}
}

class ChoiseDevice implements State{

	public void action(CopyStation cs) {
		Scanner in = new Scanner(System.in);
		System.out.print("Выберите устройство (1.USB, 2.Wi-Fi): ");
		if(in.nextInt() == 1){
			System.out.println("Печать с USB");
		}else{
			System.out.println("Печать с Wi-Fi");
		}
		cs.setState(new ChoiseDoc());
		cs.action();
	}
}
class ChoiseDoc implements State{

	public void action(CopyStation cs) {
		Scanner in = new Scanner(System.in);
		System.out.print("Выберите документ (1.DOC, 2.PDF): ");
		if(in.nextInt() == 1){
			System.out.println("Печать DOC");
		}else{
			System.out.println("Печать PDF");
		}
		cs.setState(new PrintDoc());
		cs.action();
	}
}
class PrintDoc implements State{

	public void action(CopyStation cs) {
		System.out.println("Идет печать ....");
		System.out.println("Готово!");
		Scanner in = new Scanner(System.in);
		System.out.println("Хотите распечатать еще?(1.Да, 2.Нет): ");
		if(in.nextInt() == 1){
			cs.setState(new Payment());
			cs.action();
		}else{
			System.out.println("Возьмите сдачу: " + cs.getSum());
		}
	}
}

