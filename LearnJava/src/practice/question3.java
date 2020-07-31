package practice;

/**
 * @author liuwenchen
 * @create 2020-07-01 21:25
 * 问题描述：求出自然数101~199中的所有素数
 */
public class question3 {
    public static void main(String[] args) {
        int[] a = new int[100];
        int n = 0;
        loop:
        for (int i = 101; i <= 199; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) continue loop;
            }
            a[n] = i;
            n++;
        }
        System.out.printf("101~199中的所有素数: ");
        for (int i = 0; i < n; i++) System.out.printf(a[i] + " ");
    }
}
