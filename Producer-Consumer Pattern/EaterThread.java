/**
 * ClassName:     EaterThread
 * description:   消费者线程
 * Author:        lhb
 * Date:         2014-09-12 17:06:38
 * Version:		 1.0
 *
 */
import java.io.*;
import java.util.*;
import java.net.*;
public class  EaterThread extends Thread{
    private final Random random;
    private final Table table;
    public EaterThread(String name, Table table, long seed){
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }

    public void run(){
        try{
            while(true){
                String cake = table.take();
                Thread.sleep(random.nextInt(1000));
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
} 

