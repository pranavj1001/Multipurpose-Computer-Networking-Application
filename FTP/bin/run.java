import java.lang.Runtime;
import  java.io.IOException;

public class run{

	public static void main(String args[]){
	
		try{

			Process run = Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"ftpd.bat config.xml\"");
			
			}catch(IOException ioe){
			
			System.out.println("error");
			
			}

	}
	
}