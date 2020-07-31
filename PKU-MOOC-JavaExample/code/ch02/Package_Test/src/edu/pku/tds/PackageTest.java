package edu.pku.tds;

import edu.pku.tds.util.MathUtil;
import edu.pku.tds.ui.*;

public class PackageTest
{
	public static void main( String [] args ){
		
		double x = edu.pku.tds.util.MathUtil.add( 5, 3 );

		ConsoleUI.show( "x=" + x );
	}
};