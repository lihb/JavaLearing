/*
 *Author:   lhb
 *File:     CopyMovie.java
 *Date:     14-03-06 17:54:33
 *将f:\moive文件夹的CD4.avi电影拷贝到d:盘
 */

import java.util.*;
import java.io.*;

public class CopyMovie{
	public static void main(String[] args) throws IOException{
		long start = System.currentTimeMillis();
		copy();
		//copy2();
		long end = System.currentTimeMillis();
		
		System.out.println("花费时间："+(end-start)/1000+"s");
	}

	public static void copy()throws IOException{

		File file = new File("F:\\Moive\\Click.mkv");
		
		System.out.println("文件大小："+file.length()/1024/1024+"MB"); 
		System.out.println(file);
		BufferedInputStream bufIn = 
			new BufferedInputStream(new FileInputStream(file));

		BufferedOutputStream bufOut = 
			new BufferedOutputStream(new FileOutputStream("d:\\Click.mkv"));
		
		int len = 0 ;
		
		while((len=bufIn.read())!=-1){
			bufOut.write(len);
		}
		bufIn.close();
		bufOut.close();
	}
	
	public static void copy2()throws IOException{
		
		File file = new File("F:\\Moive\\Click.mkv");
		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream("e:\\click.mkv");

		int len = 0;

		while((len = fis.read())!=-1){
			fos.write(len);
		}
		fis.close();
		fos.close();
	


	}
}

