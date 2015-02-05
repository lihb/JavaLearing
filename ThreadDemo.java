 class ThreadDemo implements Runnable{ 
int x=0,y=0; 
int addX(){x++; return x;} 
int addY(){y++; return y;} 

public void run() 
{ 
for(int i=0;i<10;i++) 
System.out.println(addX()+""+addY()); 
} 

public static void main(String args[]) 
{ 
ThreadDemo run=new ThreadDemo(); 
Thread t1=new Thread(run); 
Thread t2=new Thread(run); 
t1.start(); 
t2.start(); 
} 
} 
/* 输出结果为：
11
33
44
55
66
77
88
99
1010
1111
22
1212
1313
1414
1515
1616
1717
1818
1919
2020
或者：
11
33
44
55
22
77
88
99
1010
1111
1212
1313
1414
1515
66
1616
1717
1818
1919
2020

 */


