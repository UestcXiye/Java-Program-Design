class LambdaRunnable  {
    public static void main(String argv[]) {
		Runnable doIt =  new Runnable(){
			public void run(){ 
				System.out.println("aaa");
			}
		};
		new Thread( doIt ).start();

		Runnable doIt2 = ()->System.out.println("bbb");
		new Thread( doIt2 ).start();

		new Thread( ()->System.out.println("ccc") ).start();
		
    }
}
