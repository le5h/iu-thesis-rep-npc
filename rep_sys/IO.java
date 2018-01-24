package rep_sys;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class IO {

	public static Scanner sinScanner = new Scanner(System.in);
	
	// read file
	public static String readFile(String filename){
		String input = "";
		try {
			File inputFile = new File(filename);
		    Scanner scnInp = new Scanner(inputFile);
		    StringBuilder strBld = new StringBuilder();
		    while(scnInp.hasNextLine()){ strBld.append((scnInp.nextLine()+"\n")); }
		    input = strBld.toString();
			scnInp.close();
		} catch (FileNotFoundException e) {
			Logger.log(e.getMessage());
			// e.printStackTrace();
		}
	    return input;
	}
	
	// lines
	public static String[] lines(String filename) {
		return readFile(filename).split("\n");
	}
	
	// write file
	public static void writeFile(String filename, String result){
		try {
			File outputFile = new File(filename);
	    	Files.write(outputFile.toPath(), result.getBytes());
	    } catch (IOException e) { e.printStackTrace(); }
	}
	
	// console input waiter
	public static String waitInput(String message){
		if(message!=null) System.out.print(message);
		return sinScanner.nextLine();
	}
	
	// output to console
	public static void print(String output){ System.out.println(output); }
	
}
