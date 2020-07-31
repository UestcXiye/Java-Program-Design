package pkumooc;

import java.util.Date;

/**
 * @author liuwenchen
 * @create 2020-07-10 0:13
 */
public class GenericMethod {
    public static void main(String[] args) {
        Date date=BeanUtil.<Date>getInstance("java.util.Date");
        System.out.println(date);
    }
}
class BeanUtil
{
    public static <T> T getInstance(String clzName)
    {
        try {
            Class c=Class.forName(clzName);
            return (T) c.newInstance();
        }catch (ClassNotFoundException e){}
         catch (InstantiationException e){}
         catch (IllegalAccessException e){}
        return null;
    }
}