package com.Vediolearn;
/**
	���ӳ�������
*/
import java.util.*;//���ذ�
public class Demo2{
	public static void main(String []args){
		Monkey mo=new Monkey();
		mo.scan();
	}
}

class Monkey{
	//day�������������sday���˶�����ʣ��һ��
	public static int peach(int day,int sday){//��һ��peach����
		if(day==sday){
			return 1;
		}else{
			return (peach(day+1,sday)+1)*2;//�㷨����ֵ
		}
	}
	public static void scan(){ //��������ķ���
		int a=1;
		System.out.println("������Ҫ�Լ��죺");
		Scanner sr=new Scanner(System.in);
		int b=sr.nextInt();
		if(a<b){
			System.out.print(Monkey.peach(a,b));
		}else{
			System.out.println("����С�ڵ���1��");
			Monkey.scan();
		}
	}
}