/** �����������ϰ */
package com.Vediolearn;

import java.util.Scanner;

public class Demo5_2 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Dog dogs[]=new Dog[4];
		Scanner reader=new Scanner(System.in);
		for(int i=0;i<dogs.length;i++)
		{
			dogs[i]=new Dog();
			System.out.println("�������"+(i+1)+"ֻ��������:");
			String name=reader.nextLine();
			dogs[i].setName(name);
			
			System.out.println("�������"+(i+1)+"ֻ��������:");
			String s_weight=reader.nextLine();
			dogs[i].setWeigtht(Float.parseFloat(s_weight));
			
			
		}
		float all=0;
		for(int i=0;i<dogs.length;i++)
		{
			all+=dogs[i].getWeigtht();
		}
		System.out.println("С�����������ǣ�"+all+"  "+"ƽ�������ǣ�"+(all/dogs.length));
	}
}
class Dog
{
	private String name="";
	private float weigtht=0;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getWeigtht() {
		return weigtht;
	}
	public void setWeigtht(float weigtht) {
		this.weigtht = weigtht;
	}
}
