package com.Vediolearn;
//���ӳ��ң�ѧϰ�㷨
import java.util.Scanner;

public class Demo2_2 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
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
			return (peach(day+1,sday)+1)*2;  //�ؼ����裬�㷨�Ƶ���
	}
	public void scan()
	{
		int a=1;
		System.out.println("������Ҫ�Ե�������");
		Scanner reader=new Scanner(System.in);
		int b=reader.nextInt();
		if(a<b)
		{
			System.out.println(peach(a,b));
		}
		else
		{
			System.out.println("����С�ڻ����1");
			scan();
		}
	}
}
