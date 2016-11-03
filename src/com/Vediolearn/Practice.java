/** 随便跟课堂练习
 
 */
package com.Vediolearn;


public class Practice {

	public static void main(String[] args) {
		TicketWindow tw=new TicketWindow();
		Thread t1=new Thread(tw,"第一个窗口");
		Thread t2=new Thread(tw,"第二个窗口");
		Thread t3=new Thread(tw,"第三个窗口");
		t1.start();
		t2.start();
		t3.start();
	}
	
}
class TicketWindow implements Runnable{

	private int tickets=30;
	private Pig pig=new Pig();
	public void run() {
		while(true){
		//	synchronized(this){	
			synchronized(pig){	
			if(tickets>0){
				System.out.println(Thread.currentThread().getName()+" 在卖第"+tickets+"张票");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				tickets--;
			}
			else
				break;
			
			}
		}
		
	}
}
class Pig{}