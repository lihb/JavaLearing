/**
 * ClassName:     SystemPro
 * description:   Test the java.util.Properties class
 * Author:        lhb
 * Date:         2014-04-29 15:38:21
 * Version:		 1.0
 *
 */
import java.util.*; 
import java.io.*; 

public class  SystemPro {
    public static void main(String[] args){
        Properties pro = new Properties();
        BufferedReader bufr = null;
        try{
            bufr = new BufferedReader(new FileReader("peizhi.ini")); // 读取文件
            pro.load(bufr);                                          // 载入配置文件load()       
            String title = pro.getProperty("title");                 // 读取属性函数getProperty()
            String content = pro.getProperty("content");
            System.out.println("title: " + title );  
            System.out.println("content" + content);  
            
        }catch(FileNotFoundException e){
            System.out.println("文件未找到！");  
        }catch(IOException e){
            System.out.println("文件读取失败！");  
        }finally{
            try{
                if(bufr != null)
                    bufr.close();
            }catch(IOException e){
                System.out.println("IO流关闭失败！");  
            }
        }
    } 	
} 

