/**
 * ClassName:     Table
 * description:   存放蛋糕的类，起到一个缓冲池的作用
 * Author:        lhb
 * Date:         2014-09-12 17:09:52
 * Version:		 1.0
 *
 */
import java.io.*;
import java.util.*;
import java.net.*;
public class  Table {
    private final String[] buffer;
    private int tail;              // 下一个put的地方
    private int head;              // 下一个take的地方
    private int count;             // buffer内的蛋糕数目

    public Table(int count){
        this.buffer = new String[count];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    // 放置蛋糕
    public synchronized void put(String cake) throws InterruptedException{
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        while(count >= buffer.length){
            this.wait();
        }
        buffer[tail] = cake;
        tail = (tail + 1) % buffer.length;
        count++;
        notifyAll();
    }

    // 获取蛋糕
    public synchronized String take() throws InterruptedException{
        while(count <= 0){
            wait();
        }
        String cake = buffer[head];
        head = (head + 1) % buffer.length;
        count--;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " takes " + cake);
        return cake;
    }
} 

