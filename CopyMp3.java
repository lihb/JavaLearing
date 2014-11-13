/**
 * ClassName:     CopyMp3
 * description:   intro the class
 * Author:        lhb
 * Date:         2014-08-05 10:08:36
 * Version:		 1.0
 *
 */
import java.util.*;
import java.io.*;
 public class  CopyMp3 {
    public static void main(String[] args){
        InputStream   in = null ;
	    OutputStream  out = null;
	    File f1 = new File("D:"+File.separator+"source"+File.separator+"forget.mp3");
	
   try {
	in = new  FileInputStream(f1);
	byte[] b =new byte[1024];
	int length = 0;
	while((length=in.read(b))!=-1){
		  System.out.println(length);
		  out = new FileOutputStream("D:"+File.separator+"source"+File.separator+"forget01.mp3");
		  out.write(b, 0, length);
		
		  
		
	}
} catch (FileNotFoundException e) {
	
	e.printStackTrace();
}
   finally{
	   System.out.println("结束");
	   out.flush();
	   in.close();
	   out.close();
   }
        
        	
    	
} 
 }

