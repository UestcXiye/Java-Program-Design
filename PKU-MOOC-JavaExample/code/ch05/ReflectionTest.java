import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

public class ReflectionTest
{
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args)throws Exception
    {
        
       // 1. 得到该对象所对应的Class对象
       Class<DemoTest2> clazz = DemoTest2.class;
        
       //2. 通过该Class对象得到该类的构造方法所对应的Constructor对象
        Constructor cons = clazz.getConstructor(new Class[]{String.class, String.class});
                
        //3. 通过该Constructor对象的newInstance方法得到该类的一个实例（对象）
        DemoTest2 obj = (DemoTest2)cons.newInstance(new Object[]{"abc","xyz"});
       
        //4. 通过该Class对象得到该方法所对应的Method对象
        Method method = clazz.getDeclaredMethod("output",new Class[]{String.class});
        
        //5. 通过该Method对象的invoke方法进行调用
        method.invoke(obj,new Object[]{"zhangsan"});
        
        //属性也类似
		Field field = clazz.getDeclaredField("x");
		field.setAccessible(true);//甚至可以访问private的属性或方法
		field.set(obj, 6);

    }
}

class DemoTest2
{
	private int x = 5;
	public DemoTest2(String s1, String s2)
    {
        System.out.println(s1);
        System.out.println(s2);
    }
    
    void output(String str)
    {
        System.out.println("hello: " + str);
    }

}