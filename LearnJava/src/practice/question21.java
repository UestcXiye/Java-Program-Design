package practice;

/**
 * @author liuwenchen
 * @create 2020-07-03 10:32
 * 问题描述：两个乒乓球队进行比赛，各出三人。甲队为a,b,c三人，乙队为x,y,z三人。已抽签决定比赛名单。
 * 有人向队员打听比赛的名单。a说他不和x比，c说他不和x,z比，请编程序找出三队赛手的名单。
 */
public class question21 {
    public static void main(String[] args) {
        String[] racer=new String[] {"x","y","z"};
        String a,b,c;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                for(int k=0;k<3;k++)
                {
                    if(i!=j && i!=k && j!=k)
                    {
                        a=racer[i];
                        b=racer[j];
                        c=racer[k];
                        if(!a.equals("x") && !c.equals("x") && !c.equals("z"))
                            if(a.equals(racer[i]) && b.equals(racer[j]) && c.equals(racer[k]))
                                System.out.println("a的对手是："+racer[i]+"，b的对手是："+racer[j] +"，c的对手是："+racer[k] );
                    }
                }
            }
        }
    }
}
