package com.Vediolearn;

import java.util.Scanner;

/** �򵥵Ĳ�ȭ��Ϸ*/
public class Demo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Choose.choose();
	}

}
class Choose{
	public static void choose(){
		System.out.println("�Ƿ�ʼ��ȭ��Ϸ������1��ʼ��0����");
		Scanner reader=new Scanner(System.in);
		int start=reader.nextInt();
		switch(start){
		case 0:
			System.out.println("��Ϸ����");
			break;
		case 1:
			System.out.println("��Ϸ��ʼ��!");
			Begin begin=new Begin();
			break;
		default:
			System.out.println("���벻�Ϸ�");
			choose();
			break;
		}
		
	}
}
class Begin{
	public Begin(){
		//���ڼ�����Ӯƽ������
		int a1=0,a2=0,a3=0;
		System.out.print("�����漸����:");
		Scanner reader=new Scanner(System.in);
		int number=reader.nextInt();
		for(int i=1;i<=number;i++){
			System.out.print("��Ϸ˵����0����ʯͷ��1���������2�����,���ȭ:");
			int player=reader.nextInt();
			System.out.println("player��ȭ��"+player);
			//���Գ�ȭ
			int computer=(int)Math.random()*3;
			System.out.println("computer��ȭ��"+computer);
			if(player==computer){
				a1++;
				System.out.println("��ƽ��~");
			}
			else if((player-computer==-1)||(player-computer==2)){
				a2++;
				System.out.println("��Ӯ��~");
			}
			else{
				a3++;
				System.out.println("�����ˡ�");
			}
			System.out.println();
		}
		System.out.println("��Ϸ���ս���� "+"\n"+"��ƽ�ˣ�"+a1+"��"+"\n"+"��Ӯ�ˣ�"+a2+"��"+"\n"+"�����ˣ�"+a3+"��");
		Choose.choose();
	}
}