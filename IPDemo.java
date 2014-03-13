import java.net.*;
/*
 *IP地址对象：InetAddress
 *获取百度服务器的ip地址。
 */
public class IPDemo{
	
	public static void main(String[] args) throws UnknownHostException{
		
		InetAddress[] ia = InetAddress.getAllByName("www.baidu.com");

		for(InetAddress addr:ia){
			System.out.println(addr.toString());
		}
	} 
}
