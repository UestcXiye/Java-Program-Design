package pkumooc;

/**
 * @author liuwenchen
 * @create 2020-07-04 18:17
 */
public class TestVirtualInvoke {
    static void doStuff(Shape s)
    {
        s.draw();
    }

    public static void main(String[] args) {
        Circle c = new Circle();
        TriangleMesh t = new TriangleMesh();
        Line l = new Line();
        doStuff(c);
        doStuff(t);
        doStuff(l);
    }
}

class Shape
{
    void draw()
    {
        System.out.println("Shape Drawing");
    }
}

class Circle extends Shape
{
    @Override
    void draw()
    {
        System.out.println("Draw Circle");
    }
}

class TriangleMesh extends Shape
{
    @Override
    void draw()
    {
        System.out.println("Draw TriangleMesh");
    }
}

class Line extends Shape {
    @Override
    void draw() {
        System.out.println("Draw Line");
    }
}