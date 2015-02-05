/**
 * ClassName:    ThreadLocalTest
 * description:  测试ThreadLocal类，使用该类可以在不同的线程上使用同一变量的不
 *               同副本，而不互相干涉
 * Author:        lhb
 * Date:         2014-11-14 10:44:47
 * Version:		 1.0
 *
 */
import java.io.*;
import java.util.*;
import java.net.*;
public class ThreadLocalTest {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
    public static void main(String[] args){
       for(int i = 0; i < 2; i++){
           new Thread(new Runnable(){
                public void run(){
                    int data = new Random().nextInt();
                    threadLocal.set(data);
                    System.out.println(Thread.currentThread().getName() 
							+ " has put data :" + data);  
                    new A().get();
                    new B().get();
                }
           }).start();
       } 

    }
static class A{
    public void get(){
        System.out.println(" method A from " + Thread.currentThread().
                getName() + " data: " + threadLocal.get());  
    }
}
static class B{
    public void get(){
         System.out.println(" method B from " + Thread.currentThread().
                getName() + " data: " + threadLocal.get());  
    }
} 

}
