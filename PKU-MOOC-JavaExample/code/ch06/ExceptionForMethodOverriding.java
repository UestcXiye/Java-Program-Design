import java.io.*;

class A {
	public void methodA() throws IOException {
		  //бнбн
	}
}

class B1 extends A {
	public void methodA() throws FileNotFoundException {
		  //бнбн
	}
}

class B2 extends A {
	public void methodA() throws Exception {  // Error!
		  // бнбн
	}
}
