package pkumooc;

/**
 * @author liuwenchen
 * @create 2020-07-10 0:32
 */
public class Sqrt {
    public static void main(String[] args) {
        System.out.println(sqrt(98.0));;
        System.out.println(Math.sqrt(98.0));
    }

    private static double sqrt(double v) {
        double x=1.0;
        do{
            x=(x+v/x)/2;
            System.out.println(x+" , "+v/x);
        }while(Math.abs(x*x-v)/v > 1e-6);
        return x;
    }
}