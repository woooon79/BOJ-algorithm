import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class µ¿¹°¿ø {
	static int[][] d;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		 int n=Integer.parseInt(br.readLine());
		 d=new int[n+1][3];
		 
		 d[1][0]=1;
		 d[1][1]=1;
		 d[1][2]=1;
		 
		 for(int i=2;i<n+1;i++) {
			 d[i][0]=d[i-1][2]+d[i-1][1]+d[i-1][0];
			 d[i][1]=d[i-1][0]+d[i-1][2];
			 d[i][2]=d[i-1][0]+d[i-1][1];
			 
			 //d[i][1]%=9901;
			// d[i][2]%=9901;
		 }
		 int result=0;
		 for(int i=1;i<=n;i++)
		     result+=d[i][0]+d[i][1]+d[i][2];
		 
		 System.out.println(d[n][0]+d[n][1]+d[n][2]%9901);
		 
	}
}
