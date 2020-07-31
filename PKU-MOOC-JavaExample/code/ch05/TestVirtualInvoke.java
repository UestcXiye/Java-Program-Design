class TestVirtualInvoke
{
	static void doStuff( Shape s ){
		s.draw();
	}

	public static void main( String [] args ){
		Circle c = new Circle();
		Triangle t = new Triangle();
		Line l = new Line();
		doStuff(c);
		doStuff(t);
		doStuff(l);
	}
}
class Shape
{
	void draw(){ System.out.println("Shape Drawing"); }
}
class Circle extends Shape
{
	void draw(){ System.out.println("Draw Circle"); }
}

class Triangle extends Shape
{
	void draw(){ System.out.println("Draw Three Lines"); }
}

class Line extends Shape
{
	void draw(){ System.out.println("Draw Line"); }
}