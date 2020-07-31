import java.lang.reflect.*;

public class ClassViewer {
    public static void view(Class clz) throws ClassNotFoundException {
        System.out.println("class name£º" + clz.getName());
        System.out.println("is interface£º" + clz.isInterface());
        System.out.println("is primitive£º" + clz.isPrimitive());
        System.out.println("is array£º" + clz.isArray());
        System.out.println("super class£º" + clz.getSuperclass().getName());

		
        Package p = clz.getPackage();  
        System.out.printf("package %s;%n", p.getName());

        int modifier = clz.getModifiers();   
        System.out.printf("%s %s %s {%n", 
            Modifier.toString(modifier),   
            Modifier.isInterface(modifier) ? "interface" : "class",
            clz.getName() 
        );
           
		//show all fields
        Field[] fields = clz.getDeclaredFields();
        for (Field field : fields) {
            System.out.printf("\t%s %s %s;%n", 
                    Modifier.toString(field.getModifiers()),
                    field.getType().getName(),   
                    field.getName()  
            );
        }

		//show all constructors
        Constructor[] constructors = clz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.printf("\t%s %s( %s );%n", 
                Modifier.toString(constructor.getModifiers()),
                constructor.getName(),
				join(constructor.getParameterTypes())
            );
        }
        
		//show all methods
        Method[] methods = clz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.printf("\t%s %s %s( %s ) throws %s;%n", 
                Modifier.toString(method.getModifiers()),
                method.getReturnType().getName(),
                method.getName(),  
                join(method.getParameterTypes()), 
				join(method.getExceptionTypes()) );
        }
        System.out.println("}");
    }

	static String join( Class<?>[] ary ){
		if( ary==null ) return null;
		StringBuilder sb = new StringBuilder();
		for( int i=0; i<ary.length; i++){
			if( i!=0 ) sb.append(", ");
			sb.append( ary[i].getName() );
		}
		return sb.toString();
	}

    public static void main(String[] args) {
        try {
			view( String.class );
			
			//view( "".getClass() );

			//Class clz = Class.forName("java.lang.String");
            //view(clz);
		}catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
