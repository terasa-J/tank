//��̬��ϰ
import java.util.Scanner;
public class Text02 {
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		//a=year, b= month, c=date 
		int a=0,b=0,c=0,d=0,e=0,i=0;
		while(i==0)
		{
			Scanner reader=new Scanner(System.in);
			System.out.print("��������ݣ�");
			a=reader.nextInt();
			if(a%4==0&&a%100!=0||a%400==0)//����
			{
				e=29;
			}
			else//������
			{
				e=28;
			}
			System.out.print("�������·ݣ�");
			b=reader.nextInt();
			System.out.print("���������ڣ�");
			c=reader.nextInt();
			if(a<0||b<=0||c<=0||b>12||c>31)
			{
				System.out.println("�������������������������");
				continue;
			}
			if(b==4||b==6||b==9||b==11)
			{
				if(c>30)
				{
					System.out.println("�������������������������");
				}
			}
			if(b==2)
			{
				if(c>e)
				{
					System.out.println("�������������������������");
				}
			}
			break;
		}
		
		System.out.println("�����������Ϊ��"+a+"��"+b+"��"+c+"��");
		b=b-1;
		while(b!=0)
		{
			if(b==1||b==3||b==5||b==7||b==8||b==10||b==12)
			{
				d=d+31;
				b--;
			}
			else if(b==4||b==6||b==9||b==11)
			{
				d=d+30;
				b--;
			}
			else if(b==2)
			{
				d=d+e;
				b--;
			}
			}
			d=d+c;
			System.out.println("��ѯ����Ϊ����ĵ�"+d+"��");
	}
}
