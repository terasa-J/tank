/**
 * 单线程
 * 线程的练习(Thread类，Rnunable接口)
 */
package com.Vediolearn;

public class Demo8 {
	public static void main(String[] args) {
		ShowInfo info=new ShowInfo();
		Thread t=new Thread(info);
		t.start();
	}

}
//class ShowInfo extends Thread{
class ShowInfo implements Runnable{
	public void run(){
		int times=0;
		while(true){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		times++;
		System.out.println("Hello world!"+times);
		if(times==10)
		{
			break;
		}
		}
	}
}