/**
 * ClassName:     ThreadTest
 * description:   测试性能 
 * Author:        lhb
 * Date:         2014-09-11 10:53:08
 * Version:		 1.0
 *一个线程采用synchronized锁，一个线程使用Immutable模式，
 *各自运行1000000000次，测试所耗费的时间。
 */

import java.util.*;
import java.io.*;
public class  ThreadTest {
    private static final long CALL_COUNT = 1000000000L;
    public static void main(String[] args){
         trial("NotSync", CALL_COUNT, new NotSync()); 
         trial("Sync", CALL_COUNT, new Sync()); 
        	
    } 	

    public static void trial(String msg, long count, Object object){
         System.out.println(msg + ": BEGIN");
         long start_time = System.currentTimeMillis();
         for(long i = 0; i < count; i++){
            object.toString();
         }
         System.out.println(msg + ": END");
         System.out.println("Elapsedtime = "+ (System.currentTimeMillis() - start_time) + "msec.");  
        
    }
} 

class NotSync{
     private final String name = "Not Sync";
     public String toString(){
         return "[" + name + "]";
     }
}


class Sync{
     private final String name = "Sync";
     public synchronized String toString(){
         return "[" + name + "]";
     }
}
