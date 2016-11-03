package com.Vediolearn;
//猴子吃桃，学习算法
import java.util.Scanner;

public class Demo2_2 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Monkey2 monkey=new Monkey2();
		monkey.scan();
	}

}
class Monkey2
{
	public int peach(int day,int sday)
	{
		if(day==sday)
			return 1;
		else
			return (peach(day+1,sday)+1)*2;  //关键步骤，算法推导。
	}
	public void scan()
	{
		int a=1;
		System.out.println("请输入要吃的天数：");
		Scanner reader=new Scanner(System.in);
		int b=reader.nextInt();
		if(a<b)
		{
			System.out.println(peach(a,b));
		}
		else
		{
			System.out.println("不能小于或等于1");
			scan();
		}
	}
}
