package com.Vediolearn;

import java.util.Calendar;
import java.util.Scanner;

/** ��ʦС��Ϸ*/
public class Demo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Start().begin();
	}

}
class Start{
	public void begin(){
		System.out.println("���������·ݣ�");
		Scanner reader=new Scanner(System.in);
		int year=reader.nextInt();
		int month=reader.nextInt();
		int date=reader.nextInt();
		//���ڼ�
		Week week=new Week();
		week.result(year, month, date);
		//����
		Xingzuo xingzuo=new Xingzuo();
		xingzuo.result(month, date);
		//�Ƿ����
		System.out.println("�Ƿ����ռ��������0�˳���1����");
		int i=reader.nextInt();
		if(i==0){
			System.out.print("��Ϸ����,��ʦһ��ռ��������Ϊ��"+xingzuo.getI()+"��");
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
		calendar.set(Calendar.MONTH,month-1);   //��һΪ���ж����ڼ�
		calendar.set(Calendar.DATE,date);
		int week=calendar.get(Calendar.DAY_OF_WEEK);
		//System.out.println(calendar.get(Calendar.MONTH)+"  "+calendar.get(Calendar.YEAR));
		switch(week){
		case 1:System.out.println("�������������");
			   break;
		case 2:System.out.println("�����������һ");
		   break;
		case 3:System.out.println("����������ڶ�");
		   break;
		case 4:System.out.println("�������������");
		   break;
		case 5:System.out.println("�������������");
		   break;
		case 6:System.out.println("�������������");
		   break;
		case 7:System.out.println("�������������");
		   break;
		}
	}
}
class Xingzuo{
	public static int i=0;
	//ͳ������
	public  int getI() {
		return i;
	}
	//������
	public void result(int month,int date){
		i++;
		switch(month){
		case 1:
			if(date>=20)
				System.out.println("ˮƿ��");
			else
				System.out.println("Ħ����");
			break;
		case 2:
			if(date>=19)
				System.out.println("˫����");
			else
				System.out.println("ˮƿ��");
			break;
		case 3:
			if(date>=21)
				System.out.println("������");
			else
				System.out.println("˫����");
			break;
		case 4:
			if(date>=20)
				System.out.println("��ţ��");
			else
				System.out.println("������");
			break;
		case 5:
			if(date>=21)
				System.out.println("˫����");
			else
				System.out.println("��ţ��");
			break;
		case 6:
			if(date>=21)
				System.out.println("��з��");
			else
				System.out.println("��ţ��");
			break;
		case 7:
			if(date>=23)
				System.out.println("ʨ����");
			else
				System.out.println("��з��");
			break;
		case 8:
			if(date>=20)
				System.out.println("��Ů��");
			else
				System.out.println("��з��");
			break;
		case 9:
			if(date>=23)
				System.out.println("��ƽ��");
			else
				System.out.println("��Ů��");
			break;
		case 10:
			if(date>=23)
				System.out.println("��Ы��");
			else
				System.out.println("��ƽ��");
			break;
		case 11:
			if(date>=22)
				System.out.println("������");
			else
				System.out.println("��Ы��");
			break;
		case 12:
			if(date>=22)
				System.out.println("Ħ����");
			else
				System.out.println("������");
			break;
		}
	}
}