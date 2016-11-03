/** ����������ϰ
 
 */
package com.Vediolearn;


public class Practice {

	public static void main(String[] args) {
		TicketWindow tw=new TicketWindow();
		Thread t1=new Thread(tw,"��һ������");
		Thread t2=new Thread(tw,"�ڶ�������");
		Thread t3=new Thread(tw,"����������");
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
				System.out.println(Thread.currentThread().getName()+" ������"+tickets+"��Ʊ");
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