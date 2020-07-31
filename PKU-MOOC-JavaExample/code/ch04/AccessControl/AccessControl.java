package p2;

class Derived extends p1.Original{
	void Access( ){
		System.out.println("**** 不同包中的子类 ****");
		// System.out.println("friendly member "+n_friendly);//不能访问
		// System.out.println("private member "+n_private);//不能访问
		System.out.println("protected member "+n_protected);//子类可以访问父类
		System.out.println("public member "+n_public);
		
		p1.Original o = new p1.Original( );
		System.out.println("**** 访问在不同包中的父类 ****");
		// System.out.println("friendly member "+o.n_friendly);//不能访问
		// System.out.println("private member "+o.n_private);//不能访问
		// System.out.println("protected member "+o.n_protected);//不能访问
		System.out.println("public member "+o.n_public);
	}
}

class AnotherPackageClass{
	void Access( ){
		p1.Original o = new p1.Original( );
		System.out.println("**** 另一包中的其他类 ****");
		// System.out.println("friendly member "+o.n_friendly);//不能访问
		// System.out.println("private member "+o.n_private);//不能访问
		// System.out.println("protected member "+o.n_protected);//不能访问
		System.out.println("public member "+o.n_public);
	}
}

public class AccessControl{
	public static void main( String args[ ] ){
		Derived d = new Derived( );
		d.Access( );
		AnotherPackageClass a = new AnotherPackageClass( );
		a.Access( );
	}
}
