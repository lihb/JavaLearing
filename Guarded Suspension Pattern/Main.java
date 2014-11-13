/**
 * ClassName:     Main
 * description:  测试类。 
 * Author:        lhb
 * Date:         2014-09-11 16:15:00
 * Version:		 1.0
 *
 */
import java.io.*;
import java.util.*;
import java.net.*;
 public class  Main {
    public static void main(String[] args){
        RequestQueue requestQueue = new RequestQueue();
        new ClientThread(requestQueue, "Alice", 5522552L).start();
        new ServerThread(requestQueue, "Hobby", 6542562L).start();
        	
    } 	
} 

