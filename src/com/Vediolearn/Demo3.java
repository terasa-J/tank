/**�򵥰��ƽ�г��������� */
package com.Vediolearn;
import java.util.Scanner;
public class Demo3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader=new Scanner(System.in);
		Maria maria=new Maria();
		System.out.println("������1-25���һ�����ֽ����ƶ��ϸ��裨��֮���˳�����");
		int i=reader.nextInt();
		for(int a=i;a<=25;a--){
			if(i<25){
				maria.move(i);
				i=reader.nextInt();
			}
			else{
				System.out.println("Game over!");
				break;
			}
		}
	}

}
class Maria{
	public Maria(){
		System.out.println("�����ϸ���:@");
	}
	public void move(int i){
		for(int a=1;a<=25;a++){
			if(a==i)
				System.out.printf("@");
			else
				System.out.printf(".");
		}
	}
		
}

