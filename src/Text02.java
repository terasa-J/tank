//多态练习
import java.util.Scanner;
public class Text02 {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//a=year, b= month, c=date 
		int a=0,b=0,c=0,d=0,e=0,i=0;
		while(i==0)
		{
			Scanner reader=new Scanner(System.in);
			System.out.print("请输入年份：");
			a=reader.nextInt();
			if(a%4==0&&a%100!=0||a%400==0)//闰年
			{
				e=29;
			}
			else//非闰年
			{
				e=28;
			}
			System.out.print("请输入月份：");
			b=reader.nextInt();
			System.out.print("请输入日期：");
			c=reader.nextInt();
			if(a<0||b<=0||c<=0||b>12||c>31)
			{
				System.out.println("你输入的日期有误，请重新输入");
				continue;
			}
			if(b==4||b==6||b==9||b==11)
			{
				if(c>30)
				{
					System.out.println("你输入的日期有误，请重新输入");
				}
			}
			if(b==2)
			{
				if(c>e)
				{
					System.out.println("你输入的日期有误，请重新输入");
				}
			}
			break;
		}
		
		System.out.println("你输入的日期为："+a+"年"+b+"月"+c+"日");
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
			System.out.println("查询日期为那年的第"+d+"天");
	}
}
