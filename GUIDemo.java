import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class GUIDemo{

	private TextField tf;
	private Button btn;
	private TextArea ta;
	private Frame frame;
	private Dialog d;
	private Label label;
	private Button btnOK ;

	GUIDemo(){
	   Init();
	}

	public void Init(){
		frame = new Frame("My frame");
		frame.setBounds(200,200,600,500);
		btn = new Button("转到");
		tf = new TextField(18);
		ta = new TextArea(50,60);
		d = new Dialog(frame,"提示信息",true);
		label = new Label();
		btnOK = new Button("确定");

		frame.setLayout(new FlowLayout());
		frame.add(tf);
		frame.add(btn);
		frame.add(ta);

		d.setLayout(new FlowLayout());
		d.setBounds(250,250,200,150);
		d.add(label);
		d.add(btnOK);

		myEvent();
		frame.setVisible(true);
	}

	private void myEvent(){
		frame.addWindowListener(new WindowAdapter(){
			
			public void windowClosing(WindowEvent e){
				System.out.println("关闭窗口功能。");				
				System.exit(0);
			} 
		});

		btn.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				showDir();
			} 
		});
		d.addWindowListener(new WindowAdapter(){
			
			public void windowClosing(WindowEvent e){
				System.out.println("关闭窗口功能。");				
				d.setVisible(false);
			} 
		});
		btnOK.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				d.setVisible(false);
			}
		});
		tf.addKeyListener(new KeyAdapter(){
			
			public void KeyPressed(KeyEvent e){
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					showDir();
				}
			}
		});
	}

	public void showDir(){
		ta.setText("");
		String text = tf.getText();
		File dir = new File(text);
		if(dir.exists()&&dir.isDirectory()){
			String[] names = dir.list();
			for(String name:names){
				ta.append(name+"\r\n");
			}
		}else{
				label.setText("路径 "+dir+ " 未找到，请重输。");	
				d.setVisible(true);
			}

	} 	
	
	public static void main(String[] args){
		new GUIDemo();
	}
}
