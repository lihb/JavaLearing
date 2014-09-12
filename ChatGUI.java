import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
/**
 *这是小型的聊天程序，主要的知识点为 java awt编程，udp协议，多线程等。
 * udp需要两个客户端，发送端和接收短都需要安装在双方机子上。
 */
class Send implements Runnable{

	private	DatagramSocket ds;
	private String data;
	Send(DatagramSocket ds){
		this.ds = ds;
	}

	public void setData(String data){
		
		this.data = data;
	}

	public void run(){
		try{
		//	BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

			//String line = null;

			//while((line=bufr.readLine())!=null){
			if(data!=null){
			
				//byte[] buf = data.getBytes();
				byte[] buf = data.getBytes("utf-8");
				DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("10.10.32.213"),10000);
				ds.send(dp);
			}
		}catch(Exception e){}
	}

}
class Receive implements Runnable{

	private DatagramSocket ds;
	private TextArea  ta;
	private String result="";
	Receive(DatagramSocket ds,TextArea ta){
		this.ds = ds;
		this.ta = ta;
	}

	public String getResult(){
		return result;
	}


	public void run(){
		try{
			while(true){
				byte[] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf,buf.length);
				ds.receive(dp);
				String ip = dp.getAddress().getHostAddress();

				String data = new String(dp.getData(),0,dp.getLength(), "UTF-8");
				result = ip+"::::说:"+data;
				ta.append(result+"\r\n");
				System.out.println(result);
				//result="";
			}
		}catch(Exception e){}		

	}

}

public class ChatGUI{
	
	private Frame frame;
	private TextArea ta_send;
	private TextArea ta_receive;
	private Button btn_send;
	private Button btn_rece;
	private DatagramSocket sendDS ;//= new DatagramSocket();
	private DatagramSocket receiveDS;// = new DatagramSocket(10000);
	private Receive receive;//= new Receive(receiveDS);
	private Send send;// = new Send(sendDS);
	
	ChatGUI()throws Exception{
		init();	
	}

	public void init()throws Exception{
		sendDS = new DatagramSocket();
		receiveDS = new DatagramSocket(10000);

		frame = new Frame("Chat");
		frame.setBounds(300,200,800,600);
		frame.setLayout(new FlowLayout());

		ta_receive = new TextArea(10,110);
		ta_send =new TextArea(2,110);

		receive = new Receive(receiveDS,ta_receive);
		send = new Send(sendDS);
		
		btn_send = new Button("发送");
		//btn_rece = new Button("接收");
		
		frame.add(ta_receive);
		frame.add(ta_send);
		frame.add(btn_send);
		//frame.add(btn_rece);
		
		myEvent();
		
		frame.setVisible(true);
	//	new Thread(send).start();
		new Thread(receive).start();
	}

	public void myEvent(){
		
		frame.addWindowListener(new WindowAdapter(){
			
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		btn_send.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
                String data="";
                //try{
				     data = ta_send.getText();
                //}catch(UnsupportedEncodingException ex){
                //    throw new RuntimeException();
               // }
				send.setData(data);
				new Thread(send).start();
				ta_receive.append("\r\n我说:"+data+"\r\n");
				ta_send.setText("");
			}
		});
		
	}


	public static void main(String[] args)throws Exception{

		ChatGUI chat =new ChatGUI();
		
	} 
}
