/**
 * Author: Johnny Zheng 
 * Date: 3/6/2022
 * 
 * Exercise12_12Test is the test class for Exercise12_12
 */


import static org.junit.Assert.*;
import java.util.*;
import java.io.*;
import org.junit.Test;

public class Exercise12_12Test {

  @Test
  public void test() throws Exception {
    
    Exercise12_12.main(new String[]{"javaTestFile.java"});
    String actual = returnFile("javaTestFile.java");
    String expected = "public class javaTestFile {\r\n"
        + "  public static void main(String[] args) {\r\n"
        + "    System.out.print(\"\");\r\n"
        + "  }\r\n"
        + "}";
    assertEquals(actual, expected);
    
  }
  
  public String returnFile(String file) {
    String fileContent = "";
    Scanner reader = new Scanner(file);
    while (reader.hasNext()) {
      fileContent = reader.nextLine();
    }
    reader.close();
    
    return fileContent;
  }

}
