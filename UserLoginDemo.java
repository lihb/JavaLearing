import java.net.*;
import java.io.*;

class LoginClient{
	
	public static void main(String[] args)throws Exception{
		
		//创建链接
		Socket s = new Socket("192.168.0.100",10002);
		//建立输入流，读取键盘数据
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		//获取socket的输出流，往服务端写数据
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		//获取socket输入流，接收服务端的反馈信息
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

		//读取三次，是否成功，三次完毕后，不管结果，退出循环
		for(int x=0;x<3;x++){
			String name = bufr.readLine();
			if(name==null)//如果在客户端按下 CTRL+c，则退出
				break;
			out.println(name);

			String info = bufIn.readLine();
			System.out.println("info:"+info);
			if(info.contains("欢迎"))//校验成功，打印欢迎信息，退出登录模块
				break;
		}
		bufr.close();
		s.close();
	}
	
}

class LoginThread implements Runnable{
	
	private Socket s;

	LoginThread(Socket s){
		this.s = s;
	}

	public void run(){
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+".......connect!");
		
		try{

			for(int x= 0;x<3;x++){
				//获取socket输入流，读取从客户端过来的数据。
				BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
				//获取文件输入流，读取名字文件
				BufferedReader bufr = new BufferedReader(new FileReader("userList.txt"));
				//获取socket输出流，输出反馈信息到客户端
				PrintWriter out = new PrintWriter(s.getOutputStream(),true);
				//获取客户端数据
				String name = bufIn.readLine();
				if(name==null)
					break;

				boolean flag = false;
				String line =null;
				while((line=bufr.readLine())!=null){
					if(line.equals(name)){
						flag = true;
						break;
					}
				}
				if(flag){
					out.println(name+"，欢迎光临。");
					System.out.println(name+",已登录。");
					break;
				}
				else{
					System.out.println(name+"，尝试登录。");
					out.println(name+",用户名不存在。");
					
				}
			}
			s.close();

		}catch(Exception e){
			throw new RuntimeException(ip+"登录失败");
		}
	}
}

class LoginServer{
	
	public static void main(String[] args)throws Exception{

		ServerSocket ss = new ServerSocket(10002);
		while(true){
			
			Socket s = ss.accept();
			new Thread(new LoginThread(s)).start();
		}
	}
	
}
