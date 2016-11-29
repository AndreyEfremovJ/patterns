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
		System.out.print("������� �����(1 - ��� ������): ");
		int input = in.nextInt();
		if(input != 1){
			cs.setSum(input);
			cs.setState(new Payment());
			cs.action();
		}else{
			System.out.println("�� ��������!");
		}
	}
}
class Payment implements State{
	public void action(CopyStation cs) {
		if(cs.getSum() >= CopyStation.price){
			System.out.println("���������");
			cs.setSum(cs.getSum() - CopyStation.price);
			cs.setState(new ChoiseDevice());
		}else{
			System.out.println("������������ �������. ����������� ����� " + CopyStation.price);
			cs.setState(new Initial());
		}
			cs.action();
	}
}

class ChoiseDevice implements State{

	public void action(CopyStation cs) {
		Scanner in = new Scanner(System.in);
		System.out.print("�������� ���������� (1.USB, 2.Wi-Fi): ");
		if(in.nextInt() == 1){
			System.out.println("������ � USB");
		}else{
			System.out.println("������ � Wi-Fi");
		}
		cs.setState(new ChoiseDoc());
		cs.action();
	}
}
class ChoiseDoc implements State{

	public void action(CopyStation cs) {
		Scanner in = new Scanner(System.in);
		System.out.print("�������� �������� (1.DOC, 2.PDF): ");
		if(in.nextInt() == 1){
			System.out.println("������ DOC");
		}else{
			System.out.println("������ PDF");
		}
		cs.setState(new PrintDoc());
		cs.action();
	}
}
class PrintDoc implements State{

	public void action(CopyStation cs) {
		System.out.println("���� ������ ....");
		System.out.println("������!");
		Scanner in = new Scanner(System.in);
		System.out.println("������ ����������� ���?(1.��, 2.���): ");
		if(in.nextInt() == 1){
			cs.setState(new Payment());
			cs.action();
		}else{
			System.out.println("�������� �����: " + cs.getSum());
		}
	}
}

