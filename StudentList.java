import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

//		Check arguments
		if(args.length>1||args.length<1){
			System.err.println("Invalid number of argument");
			System.err.println("Exiting programme");
			System.exit(1);
		}
		else if(args[0].equals("a")) {
			System.out.println("Loading data ...");
		    try {
			  BufferedReader inputBuffer = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt")));
			  String newReadLine[] = inputBuffer.readLine().split(",");
			  for(String  index: newReadLine) {
				 System.out.println(index);
			  }
		    } catch (Exception e){}
		    System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) {
			System.out.println("Loading data ...");			
			try {
			  BufferedReader inputBuffer = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt")));
			  System.out.println(inputBuffer.readLine());
			  String newReadLine[] = inputBuffer.readLine().split(",");
			  System.out.println(newReadLine[new Random().nextInt()]);
			} catch (Exception e){}
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");			
			try {
			  BufferedWriter inputBuffer = new BufferedWriter(
					new FileWriter("students.txt", true));
			  String formatDate= new SimpleDateFormat("dd/mm/yyyy-hh:mm:ss a").format(new Date());
			  inputBuffer.write(", "+args[0].substring(1)+"\nList last updated on "+formatDate);
			  inputBuffer.close();
			} catch (Exception e){}
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) 
		{
			System.out.println("Loading data ...");
			try {
			  BufferedReader inputBuffer= new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt")));
			  String newReadLine[] = inputBuffer.readLine().split(",");
			  boolean done = false;
			  for(int index = 0; index<newReadLine.length && !done; index++) {
				if(newReadLine[index].equals(args[0].substring(1))) {
					System.out.println("We found it!");
						done=true;
			    }
			  }
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) {
			System.out.println("Loading data ...");			
			try {
			  BufferedReader inputBuffer = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt")));
			  char charRead[] = inputBuffer.readLine().toCharArray();
			  boolean in_word = false;
			  int count=0;
			  for(char index:charRead) {
				if(index ==' ') {
					if (!in_word) {
						count++;
						in_word =true;
					}
					else {
						in_word=false;
					}
				}
			  }
			  System.out.println(count +" word(s) found " + charRead.length);
			} catch (Exception e) {}
			System.out.println("Data Loaded.");				
		}
		else
		{
			System.err.println("Invalid number of argument");
			System.err.println("Exiting programme");
			System.exit(1);
		}
	}
}