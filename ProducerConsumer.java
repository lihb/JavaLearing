/*生产者消费者模式，用简单的2个线程来完成。(只适用于一个生产者一个消费者的情况)
 * 主要用来学习线程间的同步机制，wait()方法和notify()方法的学习。
 *
 *
 *
 */
class Resources{
	
	private String resName;
	private int count = 1;
	private boolean flag = false;

	//Resources(String name){
	//	this.resName = name;
	//}
	public synchronized void set(String name){
		if(flag)
			try{
				this.wait();
			}catch(Exception e){
				
			}
		this.resName = name+"...."+count++;
		System.out.println(Thread.currentThread().getName()+"生产者.."+resName);
		flag = true;
		this.notify();
		
	}

	public synchronized void out(){
		if(!flag)
			try{
				this.wait();
			}catch(Exception e){
			}
		System.out.println(Thread.currentThread().getName()+"消费者........"+resName);
		flag = false;
		this.notify();
	}

}

class Producer implements Runnable{
	
	Resources res;

	Producer(Resources res){
		this.res = res;
	}

	public void run(){
		
		while(true){
			res.set("+商品+");
		}
	}
}

class Conusumer implements Runnable{
	
	Resources res;

	Conusumer(Resources res){
		this.res = res;
	}

	public void run(){

		while(true){
			res.out();
		}
	}

}

public class ProducerConsumer{
	
	public static void main(String[] args){
	
		Resources res = new Resources();
		Producer producer = new Producer(res);
		Conusumer conusumer = new Conusumer(res);
		
		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(producer);
		Thread t3 = new Thread(producer);
		Thread t4 = new Thread(conusumer);
		Thread t5 = new Thread(conusumer);
		Thread t6 = new Thread(conusumer);
		Thread t7 = new Thread(conusumer);
		Thread t8 = new Thread(conusumer);
		Thread t9 = new Thread(conusumer);

		t1.start();
		t2.start();
        t4.start();
        t5.start();


	}
}
