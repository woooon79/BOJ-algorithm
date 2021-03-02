import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 계단오르기_2579 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	   int num=Integer.parseInt(br.readLine());
	   
	   int[] stairs=new int[301];
	   int[] dp=new int[301];
	   
	   for(int i=0;i<num;i++) {
		   stairs[i]=Integer.parseInt(br.readLine());
	   }
	   //첫번째 계단
	   dp[0]=stairs[0];
	   //두번째계단 / 첫번째계단 + 두번째 계단 비교해서 큰 값
	   dp[1]=Math.max(stairs[0]+stairs[1],stairs[1]);
	   //첫번째계단+세번쨰 계단 / 두번째계단+세번째계단 비교해서 큰 값
	   dp[2]=Math.max(stairs[0]+stairs[2],stairs[1]+stairs[2]);
	   
	   for(int i=3;i<num;i++) {
		   //전전 계단+현재계단 / 전계단+현재계단+전전전전계단(연속 세 계단 x) 경우 비교해서 큰 값
		   dp[i]=Math.max(dp[i-2]+stairs[i], dp[i-3]+stairs[i-1]+stairs[i]);
		   
	   }
	   System.out.println(dp[num-1]);
	   //bw.write(dp[num-1]);
	   //bw.flush();
	   bw.close();
	   br.close();
	   
	}
}
