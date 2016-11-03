import java.util.Scanner;
public class Commision {
	public static void main(String[] args) {
		int stocks,barrels,locks;  //枪托（stocks）25、枪管（barrels）30、枪机（locks)45
		int totalSale; //销售总额
		double commison=0; //佣金
		Boolean isLegal=true;
		Scanner reader =new Scanner(System.in);
		System.out.println("请输入枪托（stocks）销售数量:");
		stocks=reader.nextInt();
		System.out.println("请输入枪管（barrels）销售数量:");
		barrels=reader.nextInt();
		System.out.println("请输入枪机（locks)销售数量，输入-1程序结束:");
		locks=reader.nextInt();
		if(stocks==-1){
			System.out.println("输入不合理，程序结束");
			isLegal=false;
		}
		if(barrels==-1){
			System.out.println("输入不合理，程序结束");
			isLegal=false;
		}
		if(locks==-1){
			System.out.println("程序结束");
			System.exit(-1);
		}
		totalSale=stocks*25+barrels*30+locks*45;
		//输入合理再运算
		if(isLegal){
			if(totalSale<=1000){
				commison=totalSale*0.1 ;
			}else if(1000<totalSale && totalSale<=1800){
				commison=(1000*0.10)+(totalSale-1000)*0.15 ;
			}else {
				commison=(1000*0.10)+(800*0.15)+(totalSale-1800)*0.2 ;
			}
		}
		System.out.println("应交佣金为:"+commison);
	}

}

