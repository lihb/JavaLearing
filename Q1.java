public class Q1 implements Runnable 
{ 
public void run(String s) 
{ 
System.out.println("Before start Thread :"+s); 

System.out.println("After stop of Thread :"+s); 
} 

public static void main(String[] args) 
{ 
Q1 a = new Q1(); 
Thread t=new Thread(a); 
t.start();} 
} 
