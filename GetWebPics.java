import java.io.*;
import java.util.regex.*;
import java.net.*;
/*随意给定一个网址，获取该网站上jpg图片。
 * 主要分两步：
 * 1.获取图片的url连接，存入一个文本文件中
 * 2.读取上一步骤中文本文件中url连接，利用ByteArrayOutputStream将图像数据写入一个文件中，并保存在本地磁盘中。
 *
 */

public class GetWebPics{

	private static File f;

	public static void main(String[] args)throws Exception{
		
		getPicURLs();//得到网站中所有图片的url链接,并保存在文本文件中。

		getPics(f);//读取文本文件中图片的url链接，读取数据，写入本地磁盘。
	}

	public static void getPicURLs()throws Exception{
		
		URL url = new URL("http://qing.blog.sina.com.cn/tj/a7a0b05332004c07.html");   //url链接
		URLConnection conn = url.openConnection(); //打开url链接，得到一个URLConnection
		
		InputStream in = conn.getInputStream();  //通过conn，读取网站内容，返回InputStream
		
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(in));  //利用BufferedReader对象封装InputStreamReader对象,读取数据。 

		String regx = "http://[\\w\\./]+\\.jpg"; //正则规则，获取jpg格式图片的网站地址

		Pattern p = Pattern.compile(regx);
		
		String line = null;
		f = new File("e:\\picsdir.txt");
		BufferedWriter bufw = new BufferedWriter(new FileWriter(f));
		while((line=bufIn.readLine())!=null){
			
			Matcher m = p.matcher(line);
			while(m.find()){
				System.out.println(m.group());
				bufw.write(m.group()+"\r\n"); //写入到文件中。
			}
		}

		bufIn.close();
		bufw.close();
	}
	public static void getPics(File f)throws Exception{		
		
		BufferedReader bufr = new BufferedReader(new FileReader(f));
		String picurl = null;
		while((picurl = bufr.readLine())!=null){
			URL url = new URL(picurl);
			URLConnection conn = url.openConnection();
			InputStream instream = conn.getInputStream();

			byte[] data = readInputStream(instream);

			File dirPath = new File("e:\\图"); //创建目录
			if(!(dirPath.exists()))
				dirPath.mkdirs();

			File imageFile = new File(dirPath,System.currentTimeMillis()+".jpg");
			FileOutputStream FileOS = new FileOutputStream(imageFile);
			FileOS.write(data);
			FileOS.close();
			//BufferedWriter bufw = new BufferedWriter(new FileWriter(imageFile));
			//bufw.write(data); //BufferedWriter对象没有写入byte数组的方法
		}

	}
	/*
	 *读取图片数据，用ByteArrayOutputStream对象的toByteArray()方法写入到byte数组中。
	 */
	private static byte[] readInputStream(InputStream instream)throws Exception{
	
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		byte[] buffer = new byte[1024];
		int len = 0;
		while((len = instream.read(buffer))!=-1){
		
			baos.write(buffer,0,len);
		}
		instream.close();
		return baos.toByteArray();
	}

}

