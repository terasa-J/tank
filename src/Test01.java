/**
 �۲����������,ĳ�����ֵ���������λ�ۼ���Ȼ��������
1^3 = 1 
8^3  = 512    5+1+2=8
17^3 = 4913   4+9+1+3=17
...
����������1,8,17���ڣ�����������ʵ�������һ���ж��ٸ��� 
 */
public class Test01 {
//	public static void solve(){
//		
//	}
//	static long N,M;
//	static long[] num=null;
	public static void main(String[] args) {
		long ans=0;
		for(long n=1;n<10000;n++){
			long tot=n*n*n;
			long cmp=0;
			long t=tot;
			
			while(t!=0){
				cmp += t%10;
				t /= 10;
			}
			
			if(cmp==n){
				ans++;
				System.out.println("answer:"+ans);
			}
		}

	}

}
