import java.lang.annotation.*;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;
import java.util.Date;

// define annotation
@Target(ElementType.METHOD) //can be used for method
@Retention(RetentionPolicy.RUNTIME) //can be read by reflection
@Documented  //  javadoc will use this 
@interface DebugTime{
	boolean value() default true;
	long timeout() default 100;
	String msg();
	int [] other() default {};
}



// use annotation
class MyClass
{
	@DebugTime(value=true, timeout=10, msg="too slow", other={1,2,3} )
	public double fibonacci(int n){
		if(n==0||n==1) return 1; 
		else return fibonacci(n-1)+fibonacci(n-2);
	}
}

// read annotation at run time
class  DebugTool
{
	public static void main(String[] args) throws NoSuchMethodException
	{
		MyClass obj = new MyClass();
		Class clz = obj.getClass();

		//show all annotations 
		for(Method m : clz.getDeclaredMethods() ){
			System.out.println( m );
			for(Annotation ann : m.getAnnotations() ){
				System.out.println( ann.annotationType().getName() );
			}
		}

		Method method = clz.getMethod("fibonacci", int.class);
		System.out.println( method );

		if( method.isAnnotationPresent(DebugTime.class)){
			DebugTime debug = method.getAnnotation(DebugTime.class);
			
			//get properties of the annotation
			boolean requireDebug = debug.value();
			long timeout = debug.timeout();
			if( requireDebug ){
				Date t0 = new Date();
				double fib = obj.fibonacci(40);
				Date t1 = new Date();
				long time = t1.getTime()-t0.getTime();
				System.out.println("time used: "+time);
				if( time > timeout ){
					System.out.println( debug.msg() );
				}
			}
		}
	}
}


