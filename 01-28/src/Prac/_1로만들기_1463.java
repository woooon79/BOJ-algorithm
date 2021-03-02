package Prac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1로만들기_1463 {
	static int[] dp;
	/*
	static int make_1(int num) {
		if(num==1) return 0;
		if(dp[num]>0) {
			return dp[num];
		}
		
		dp[num]=make_1(num-1)+1;
		
		if(num%2==0) {
			dp[num]=Math.min(dp[num], make_1(num/2)+1);
		}
		if(num%3==0) {
			dp[num]=Math.min(dp[num], make_1(num/3)+1);
		}
		
		return dp[num];
	}
*/
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    int num=Integer.parseInt(br.readLine());
	    dp=new int[num+1];
	    
	    dp[1]=0;
	    for(int i=2;i<=num;i++) {
	    	//일반적으로 모든 수가 가능한 경우부터 해준뒤 비교
	    	dp[i]=dp[i-1]+1;
	    	if(i%2==0)
	    		dp[i]=Math.min(dp[i], dp[i/2]+1);
	    	if(i%3==0)
	    		dp[i]=Math.min(dp[i], dp[i/3]+1);
	    }
	    
	    System.out.print(dp[num]);
	    
	    //bw.write(make_1(num));
	    //System.out.print(make_1(num));
	    //bw.flush();
	   // bw.close();
	    //br.close();
	}

}
