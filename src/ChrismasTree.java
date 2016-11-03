
public class ChrismasTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] hang={1,3,5,3,5,7,3,5,7,11,3,3,3};
		 String star="*";
		 String result="";
		 System.out.println("Merry Christma：");
		 for(int i=0;i<hang.length;i++){
			 //没执行完一次之后就把rusult归零
			 result="";
			 //空格
			 for(int j=0;j<20-hang[i]/2;j++){
				 result+=" ";
			 }
			 for(int j=0;j<hang[i];j++){
				 result+=star;
			 }
			 //换行
			 result+="\n";
			 System.out.print(result);
		 }

	}

}
