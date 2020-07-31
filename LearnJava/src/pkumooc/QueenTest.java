package pkumooc;

/**
 * @author liuwenchen
 * @create 2020-07-10 1:08
 */
public class QueenTest {
    public static void main(String[] args) {
        Queen8 queen8 = new Queen8(8);
        queen8.placeQueens(0);
        doubleArrayOutput(queen8.getX());
    }
    public static void doubleArrayOutput(int []array) {
        int QueenArray[][] = new int[array.length][array.length];
        for (int i = 0; i < array.length; i++) {
            QueenArray[i][array[i]] = 1;
        }

        for (int i = 0; i < QueenArray.length; i++) {
            for (int j = 0; j < QueenArray.length; j++) {
                System.out.print(QueenArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
class Queen8 {
    private int lens ;
    private int []x;
    private boolean flag = false;

    public Queen8(int lens) {
        super();
        this.lens = lens;
        x = new int [lens];
    }

    public boolean placeQueens(int num) {
        if (num != lens) {//如果等于 说明全部排好
            for (int i = 0; i < x.length; i++) {//新皇后要放置的列
                //如果超过说明在之前排列的情况下已经无法排列，这是结束本次方法调用从新测试 上一个方法调用时的情况
                int j;
                for (j = 0; j < num; j++) {
                    if (i == x[j] || i-num == x[j]-j || num+i == j+x[j]) {//但凡竖直，正反对角线 有一条不满足则跳出
//						System.out.println(" wrong!   j = " + j);
                        break;
                    }
                }
                if (j == num ) {//说明在该 i 列的情况下 排列不冲突 则排下一个皇后
                    x[num] = i;
//					System.out.println(num + "  x[num]: " + x[num] + "\n");
                    flag = placeQueens(num + 1);
                }
                if (flag) {
                    return true;
                }
            }
        }else {
            return true;
        }
        return false;
    }

    public int[] getX() {
        return x;
    }
}