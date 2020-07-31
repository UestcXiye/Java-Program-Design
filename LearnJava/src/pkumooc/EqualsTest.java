package pkumooc;

/**
 * @author liuwenchen
 * @create 2020-07-09 18:34
 */
public class EqualsTest {
    public static void main(String[] args) {
        Integer one =new Integer(1);
        Integer anotherone=new Integer(1);

        if(one==anotherone)
            System.out.println("true");
        else
            System.out.println("false");
        if(one.equals(anotherone))
            System.out.println("true");
        else
            System.out.println("false");
    }
}