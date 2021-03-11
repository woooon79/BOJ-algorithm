import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 게리맨더링2 {
	static int n;
	static int[][] map;
	static int result=Integer.MAX_VALUE;
	
	static int divide(int x,int y,int d1, int d2) {

		boolean[][] p5=new boolean[n+1][n+1];
		
		int col1=0;
		int col2=0;
		int[] p=new int[5];
		
	for(int i=x;i<=x+d1+d2;i++) {
   
			for(int j=y-col1;j<=y+col2;j++) {
				p5[i][j]=true;
				p[4]+=map[i][j];
			}
		
			
		if(i<x+d1)
		col1++;
		if(i<x+d2)
		col2++;
		
		if(i>=x+d1)
			col1--;
		if(i>=x+d2)
			col2--;
		
		 
	}
		

		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				
				if(!p5[i][j]) {
				if(i<x+d1&&j<=y) 
					p[0]+=map[i][j];
				else if(i<=x+d2&&y<j)
					p[1]+=map[i][j];
				else if(x+d1<=i&&j<y-d1+d2)
					p[2]+=map[i][j];
				else if(x+d2<i&&y-d1+d2<=j)
					p[3]+=map[i][j];
				}

			}
		}
		
		Arrays.sort(p);
	
		return p[4]-p[0];
		
	}
    static void solve(int x,int y){
    	
    	for(int d1=1;d1<=n;d1++) {
    		if(y-d1<1)
				continue;
    		for(int d2=1;d2<=n;d2++) {
    			if(x+d1+d2>n||y+d2>n)
    				continue;
    			
    			result=Math.min(result,divide(x,y,d1,d2));
    			
    			
    		}
    	}
    	
    	
    	
    	
    	
    }
    	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		/* 죄고인구수-최저인구수의 최솟값.*/
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	   
	    n=Integer.parseInt(br.readLine());
	    map=new int[n+1][n+1];
	    for(int i=1;i<=n;i++) {
	    	StringTokenizer st=new StringTokenizer(br.readLine());
	    	for(int j=1;j<=n;j++) {
	    		map[i][j]=Integer.parseInt(st.nextToken());
	    	}
	    }

    	for(int i=1;i<=n;i++) {
    		for(int j=1;j<=n;j++) {
    			solve(i,j);
    		}
    	}
    	
    	System.out.print(result);
	    
	}
}
