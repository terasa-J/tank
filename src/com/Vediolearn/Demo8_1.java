/**
 * ���߳�����
 */
package com.Vediolearn;
public class Demo8_1 {

	public static void main(String[] args) {
		Calculate cal=new Calculate(10);
		Show show=new Show(10);
		Thread t1=new Thread(cal);
		Thread t2=new Thread(show);
		t2.start();
		t1.start();

	}
}
//���Hello
class Show implements Runnable{
	int n;
	int times=0;
	public Show(int n){
		this.n=n;
	}
	
	public void run() {
		while(true){
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		times++;
		System.out.println("���������"+times+"��Hello");
		if(times==n)
			break;
		}
	}
	
}
//���ڼ���1+2+...+n
class Calculate implements Runnable{
	int n;
	int times=0;
	int result;
	public Calculate(int n){
		this.n=n;
	}
	public void run(){
		while(true){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		result+=(++times);
		System.out.println("��ǰ�����:"+result);
		if(times==n)
			break;
		
		}
	}
}