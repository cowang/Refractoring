/**
 * Author: Johnny Zheng & George Cowan
 * Date: 3/6/2022
 * 
 * Exercise12_12 takes in a file as an argument and moves the start of line braces of the file to the end of the previous line
 * 
 * I added 4 methods to make the program more readable. 
 * This change transforms the main method from big sections of code to smaller sections of statements and method calls. 
 * I also like to have plenty of empty lines between sections of code to further increase readability.
 * The name of every method added is concise and explains what the method does. 
 */
import java.util.*;
import java.io.*;

public class Exercise12_12 {
  /**Main method*/
  public static void main(String[] args) throws Exception {
    
    commandLineCheck(args); // Check command line parameter usage
    File sourceFile = sourceFileCheck(args); // Check if source file exists
    
    StringBuilder buffer = new StringBuilder();
    Scanner input = new Scanner(sourceFile);
    
    while (input.hasNext()) {
      String s = input.nextLine();
      String s1 = s.trim();
      moveBraces(buffer, s, s1);
    }
    input.close();
    
    writeToFile(sourceFile, buffer); // Write buffer into the file
  }

  /* writeToFile
   * Replaces file content with buffer
   * @param sourceFile: File name
   * @param buffer: Stringbuilder storing new file content
   */
  public static void writeToFile(File sourceFile, StringBuilder buffer)
      throws FileNotFoundException {
    PrintWriter output = new PrintWriter(sourceFile);
    output.print(buffer.toString());
    output.close();
  }

  /* moveBraces
   * Moves start of line braces to end of the previous line
   * @param  buffer: Stringbuilder storing new file content
   * @param s: A line of code in the source file
   * @param s1: A line of trimmed code in the source file
   */
  public static void moveBraces(StringBuilder buffer, String s, String s1) {
    if (s1.charAt(0) == '{') {
      buffer.append(" {");
      if (s1.length() > 1) 
        buffer.append("\r\n" + s.replace('{', ' '));
    }
    else
      buffer.append("\r\n" + s);
  }

  /* sourceFileCheck
   * Checks to see if the source file exists
   * @param args: Argument for the main method
   * @return sourceFile: The file name
   */
  public static File sourceFileCheck(String[] args) {
    File sourceFile = new File(args[0]);
    if (!sourceFile.exists()) {
       System.out.println("Source file " + args[0] + " not exist");
       System.exit(2);
    }
    return sourceFile;
  }

  /* commandLineCheck
   * Checks if there is exactly one command line argument
   * @param args: Argument for the main method
   */
  public static void commandLineCheck(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: java Exercise12_12 filename");
      System.exit(1);
    }
  }
}