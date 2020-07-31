class StringSplit 
{
	public static void main(String[] args) 
	{
		String s = "Beijing, Shanghai; Chengdu  Haikou";
		String [] words = s.split( "([,;]|\\s)\\s*");
		for(String w : words ) System.out.println(w);
	}
}
