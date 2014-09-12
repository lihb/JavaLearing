/**
 * ClassName:     ClientThread
 * description:   发送请求的线程。
 * Author:        lhb
 * Date:         2014-09-11 15:58:13
 * Version:		 1.0
 *
 */
import java.io.*;
import java.util.*;
import java.net.*;
public class  ClientThread extends Thread{
    private Random random;
    private RequestQueue requestQueue;
    public ClientThread(RequestQueue requestQueue, String name, long seed){
        super(name);
        this.requestQueue = requestQueue;
        this.random = new Random(seed);
    }

    public void run(){
        for(int i = 0; i < 50; i++){
            Request request = new Request("No." + i);
            System.out.println(Thread.currentThread().getName()+ " requests"  + request);
            requestQueue.putRequest(request);
            try{
                Thread.sleep(random.nextInt(1000));
            }catch(InterruptedException e){
            
            }
        }
    }
} 

