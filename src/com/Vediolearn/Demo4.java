package com.Vediolearn;

import java.util.Scanner;

/** 简单的猜拳游戏*/
public class Demo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Choose.choose();
	}

}
class Choose{
	public static void choose(){
		System.out.println("是否开始猜拳游戏，输入1开始，0结束");
		Scanner reader=new Scanner(System.in);
		int start=reader.nextInt();
		switch(start){
		case 0:
			System.out.println("游戏结束");
			break;
		case 1:
			System.out.println("游戏开始了!");
			Begin begin=new Begin();
			break;
		default:
			System.out.println("输入不合法");
			choose();
			break;
		}
		
	}
}
class Begin{
	public Begin(){
		//用于计算输赢平的盘数
		int a1=0,a2=0,a3=0;
		System.out.print("你想玩几盘呢:");
		Scanner reader=new Scanner(System.in);
		int number=reader.nextInt();
		for(int i=1;i<=number;i++){
			System.out.print("游戏说明：0代表石头，1代表剪刀，2代表包,请出拳:");
			int player=reader.nextInt();
			System.out.println("player出拳："+player);
			//电脑出拳
			int computer=(int)Math.random()*3;
			System.out.println("computer出拳："+computer);
			if(player==computer){
				a1++;
				System.out.println("打平了~");
			}
			else if((player-computer==-1)||(player-computer==2)){
				a2++;
				System.out.println("你赢了~");
			}
			else{
				a3++;
				System.out.println("你输了。");
			}
			System.out.println();
		}
		System.out.println("游戏最终结果： "+"\n"+"打平了："+a1+"盘"+"\n"+"你赢了："+a2+"盘"+"\n"+"你输了："+a3+"盘");
		Choose.choose();
	}
}