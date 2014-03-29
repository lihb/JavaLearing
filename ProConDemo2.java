import java.util.concurrent.locks.*;

/*生产者--消费者模式（多生产者---多消费者）------等待唤醒方式----
 * 方式一:传统的方式 synchronized相当于 锁 。
 *jdk5.0的新特性（方式二）来重新编写
 *用到的类有，Lock类，Condition类等
 *Lock类替代了synchronized函数和代码块。Condition类替代了wait,notify,notifyAll等方法；优势是一把锁可以有
 *多个Condition对象，从而可以只唤醒对方的线程。
 */
public class ProConDemo2{
	
	public static void main(String[] args){
		
		Resources res = new Resources();
		Pro pro = new Pro(res);
		Consumer con = new Consumer(res);
		Thread t1 = new Thread(pro);
		Thread t2 = new Thread(pro);
		Thread t3 = new Thread(pro);
		Thread t4 = new Thread(con);
		Thread t5 = new Thread(con);
		Thread t6 = new Thread(con);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		
	}
}
//方式一 ---传统方式

class Resources{
	
	private String name;
	private int count=1;
	private boolean flag =false;

	public synchronized void set(String name){//throws InterruptedException{
		
			while(flag){
				try{
					this.wait();
				}catch(Exception e){}
			}
			this.name = name+"....."+count++;
			System.out.println(Thread.currentThread().getName()+"生产了.."+this.name);
			flag = true;
			this.notifyAll();

	}

	public synchronized void out(){// throws InterruptedException{
			while(!flag){
				try{
					this.wait(); 
				}catch(Exception e){}
			}
			System.out.println(Thread.currentThread().getName()+"消费了...."+name);
			flag = false;
			this.notifyAll();
	}
}

class Pro implements Runnable{
	
	Resources res;
	Pro(Resources res){
		this.res = res;
	}

	public void run(){
		
		while(true){
			res.set("goods");
		}
	}
}

class Consumer implements Runnable{
	
	Resources res;
	Consumer(Resources res){
		this.res = res;
	}

	public void run(){
		
		while(true){
			res.out();
		}
	}
}
//方式二---java5.0的新特性
/*
class Resources{
	
	private String name;
	private int count=1;
	private boolean flag =false;
	private Lock lock = new ReentrantLock(); // 锁 对象
	private Condition condition_pro = lock.newCondition();
	private Condition condition_con = lock.newCondition();

	public void set(String name)throws InterruptedException{
		
		lock.lock();
		try{		
			while(flag){
				condition_pro.await(); //生产者线程进入冻结状态，释放cpu的使用权
			}
			this.name = name+"....."+count++;
			System.out.println(Thread.currentThread().getName()+"生产了.."+this.name);
			flag = true;
			condition_con.signal();//唤醒消费者的线程
		}finally{
			lock.unlock();
		}

	}

	public void out() throws InterruptedException{
		lock.lock();
		try{
			while(!flag)
				condition_con.await(); //消费者进入冻结状态，放弃对cpu的使用权
			System.out.println(Thread.currentThread().getName()+"消费了...."+name);
			flag = false;
			condition_pro.signal();//唤醒生产者的线程
		}finally{
			lock.unlock();
		}
	}
}

class Pro implements Runnable{
	
	Resources res;
	Pro(Resources res){
		this.res = res;
	}

	public void run(){
		
		while(true){
			try{
				res.set("goods");
			}catch(InterruptedException ex){}
		}
	}
}

class Consumer implements Runnable{
	
	Resources res;
	Consumer(Resources res){
		this.res = res;
	}

	public void run(){
		
		while(true){
			try{
				res.out();
			}catch(InterruptedException ex){}
		}
	}
}
*/
