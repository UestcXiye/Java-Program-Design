class TestStaticInvoke
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
		
		Shape s = new Circle();
		doStuff(s);
		s.draw();
		
		Circle c2 = new Circle();
		c2.draw();
	}
}
class Shape
{
	static void draw(){ System.out.println("Shape Drawing"); }
}
class Circle extends Shape
{
	static void draw(){ System.out.println("Draw Circle"); }
}

class Triangle extends Shape
{
	static void draw(){ System.out.println("Draw Three Lines"); }
}

class Line extends Shape
{
	static void draw(){ System.out.println("Draw Line"); }
}