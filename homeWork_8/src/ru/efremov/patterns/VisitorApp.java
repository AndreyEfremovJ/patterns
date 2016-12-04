package ru.efremov.patterns;

public class VisitorApp {
	public static void main(String [] arg){
		
	Triangle tr = new Triangle(10, 4);
	Rectangle rt = new Rectangle(5, 8);
	Square sq = new Square(7);
	
	Visitor draw = new DrawVisitor();
	Visitor area = new AreaVisitor();
	Visitor move = new PerimeterVisitor();
	
	sq.accept(draw);
	rt.accept(area);
	tr.accept(move);
	}
}

interface Shape{
	void accept(Visitor visitor);
}

interface Visitor{
	void visit(Triangle triangle);
	void visit(Rectangle rectangle);
	void visit(Square square);
}

class Triangle implements Shape{
	private double x;
	private double h;
	
	public Triangle(double x, double h){
		this.x = x;
		this.h = h;
	}
	
	public double getX () { 
		return x; 
		}
	public double getH () { 
		return h; 
		}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);	
	}
	
}

class Rectangle implements Shape{
	private double x;
	private double y;
	
	public Rectangle(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public double getX () { 
		return x; 
		}
	public double getY () { 
		return y; 
		}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);	
	}

}

class Square implements Shape{
	private double x;
	
	public Square(double x){
		this.x = x;
	}
	
	public double getX () { 
		return x; 
		}

	public void accept(Visitor visitor) {
		visitor.visit(this);	
	}

}

class DrawVisitor implements Visitor{

	public void visit(Triangle triangle) {
		System.out.println("������ ����������� �� ��������� " + triangle.getX() + " � ������ " + triangle.getH());
	}

	public void visit(Rectangle rectangle) {
		System.out.println("������ ������������� �� ������� a " + rectangle.getX() + " � ������� b " + rectangle.getY());
	}

	public void visit(Square square) {
		System.out.println("������ ������� �� ������� " + square.getX());
	}
}
class AreaVisitor implements Visitor{

	public void visit(Triangle triangle) {
		System.out.println("������� ������������ �����: " + 1/2*triangle.getX()*triangle.getH());	
	}

	public void visit(Rectangle rectangle) {
		System.out.println("������� �������������� �����: " + rectangle.getX()*rectangle.getY());	
	}

	public void visit(Square square) {
		System.out.println("������� �������� �����: " + square.getX()*square.getX());
	}
}
class PerimeterVisitor implements Visitor{

	@Override
	public void visit(Triangle triangle) {
		System.out.printf("�������� ������������ �����: %.3f", (Math.sqrt(Math.pow(triangle.getX(), 2) + Math.pow(triangle.getH(), 2))*2 + 2*triangle.getX()));			
	}

	@Override
	public void visit(Rectangle rectangle) {
		System.out.println("�������� �������������� �����: " + 2*rectangle.getX() + 2*rectangle.getY());
	}

	@Override
	public void visit(Square square) {
		System.out.println("�������� �������� �����: " + 4*square.getX());
	}
	
}
