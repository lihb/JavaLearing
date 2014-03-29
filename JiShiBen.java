package packagelhb; 
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class JiShiBen{
	
	private Frame f;
	private MenuBar bar;
	private TextArea ta;
	private Menu fileMenu;
	private MenuItem openItem,saveItem,closeItem;
	private FileDialog openDia,saveDia;
	private File file;

	JiShiBen(){
		init();
	}

	public void init(){
		//控件初始化
		f = new Frame("my window");
		f.setBounds(300,100,600,500);

		ta  = new TextArea();

		bar = new MenuBar();
		fileMenu = new Menu("文件菜单");

		openItem = new MenuItem("打开");
		saveItem = new MenuItem("保存");
		closeItem = new MenuItem("关闭");

		openDia = new FileDialog(f,"打开文件",FileDialog.LOAD);
		saveDia = new FileDialog(f,"保存文件",FileDialog.SAVE);

		
		//控件包含关系
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(closeItem);
		bar.add(fileMenu);
		f.setMenuBar(bar);
		f.add(ta);

		//添加事件
		myEvent();

		//让frame可见
		f.setVisible(true);
	}
	
	private void myEvent(){
		//窗体关闭事件
		f.addWindowListener(new WindowAdapter(){
			
			public void windowClosing(WindowEvent e){
				System.out.println("关闭窗口功能完成。");				
				System.exit(0);
			} 
		});
		//关闭菜单事件实现
		closeItem.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		//打开菜单事件实现
		openItem.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				ta.setText("");
				openDia.setVisible(true);
				String dirPath = openDia.getDirectory();
				String fileName = openDia.getFile();
				
				if(dirPath==null||fileName == null)
					return;
		        file = new File(dirPath,fileName);
				try{
					BufferedReader bufr = new BufferedReader(new FileReader(file));
					String line = bufr.readLine();
					while(line!=null){
						ta.append(line+"\r\n");
						line = bufr.readLine();
					}
					bufr.close();
				}catch(IOException ex){
					throw new RuntimeException("文件打开失败");
				}
			
			}
		});
		//保存菜单事件实现
		saveItem.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				if(file==null){
					saveDia.setVisible(true);
					String dirPath = saveDia.getDirectory();
					String fileName = saveDia.getFile();
				
					if(dirPath==null||fileName == null)
					return;
					file = new File(dirPath,fileName);
				}
				try{
					BufferedWriter bufw = new BufferedWriter(new FileWriter(file));
					String content = ta.getText();
					bufw.write(content);
					bufw.close();
				}catch(IOException ex){
					throw new RuntimeException();
				}
			}
		});
	}

	public static void main(String[] args){
		
		new JiShiBen();
	}
}
