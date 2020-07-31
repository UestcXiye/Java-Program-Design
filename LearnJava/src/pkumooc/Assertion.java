package pkumooc;
/**
 * @author liuwenchen
 * @create 2020-07-09 18:04
 */
public class Assertion {
    public static void main(String[] args) {
        assert hypotenuse(3,4)==5 : "算法不正确";
    }
    static double hypotenuse(double x,double y) {
        return Math.sqrt(x*x+y*y+1);
    }
}
/**
 * 如果使用断言，编译器默认是禁止运行断言的。要启用断言，必须使用java的-ea或-enableassertions参数。
 * 代码编译：javac Assertion.java
 * 代码运行：java -ea Assertion
 */