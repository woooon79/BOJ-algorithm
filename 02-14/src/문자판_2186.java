import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ¹®ÀÚÆÇ_2186 {
	
	private static int[] di= {-1,1,0,0};
	private static int[] dj= {0,0,-1,1};
	private static int[][][] dp;
	private static int N,M,K;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    N=Integer.parseInt(st.nextToken());
	    M=Integer.parseInt(st.nextToken());
	    K=Integer.parseInt(st.nextToken());
	    char[][] map=new char[N][M];
	    
	    for(int i=0;i<N;i++) {
	    	map[i]=br.readLine().toCharArray();
	    }
	    
	    char[] word=br.readLine().toCharArray();
	    dp=new int[N][M][word.length];
	    
	    for(int i=0;i<N;i++) {
	    	for(int j=0;j<M;j++) {
	    		Arrays.fill(dp[i][j], -1);
	    	}
	    }
	    
	    int cnt=0;
	    
	    for(int i=0;i<N;i++) {
	    	for(int j=0;j<M;j++) {
	    		if(map[i][j]==word[0])
	    			cnt+=dfs(map,word,i,j,0);
	    	}
	    }
	    
	    
	}
	
	
	static int dfs(char[][] map,char[] word,int i,int j, int depth) {
		if(dp[i][j][depth]!=-1)
			return dp[i][j][depth];
		
		if(depth==word.length-1)
			return 1;
		int cnt=0;
		
		for(int a=1;a<=K;a++) {
			for(int b=0;b<4;b++) {
				int next_i=i+di[b]*a;
				int next_j=j+di[b]*a;
				
				if(next_i>0&&next_i<N&&next_j>0&&next_j<M) {
					if(map[next_i][next_j]==word[depth+1])
						cnt+=dfs(map,word,next_i,next_j,depth+1);
				}
			}
		}
		
		return dp[i][j][depth]=cnt;
		
	}
}
