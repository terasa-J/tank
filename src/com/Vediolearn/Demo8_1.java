/**
 * 多线程运行
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
//输出Hello
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
		System.out.println("正在输入第"+times+"个Hello");
		if(times==n)
			break;
		}
	}
	
}
//用于计算1+2+...+n
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
		System.out.println("当前结果是:"+result);
		if(times==n)
			break;
		
		}
	}
}