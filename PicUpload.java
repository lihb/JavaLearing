import java.io.*;
import java.net.*;
/*
 创建一个程序，利用TCP/IP协议，进行图片上传。
 思路：有tcp客户端，tcp服务端
 */
//tcp客户端
class PicClient{
	
	public static void main(String[] args) throws Exception{
	
		//1.创建tcp连接
		Socket s = new Socket(InetAddress.getByName("192.168.0.100"),10001); 
	
		FileInputStream fis = new FileInputStream(new File("test.jpg"));

		OutputStream out = s.getOutputStream();

		byte[] buf = new byte[1024];
		int len = 0;

		while((len=fis.read(buf))!=-1){
			
			out.write(buf,0,len);
		}
		
		s.shutdownOutput(); //发送关闭标志

		InputStream ins = s.getInputStream();

		byte[] bufIn = new byte[1024];
		int num = ins.read(bufIn);
		System.out.println(new String(bufIn,0,num));

		fis.close();
		s.close();
		
	}
}
class PicThread implements Runnable{
	
	Socket s;
	PicThread(Socket s){
		this.s = s;
	}

	public void run(){
			
			try{
			
				String ip = s.getInetAddress().getHostAddress();
				System.out.println(ip+"........connect!");
	
				InputStream in = s.getInputStream();
				
				int count = 1;
				File file = new File("server.jpg");
				while(file.exists()){
					file = new File("server("+(count++)+").jpg");
				}
	
				byte[] buf = new byte[1024];
				int len = 0;
				FileOutputStream fos = new FileOutputStream(file);
				while((len=in.read(buf))!=-1){
					fos.write(buf,0,len);
				}
	
				OutputStream out = s.getOutputStream();
				out.write("上传成功".getBytes());
				s.close();
			}catch(Exception e){
				throw new RuntimeException("上传失败。");
			}
	}
}	
class PicServer{

	public static void main(String[] args)throws Exception{

	
		ServerSocket ss = new ServerSocket(10001);
	
		while(true){
				
			Socket s = ss.accept();
			new Thread(new PicThread(s)).start();
//			String ip = s.getInetAddress().getHostAddress();
//			System.out.println(ip+"........connect!");
//
//			InputStream in = s.getInputStream();
//			
//			int count = 1;
//			File file = new File("server.jpg");
//			while(file.exists()){
//				file = new File("server("+(count++)+").jpg");
//			}
//
//			byte[] buf = new byte[1024];
//			int len = 0;
//			FileOutputStream fos = new FileOutputStream(file);
//			while((len=in.read(buf))!=-1){
//				fos.write(buf,0,len);
//			}
//
//			OutputStream out = s.getOutputStream();
//			out.write("上传成功".getBytes());
//			s.close();
		}
	} 
}
