/*
 *Author:   lhb
 *File:     SocketDemo.java
 *Date:     14-03-14 16:13:10
 *客户端输入任意的字符，服务端将其转换成大写，返回给给客户端。
 *注意：1.在用BufferedWriter和BufferedoutPutStream写入数据后，须调用flush()方法将数据写出。
 *		  那是否都一定要调用flush()方法呢，答案是：不一定。只要你能保证你写的所有数据都能大于8KB。
 *        如不能保证，请调用flush()方法。
 *      2.BufferedWriter特有的newLine()方法，产生一个换行标记，否则BufferedReader的readLine()方法读不到换行标记，会一直在那等着。
 *总结：谨慎起见，还是调用flush()方法为妙，另close()方法也会调用flush()方法。
 *详情参见：http://blog.csdn.net/veryitman/article/details/6460726    
 */

import java.util.*;
import java.net.*;
import java.io.*;

class SocketClient{
	public static void main(String[] args)throws Exception{
	
		Socket s = new Socket("192.168.0.103",10000);
		
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

		//获得socket输入流
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

		//获得socket输出流
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		//PrintWriter out = new PrintWriter(s.getOutputStream(),true);

		String line = bufr.readLine();
		while(true){		
			if(line.equals("stop"))
				break;
			System.out.println("Client:::::"+line);
			bufw.write(line);
			bufw.newLine();
			bufw.flush(); //attention
			//out.println(line);
			String info = bufIn.readLine();
			System.out.println("Server:::"+info);
			line = bufr.readLine();
		}
		bufr.close();
		bufIn.close();
		bufw.close();
		//out.close();
		System.out.println();
	} 
}

class Server{
	
	public static void main(String[] args)throws Exception{
		
		ServerSocket ss = new ServerSocket(10000);
		Socket s = ss.accept();

		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+".... connected!");
		//获得socket输入流
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

		//获得socket输出流
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		//PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		String line=bufIn.readLine();

		while(true){
				
			if(line.equals("stop"))
				break;
			System.out.println(line);
			bufw.write(line.toUpperCase());
			bufw.newLine();
			bufw.flush();//attention
			//out.println(line.toUpperCase());
			line=bufIn.readLine();
		}
		bufIn.close();
		bufw.close();
		//out.close();

	} 
}
