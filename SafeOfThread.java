/**
 * ClassName:     SafeOfThread
 * description:   线程安全和非安全
 * Author:        lhb
 * Date:         2014-09-07 22:42:47
 * Version:		 1.0
 *
 * 静态变量：线程非安全。

* 静态变量即类变量，位于方法区，为所有对象共享，共享一份内存，一旦静态变量被 修改，其他对象均对修改可见，故线程非安全。
*
*实例变量：“单例模式”线程非安全，“非单例线程”安全
*
*实例变量为对象实例私有，在虚拟机的堆中分配，若在系统中只存在一个此对象的实 *例，在多线程环境下，“犹如”静态变量那样，被某个线程修改后，其他线程对修改均可见，故线程非安全；如果每个线程执行都是在不同的对象中，那对象与对象之间的实例变量的修改将互不影响，故线程安全。
*
*局部变量：线程安全。
*
*每个线程执行时将会把局部变量放在各自栈帧的工作内存中，线程间不共享，故不存在线程安全问题。
 *
 */
import java.util.*;
import java.io.*;
 public class  SafeOfThread implements Runnable{

    private static int static_i;    //静态变量
    private int instance_i;         //实例变量

    public void run(){
        /* static_i = 4;
        System.out.println("["+Thread.currentThread().getName()+"]获取static_i的值："+static_i);  
        static_i = 10;
        System.out.println("["+Thread.currentThread().getName()+"]获取static_i的值："+static_i * 2);  */
        instance_i = 4;
        //System.out.println("["+Thread.currentThread().getName()+"]获取instance_i的值："+instance_i);  
        instance_i = 10;
        //System.out.println("["+Thread.currentThread().getName()+"]获取instance_i的值："+instance_i * 2);  
        int local_i = 4;
        System.out.println("[" + Thread.currentThread().getName()
                + "]获取local_i 的值:" + local_i);
        local_i = 10;
        System.out.println("[" + Thread.currentThread().getName()
                + "]获取local_i*2的值:" + local_i * 2);


    }
    public static void main(String[] args){
        SafeOfThread test = new SafeOfThread();
        for(int i = 0; i < 1000; i++){
            //new Thread(test, "线程" + i).start();
            //new Thread(new SafeOfThread(), "线程" + i).start();
            System.out.println(Runtime.getRuntime().availableProcessors());  
        }

        	
    } 	
} 

