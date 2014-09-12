/**
 * ClassName:     MakerThread
 * description:   生产者，制作蛋糕的类
 * Author:        lhb
 * Date:         2014-09-12 16:52:16
 * Version:		 1.0
 *
 */
import java.io.*;
import java.util.*;
import java.net.*;
public class  MakerThread extends Thread{
    private final Random random;
    private final Table table;
    private static int id = 0;   //蛋糕的流水号（所有厨师相同）

    public MakerThread(String name, Table table, long seed){
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }

    public void run(){
        try{
            while(true){
                Thread.sleep(random.nextInt(1000));
                String cake = "Cake No." +nextId()+ " by " +Thread.currentThread
                    ().getName()+"";
                table.put(cake);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    private static synchronized int nextId(){
        return id++;
    }
} 

