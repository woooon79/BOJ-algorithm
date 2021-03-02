import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Index{
	int i,j;
	Index(int i,int j){
		this.i=i;
		this.j=j;
	}
	Index() {
		// TODO Auto-generated constructor stub
	}
}
public class 욕심쟁이판다_1937 {
	static BufferedReader br;
	static BufferedWriter bw;
	static int num;
	static int[][] map;
	static int[][] dp;
	static int[] dx= {0,0,1,-1};
	static int[] dy= {1,-1,0,0};
	public static int dfs(int i,int j) {
		//0값이 아니면 계산할 필요없이 dp값 리턴
	    if (dp[i][j] != 0) {
            return dp[i][j];
        }
	    //하루는 생존가능
	    dp[i][j]=1;
	   
	    	//동서남북 검사
	    	for(int k=0;k<4;k++) {
	    		int ni=i+dx[k];
	    		int nj=j+dy[k];
	    		
	    		if(ni>=0 && ni<num && nj>=0 && nj<num) {
	    			//만약 새로운위치값이 현재위치의 값보다 크다면
	    			if(map[ni][nj]>map[i][j]) {
	    				
	    				dp[i][j]=Math.max(dp[i][j],dfs(ni,nj)+1);
	    				
	    			}
	    		}
	    	
	    	
	    }
	    
	    return dp[i][j];
	    
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
    	bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	br =new BufferedReader(new InputStreamReader(System.in));
	    num=Integer.parseInt(br.readLine());
	    StringTokenizer st;
	    map=new int[num][num];
	    dp=new int[num][num];
	    
	    for(int i=0;i<num;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	for(int j=0;j<num;j++) {
	    		map[i][j]=Integer.parseInt(st.nextToken());
	    	}
	    }

	    int result=0;
	    for(int i=0;i<num;i++) {
	    	for(int j=0;j<num;j++) {
	    		int tmp=dfs(i,j);
	    		if(result<tmp)
	    			result=tmp;
	    	}
	    }
	    
	    
	    System.out.println(result);
	    /*bw.write(stay());
	    bw.flush();
	    bw.close();
	    br.close();*/
	}
}
