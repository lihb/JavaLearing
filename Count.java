/*
 *Author:   lhb
 *File:     count.java
 *Date:     14-03-14 21:06:31
 *统计一个文件中某个字符串出现的总次数
 *思路；BufferedReader按行读取，题目转化为求一个字符串中某个子字符串出现的次数
 *从而有2种方法：
 *             （1）主串中每子字符串长度个子串和那个子串比较，主串递增。
 *             （2）利用正则表达式
 */

import java.io.*;
import java.util.regex.*;

public class Count{
	public static void main(String[] args){
		FileReader fr=null;
		BufferedReader bufr=null;
		int num = 0;
		try{
			fr = new FileReader(new File("test.txt"));
			bufr = new BufferedReader(fr);
			String str = "cat";
			String line;
			while((line=bufr.readLine())!=null){
				num += getNumOfLine(line,str);
				//System.out.println("#######");
			}

		}catch(Exception e){
			throw new RuntimeException();
		}finally{
			try{			
				fr.close();
				bufr.close();
			}catch(Exception ex){
				throw new RuntimeException();				
			} 
		} 	
		System.out.println(num);
	} 

	public static int getNumOfLine(String line, String str){
		
		int num = 0;
		/* 法一*/
		//for(int i = 0; i < line.length()-2; i++){
		//	String temp = line.substring(i,i+3);
		//	System.out.println(temp);
		//	if(temp.equals(str)){
		//		num++;
		//	}
		//}
		/*法二 正则*/
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(line);

		while(m.find()){
			num++;
		}
		
		return num;

	}
}

