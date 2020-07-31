import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class BlockMoveGame extends JFrame
{
	final int RC = 4;	// 行列数
	final int N = RC*RC;	// 块的个数
	//数组num用于记录每个按钮上的数字-1
	int []num = new int[N];   
	JButton [] btn = new JButton[N];
	JButton btnStart = new JButton("开始游戏");

	public BlockMoveGame(){
		setTitle( "简单的排块游戏");
		setSize( 300, 350 );
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//程序开始,对数组赋值,并显示按钮文字
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		p1.setLayout( new GridLayout( RC, RC ));
		p2.add( btnStart );
		getContentPane().setLayout( new BorderLayout() );
		getContentPane().add(p1, BorderLayout.CENTER );
		getContentPane().add(p2, BorderLayout.SOUTH );

		Font font = new Font("Times New Rome", 0, 24 );
		for( int i=0; i<N; i++ ){
			num[i] = i;
			btn[i] = new JButton(""+ ( num[i] + 1 ));
			btn[i].setFont(font);
			p1.add(btn[i]);
			btn[i].setVisible( true );
		}
		btn[N-1].setVisible( false ); //数字为N-1的按钮不显示

		btnStart.addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent e){
				btnStart_Click();
			}
		});
		for( int i=0; i<N; i++ ){
			btn[i].addActionListener( new ActionListener(){
				public void actionPerformed( ActionEvent e){
					for( int j=0; j<N; j++ )
						if( (JButton)e.getSource() == btn[j] )
							btn_Click(j);
				}
			});
		}
	}

	public void btnStart_Click(){
		//打乱顺序，开始游戏
		int i,j,k,t; 
		//随机找两个下标,交换其对应的数组元素
		for( i = 1; i<500; i++){ 
			j = (int)(Math.random()* N);  
			k = (int)(Math.random()* N);
			t = num[j]; num[j] = num[k]; num[k] = t;
		}
		
		for( i=0; i<N; i++ ){//显示它们
			btn[i].setText(""+ (num[i] + 1));
			btn[i].setVisible( true );
		}
		i = findBlank();  //其中有一个按钮需要隐藏
		btn[i].setVisible(false);
	}

	//找到哪一个为空位
	int findBlank(){  
		int i;
		for( i=0; i<N; i++ ){ 
			if( num[i] == N-1 ) break; 
		}
		return i; 
	}

	//第Index个按钮的事件处理
	void btn_Click(int index){  
		int blank = findBlank();           //找到空白按钮(隐藏的)
		if( isNeighbor(blank, index)){       //如果相邻
			btn[index].setVisible( false );  //一个隐藏,一个显示
			btn[blank].setVisible( true );   //并交换其上的数字
			int t = num[blank]; 
			num[blank] = num[index]; 
			num[index] = t;
			btn[blank].setText( ""+ (num[blank] + 1));
			btn[index].setText( ""+ (num[index] + 1));
			btn[blank].requestFocus();
		}
		checkResult();  //调用过程,检查是否完成
	}

	//判断是否相邻
	boolean isNeighbor(int a, int b){  
		boolean r; 
		r = false;
		if( a == b - RC || a == b + RC ) 
			r = true;  //上下相邻
		if( (a == b - 1 || a == b + 1) && a / RC == b / RC ) 
			r = true; //左右相邻,注意要在同一排
		return r;
	}
	//检查结果是否完全到位
	void checkResult(){  
		int i;
		for( i=0; i<N; i++ ){     
			if( num[i] != i ) return; 
		}
		JOptionPane.showMessageDialog(this,
			"你赢了!请点击 [开始] 再来一次.");
	}

	public static void main(String... args) {
		SwingUtilities.invokeLater(()->{
			new BlockMoveGame().setVisible(true);
		});
    }
}


