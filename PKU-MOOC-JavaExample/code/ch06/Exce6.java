class MyException extends Exception {
   	private int idnumber;
 	public MyException(String message, int id) {
		super(message);
		this.idnumber = id;
 	} 
	public int getId() {
		return idnumber;
 	}
}

public class Exce6{
    public void regist(int num) throws MyException {
 	    if(num < 0) {
   			  System.out.println("登记号码" + num );
 	          throw new MyException("号码为负值，不合理",3);
 	    }
    }
    
	public void manager() {
 	    try {
	        regist(-100);
 	    } catch (MyException e) {
 	        System.out.println("登记失败，出错种类" + e.getId());
	    }
	    System.out.println("本次登记操作结束");
    }
    
	public static void main(String args[]){
	    Exce6 t = new Exce6();
	    t.manager();
    }
}
