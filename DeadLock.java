
class Lock{
	public static Object locka = new Object();
	public static Object lockb = new Object();
}

class DeadDemo implements Runnable{
	
	private boolean flag;
	DeadDemo(boolean flag){
		this.flag = flag;
	}
	public void run(){
		if(flag){
			while(true){
				synchronized(Lock.locka){
					System.out.println(Thread.currentThread().getName()+" if locka....");
					synchronized(Lock.lockb){
						System.out.println(Thread.currentThread().getName()+" if lockb....");
					}
				}	
			}
		}else{
				while(true){
					synchronized(Lock.lockb){
						System.out.println(Thread.currentThread().getName()+" else lockb....");
						synchronized(Lock.locka){
							System.out.println(Thread.currentThread().getName()+" else locka....");
						}			
					}
				}
			}
	}
}
	



public class DeadLock{
	
	public static void main(String[] args){

		new Thread(new DeadDemo(true)).start();
		new Thread(new DeadDemo(false)).start();
	
	}
}
