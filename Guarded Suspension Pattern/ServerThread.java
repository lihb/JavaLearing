/**
 * ClassName:     ServerThread
 * description:  处理请求的线程。
 * Author:        lhb
 * Date:         2014-09-11 16:09:21
 * Version:		 1.0
 *
 */
import java.io.*;
import java.util.*;
import java.net.*;
public class  ServerThread extends Thread{
    private Random random;
    private RequestQueue requestQueue;
    public ServerThread(RequestQueue requestQueue, String name, long seed){
        super(name);
        this.requestQueue = requestQueue;
        this.random = new Random(seed);
    }

    public void run(){
        for(int i = 0; i < 50; i++){
            Request request = requestQueue.getRequest();
            System.out.println(Thread.currentThread().getName()+ " handles "  + request);
            try{
                Thread.sleep(random.nextInt(1000));
            }catch(InterruptedException e){
            
            }
        }
    }
} 


