
class Ticket implements Runnable{
	
	private int ticket = 100;
	public void run(){
		
		while(true){
			
			if(ticket >0)
				System.out.println(Thread.currentThread().getName()+" sale: "+ticket--);
		}
	}
}

public class ThreadTicketDemo{
	
	public static void main(String[] args){
		
		Ticket t = new Ticket();
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		Thread t3 = new Thread(t);
		Thread t4 = new Thread(t);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}


}
