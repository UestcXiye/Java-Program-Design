package practice;

import java.util.Scanner;

/**
 * @author liuwenchen
 * @create 2020-07-02 12:53
 * 问题描述：企业发放的奖金根据利润提成。利润低于或等于10万元时，奖金可提10%；
 * 利润高于10万元，低于20万元时，低于10万元的部分按10%提成，高于10万元的部分，可提成7.5%；
 * 20万到40万之间时，高于20万元的部分，可提成5%；
 * 40万到60万之间时高于40万元的部分，可提成3%；
 * 60万到100万之间时，高于60万元的部分，可提成1.5%；
 * 高于100万元时，超过100万元的部分按1%提成。
 * 从键盘输入当月利润I，求应发放奖金总数？
 */
public class question15 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double profit=scanner.nextDouble();
        double bonus=0.0;
        if (profit<=10) bonus=profit*0.1;
        else if(profit<=20) bonus=(profit-10)*0.075+1;
        else if(profit<=40) bonus=(profit-20)*0.05+1.75;
        else if(profit<=60) bonus=(profit-40)*0.03+2.75;
        else if(profit<=100) bonus=(profit-60)*0.015+3.35;
        else bonus=(profit-100)*0.01+3.95;
        System.out.println(profit+"万元利润，可以获得"+bonus+"万元提成");
    }
}
