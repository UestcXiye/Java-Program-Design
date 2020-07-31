class TestCleanUp{
  public static void main(String[] args) {
    PolyLine x = new PolyLine(47);
    try {
      // Code and exception handling...
    } finally {
      x.cleanup();
    }
  }
} 

class Shape {
  Shape(int i) {
    System.out.println("Shape constructor");
  }
  void cleanup() {
    System.out.println("Shape cleanup");
  }
}

class Line extends Shape {
  private int start, end;
  Line(int start, int end) {
    super(start);
    this.start = start;
    this.end = end;
    System.out.println("Drawing a Line: " +
           start + ", " + end);
  }
  void cleanup() {
    System.out.println("Erasing a Line: " +
           start + ", " + end);
    super.cleanup();
  }
}

class PolyLine extends Shape {
  private Line[] lines = new Line[10];
  PolyLine(int i) {
    super(i + 1);
    for(int j = 0; j < 10; j++)
      lines[j] = new Line(j, j*j);
    System.out.println("PolyLine constructor");
  }
  void cleanup() {
    System.out.println("PolyLine.cleanup()");
    for(int i = 0; i < lines.length; i++)
      lines[i].cleanup();
    super.cleanup();
  }
}

