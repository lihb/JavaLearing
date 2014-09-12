/**
 * ClassName:     Main
 * description:   测试类
 * Author:        lhb
 * Date:         2014-09-12 16:51:21
 * Version:		 1.0
 *
 */
import java.io.*;
import java.util.*;
import java.net.*;
public class  Main {
    public static void main(String[] args){
        Table table = new Table(3);    //建立可以放置3个蛋糕的桌子
        new MakerThread("MakerThread-1", table, 31415).start();
        new MakerThread("MakerThread-2", table, 56638).start();
        new MakerThread("MakerThread-3", table, 45524).start();
        new EaterThread("EaterThread-1", table, 62582).start();
        new EaterThread("EaterThread-2", table, 62152).start();
        new EaterThread("EaterThread-3", table, 15522).start();
        	
    } 	
} 

