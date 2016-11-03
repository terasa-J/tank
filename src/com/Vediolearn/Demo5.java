package com.Vediolearn;

import java.util.Calendar;
import java.util.Scanner;

/** 巫师小游戏*/
public class Demo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Start().begin();
	}

}
class Start{
	public void begin(){
		System.out.println("请输入年月份：");
		Scanner reader=new Scanner(System.in);
		int year=reader.nextInt();
		int month=reader.nextInt();
		int date=reader.nextInt();
		//星期几
		Week week=new Week();
		week.result(year, month, date);
		//星座
		Xingzuo xingzuo=new Xingzuo();
		xingzuo.result(month, date);
		//是否继续
		System.out.println("是否继续占卜，输入0退出，1继续");
		int i=reader.nextInt();
		if(i==0){
			System.out.print("游戏结束,巫师一共占卜的人数为："+xingzuo.getI()+"人");
		}
		else if(i==1){
			begin();
		}
			
	}
}
class Week{
	public void result(int year,int month,int date){
		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.YEAR,year);
		calendar.set(Calendar.MONTH,month-1);   //减一为了判断星期几
		calendar.set(Calendar.DATE,date);
		int week=calendar.get(Calendar.DAY_OF_WEEK);
		//System.out.println(calendar.get(Calendar.MONTH)+"  "+calendar.get(Calendar.YEAR));
		switch(week){
		case 1:System.out.println("你出生在星期日");
			   break;
		case 2:System.out.println("你出生在星期一");
		   break;
		case 3:System.out.println("你出生在星期二");
		   break;
		case 4:System.out.println("你出生在星期三");
		   break;
		case 5:System.out.println("你出生在星期四");
		   break;
		case 6:System.out.println("你出生在星期五");
		   break;
		case 7:System.out.println("你出生在星期六");
		   break;
		}
	}
}
class Xingzuo{
	public static int i=0;
	//统计人数
	public  int getI() {
		return i;
	}
	//算星座
	public void result(int month,int date){
		i++;
		switch(month){
		case 1:
			if(date>=20)
				System.out.println("水瓶座");
			else
				System.out.println("摩羯座");
			break;
		case 2:
			if(date>=19)
				System.out.println("双鱼座");
			else
				System.out.println("水瓶座");
			break;
		case 3:
			if(date>=21)
				System.out.println("白羊座");
			else
				System.out.println("双鱼座");
			break;
		case 4:
			if(date>=20)
				System.out.println("金牛座");
			else
				System.out.println("白羊座");
			break;
		case 5:
			if(date>=21)
				System.out.println("双子座");
			else
				System.out.println("金牛座");
			break;
		case 6:
			if(date>=21)
				System.out.println("巨蟹座");
			else
				System.out.println("金牛座");
			break;
		case 7:
			if(date>=23)
				System.out.println("狮子座");
			else
				System.out.println("巨蟹座");
			break;
		case 8:
			if(date>=20)
				System.out.println("处女座");
			else
				System.out.println("巨蟹座");
			break;
		case 9:
			if(date>=23)
				System.out.println("天平座");
			else
				System.out.println("处女座");
			break;
		case 10:
			if(date>=23)
				System.out.println("天蝎座");
			else
				System.out.println("天平座");
			break;
		case 11:
			if(date>=22)
				System.out.println("射手座");
			else
				System.out.println("天蝎座");
			break;
		case 12:
			if(date>=22)
				System.out.println("摩羯座");
			else
				System.out.println("射手座");
			break;
		}
	}
}