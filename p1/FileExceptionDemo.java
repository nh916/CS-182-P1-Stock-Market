/*
Read a text file and display it.
Example of Scanner, String.split(...), file exception handling

Mike Barnes
1/28/2018
*/

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class FileExceptionDemo {

   public void parseLine(String line) {
      int i, n;
      String [] word = line.split("\\s"); 
      System.out.printf("Line has %2d tokens \t", word.length);
      for(i = 0; i < word.length; i ++)
         System.out.print(word[i] + " ");
      System.out.println();
      }   
         
   public FileExceptionDemo() {
      Scanner inFile = null, keyboard = new Scanner(System.in);
      String fileName;
      do {
         System.out.print("Enter file to read: (try terence.txt) ");
         fileName = keyboard.next();
      try { // to attach a file to inFile
         inFile = new Scanner(new FileInputStream(fileName));
         }
      catch (FileNotFoundException e) { // handle file not found
         System.out.println("error: file \"" + fileName +
            "\" not found. Please try again with: \"terence.txt\" ");
         }
         } while (inFile == null);
      System.out.println();
      System.out.println("Processing file:  " + fileName);
      System.out.println();
      String line = null;
      int count = 0;
      while(inFile.hasNextLine()) {
         count++;
         line = inFile.nextLine();
         parseLine(line);
         }
      }

   public static void main(String [] args) {
      FileExceptionDemo app = new FileExceptionDemo();
      }

   }