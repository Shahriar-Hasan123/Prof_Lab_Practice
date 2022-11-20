import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

//		Check arguments
		if(args.length>1||args.length<1){
			System.err.println(Constants.StudentFileName);
			System.err.println(Constants.ExitMsg);
			System.exit(Constants.InvalidArgStatus);
		}
		else if(args[0].equals(Constants.ListOfData)) {
			System.out.println(Constants.LoadingMsg);
		    try {
			  BufferedReader inputBuffer = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(Constants.StudentFileName)));
			  String newReadLine[] = inputBuffer.readLine().split(Constants.WordSplitRegex);
			  for(String  index: newReadLine) {
				 System.out.println(index);
			  }
		    } catch (Exception e){}
		    System.out.println(Constants.LoadedMsg);
		}
		else if(args[0].equals(Constants.RandomData)) {
			System.out.println(Constants.LoadingMsg);
			try {
			  BufferedReader inputBuffer = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(Constants.StudentFileName)));
			  System.out.println(inputBuffer.readLine());
			  String newReadLine[] = inputBuffer.readLine().split(Constants.WordSplitRegex);
			  System.out.println(newReadLine[new Random().nextInt()]);
			} catch (Exception e){}
			System.out.println(Constants.LoadedMsg);
		}
		else if(args[0].contains(Constants.AddData)){
			System.out.println(Constants.LoadingMsg);
			try {
			  BufferedWriter inputBuffer = new BufferedWriter(
					new FileWriter(Constants.StudentFileName, true));
			  String formatDate= new SimpleDateFormat(Constants.DataFormatePattern).format(new Date());
			  inputBuffer.write(Constants.WordSplitRegex+args[0].substring(Constants.InvalidArgStatus)+Constants.UpdatedMsg+formatDate);
			  inputBuffer.close();
			} catch (Exception e){}
			System.out.println(Constants.LoadedMsg);
		}
		else if(args[0].contains(Constants.FindData))
		{
			System.out.println(Constants.LoadingMsg);
			try {
			  BufferedReader inputBuffer= new BufferedReader(
					new InputStreamReader(
							new FileInputStream(Constants.StudentFileName)));
			  String newReadLine[] = inputBuffer.readLine().split(Constants.WordSplitRegex);
			  boolean done = false;
			  for(int index = 0; index<newReadLine.length && !done; index++) {
				if(newReadLine[index].equals(args[0].substring(1))) {
					System.out.println(Constants.DataFoundMsg);
						done=true;
			    }
			  }
			} catch (Exception e){} 
			System.out.println(Constants.LoadedMsg);
		}
		else if(args[0].contains(Constants.CountData)) {
			System.out.println(Constants.LoadingMsg);
			try {
			  BufferedReader inputBuffer = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(Constants.StudentFileName)));
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
			  System.out.println(count +Constants.WordFoundMsg + charRead.length);
			} catch (Exception e) {}
			System.out.println(Constants.LoadedMsg);
		}
		else
		{
			System.err.println(Constants.StudentFileName);
			System.err.println(Constants.ExitMsg);
			System.exit(Constants.InvalidArgStatus);
		}
	}
}