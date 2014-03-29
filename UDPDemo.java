import java.io.*;
import java.net.*;

public class UDPDemo{

	public static void main(String[] args) throws Exception{ 
	
		DatagramSocket sendDS = new DatagramSocket();
		DatagramSocket receiveDS = new DatagramSocket(10000);

		new Thread(new Send(sendDS)).start();
		new Thread(new Receive(receiveDS)).start();
    }

}

class Send implements Runnable{
	
	private DatagramSocket ds;
	public Send(DatagramSocket ds){
		this.ds = ds;
	}

	public void run(){
		
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try{
		
			while((line=bufr.readLine())!=null){
				byte[] buf = line.getBytes();
				DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.0.104"),10000);
				ds.send(dp);

				if("886".equals(line))
					break;
			}
		}catch(Exception e){}


	}

}

class Receive implements Runnable{
	
	private DatagramSocket ds;
	public Receive(DatagramSocket ds){
		this.ds = ds;
	}
	public void run(){
		try{
			while(true){
			
				byte[] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf,buf.length);
				ds.receive(dp);
				String ip = dp.getAddress().getHostAddress();
				String data = new String(dp.getData(),0,dp.getLength());
				System.out.println(ip+":::"+data);
			}
		}catch(Exception ex){}

	}

}
