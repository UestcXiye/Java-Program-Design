package pkumooc;

import java.util.Stack;

/**
 * @author liuwenchen
 * @create 2020-07-09 20:39
 */
public class TestStack {
    static String[] months=new String[]{"January","February","March","April","May","June",
        "July","August","September","October","November","December"};

    public static void main(String[] args) {
        Stack<String> stringStack=new Stack<>();
        for(int i=0;i<months.length;i++) stringStack.push(months[i]);
        System.out.println("stringStack = " + stringStack);
        System.out.println("Poping elements: ");
        while(!stringStack.empty()) System.out.println(stringStack.pop());
    }
}