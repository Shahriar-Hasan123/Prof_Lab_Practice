import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static String readFile() throws Exception{
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(new FileInputStream(Constants.StudentFileName)));
		return bufferedReader.readLine();
	}
	public static BufferedWriter writeFile()throws Exception{
		return new BufferedWriter(new FileWriter(Constants.StudentFileName, true));
	}
	public static void main(String[] args) {
		//		Check Validity of arguments
		if(args.length!=1){
			System.err.println(Constants.InvalidMsg);
			System.err.println(Constants.ExitMsg);
			System.exit(Constants.InvalidArgStatus);
		}
		//		Check arguments
		if(args[0].equals(Constants.ListOfData)) { //List data arguments.
			System.out.println(Constants.LoadingMsg);
		    try {
			  for(String  index: readFile().split(Constants.WordSplitRegex)) {
				 System.out.println(index);
			  }
		    } catch (Exception e){}
		    System.out.println(Constants.LoadedMsg);
		}
		else if(args[0].equals(Constants.RandomData)) {//Show random data arguments.
			System.out.println(Constants.LoadingMsg);
			try {
			  System.out.println(readFile());
			  String newReadLine[] = readFile().split(Constants.WordSplitRegex);
			  System.out.println(newReadLine[new Random().nextInt()]);
			} catch (Exception e){}
			System.out.println(Constants.LoadedMsg);
		}
		else if(args[0].contains(Constants.AddData)){//Add data arguments.
			System.out.println(Constants.LoadingMsg);
			try {
			  String formatDate= new SimpleDateFormat(Constants.DataFormatePattern).format(new Date());
			  writeFile().write(Constants.WordSplitRegex+args[0].substring(Constants.InvalidArgStatus)+Constants.UpdatedMsg+formatDate);
			  writeFile().close();
			} catch (Exception e){}
			System.out.println(Constants.LoadedMsg);
		}
		else if(args[0].contains(Constants.FindData)) {//Find data arguments.
			System.out.println(Constants.LoadingMsg);
			try {
				  if(Arrays.asList(readFile().split(Constants.WordSplitRegex)).contains(args[0].substring(1))) {
					System.out.println(Constants.DataFoundMsg);
				  }
			}
			catch (Exception e){}
			System.out.println(Constants.LoadedMsg);
		}
		else if(args[0].contains(Constants.CountData)) {//Count data arguments.
			System.out.println(Constants.LoadingMsg);
			try {
			  char charRead[] = readFile().toCharArray();
			  int count=0;
			  for(char index:charRead) {
				  if(index ==' ')
					  count=count+1;
			  }
			  System.out.println((count / 2 + count % 2) + Constants.WordFoundMsg + charRead.length);
			} catch (Exception e) {}
			System.out.println(Constants.LoadedMsg);
		}
		else
		{
			System.err.println(Constants.InvalidMsg);
			System.err.println(Constants.ExitMsg);
			System.exit(Constants.InvalidArgStatus);
		}
	}
}