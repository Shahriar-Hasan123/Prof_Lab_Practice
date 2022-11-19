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
			  String readLine = inputBuffer.readLine();
			  String newReadLine[] = readLine.split(",");
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
			  String readLine = inputBuffer.readLine();
			  System.out.println(readLine);
			  String newReadLine[] = readLine.split(",");
			  Random random = new Random();
			  int randomInt = random.nextInt();
			  System.out.println(newReadLine[randomInt]);
			} catch (Exception e){}
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");			
			try {
			  BufferedWriter inputBuffer = new BufferedWriter(
					new FileWriter("students.txt", true));
			  String argsSubString = args[0].substring(1);
			  Date date = new Date();
			  String dateForm = "dd/mm/yyyy-hh:mm:ss a";
			  DateFormat dateFormat = new SimpleDateFormat(dateForm);
			  String formatDate= dateFormat.format(date);
			  inputBuffer.write(", "+argsSubString+"\nList last updated on "+formatDate);
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
			  String readLine = inputBuffer.readLine();
			  String newReadLine[] = readLine.split(",");
			  boolean done = false;
			  String argsSubString = args[0].substring(1);
			  for(int index = 0; index<newReadLine.length && !done; index++) {
				if(newReadLine[index].equals(argsSubString)) {
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
			  String readLine = inputBuffer.readLine();
			  char charRead[] = readLine.toCharArray();
			  boolean in_word = false;
			  int count=0;
			  for(char index:charRead) {
				if(index ==' ') {
					if (!in_word) {
						count++; in_word =true;
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