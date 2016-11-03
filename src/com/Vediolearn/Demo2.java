package com.Vediolearn;
/**
	猴子吃桃问题
*/
import java.util.*;//加载包
public class Demo2{
	public static void main(String []args){
		Monkey mo=new Monkey();
		mo.scan();
	}
}

class Monkey{
	//day哪天的桃子数，sday吃了多少天剩下一个
	public static int peach(int day,int sday){//建一个peach方法
		if(day==sday){
			return 1;
		}else{
			return (peach(day+1,sday)+1)*2;//算法返回值
		}
	}
	public static void scan(){ //建立输入的方法
		int a=1;
		System.out.println("请输入要吃几天：");
		Scanner sr=new Scanner(System.in);
		int b=sr.nextInt();
		if(a<b){
			System.out.print(Monkey.peach(a,b));
		}else{
			System.out.println("不能小于等于1天");
			Monkey.scan();
		}
	}
}