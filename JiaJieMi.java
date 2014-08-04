/**
 * ClassName:     JiaJieMi
 * description:  encode and decode
 * Author:        lhb
 * Date:         2014-04-28 07:44:43
 * Version:		 1.0
 *
 */

import java.io.*;
 
public class  JiaJieMi {
    public static void main(String[] args){
        byte key = 5;
        File srcFile = new File("src.txt");
        File encodeFile = new File("jiami.txt");
        File decodeFile = new File("jiemi.txt");
        JiaJieMi jjm = new JiaJieMi();
        jjm.encode(key, srcFile, encodeFile);
        jjm.decode(encodeFile, decodeFile);
        
    } 	

    public void encode(byte key, File srcFile, File encodeFile){
        try{
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));

            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            baos.write(key);

            int c = bis.read();
            while(c != -1){
                c = c ^ key;
                baos.write(c);
                c = bis.read();
            }
            bis.close();
            byte[] buf = baos.toByteArray();

            FileOutputStream out =  new FileOutputStream(encodeFile);
            out.write(buf);
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    public void decode(File encodeFile, File decodeFile){
        try{
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(encodeFile));

            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int c = bis.read();
            byte key = (byte)c;
            System.out.println(key);  
            c = bis.read();
            while(c != -1){
                c = c ^ key;
                baos.write(c);
                c = bis.read();
            }
            bis.close();
            byte[] buf = baos.toByteArray();

            FileOutputStream out =  new FileOutputStream(decodeFile);
            out.write(buf);
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }


} 

