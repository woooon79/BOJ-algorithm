import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ÇÕºÐÇØ {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    int N= Integer.parseInt(st.nextToken());
	    int K=Integer.parseInt(st.nextToken());
	    
	    int[][] D=new int[K+1][N+1];
	    D[0][0]=1;
	    for(int i=1;i<=K;i++) {
	    	for(int j=0;j<=N;j++) {
	    		for(int k=0;k<=j;k++) {
	    			D[i][j]+=D[i-1][j-k];
	    			D[i][j]%=1000000000;
	    		}
	    	}
	    }
	    System.out.println(D[K][N]);
	}
}
