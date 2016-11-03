/**
 观察下面的现象,某个数字的立方，按位累加仍然等于自身。
1^3 = 1 
8^3  = 512    5+1+2=8
17^3 = 4913   4+9+1+3=17
...
请你计算包括1,8,17在内，符合这个性质的正整数一共有多少个？ 
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
