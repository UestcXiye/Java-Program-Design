import java.util.*;

/** A Simple Java example program.
 * @(#)HelloDate.java	1.5 98/07/09
 *
 * Displays a string and today's date.
 * @author Bruce Eckel
 * @author www.BruceEckel.com
 * @version 2.0
 */
public class HelloDate {

  /** Sole entry point to class & application
   * @param args array of string arguments
   * @return No return value
   * @throws exceptions No exceptions thrown
  */
  public static void main(String[] args) {
    System.out.println("Hello, it's: ");
    System.out.println(new Date());
  }
}
