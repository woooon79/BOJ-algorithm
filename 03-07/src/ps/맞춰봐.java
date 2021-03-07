package ps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class ¸ÂÃçºÁ{
	static int n;
    static int[] result;
    
    static boolean chk(int[][] sign,int idx) {
    	int sum=0;
    	for(int i=idx;i>=0;i--) {
    	     sum+=result[i];
    	     
    	     if(!(sign[i][idx]>0&&sum>0||sign[i][idx]<0&&sum<0||sign[i][idx]==0&&sum==0)) {
    	    	 return false;
    	     }
    	 
    		
    	}
    	return true;
    }
    
	static  boolean solution(int[][] sign,int idx) {
		
		
		if(idx==n) {
		
				return true;
		}
		
		if(sign[idx][idx]==0) {
			result[idx]=0;
			//if(chk(sign,idx))
			//chk(sign,idx)&&
			 return solution(sign,idx+1);
		}
		else if(sign[idx][idx]>0) {
			for(int i=1;i<=10;i++) {
				result[idx]=i;
				//if(chk(sign,idx)&& solution(sign,idx+1))
				// return true;
				if(chk(sign,idx) )
					 return solution(sign,idx+1);
			}
		}
		else {
			for(int i=-10;i<0;i++) {
				result[idx]=i;
				if(chk(sign,idx) )
					 return solution(sign,idx+1);
			}
		}
		
		return false;
			
		

			
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    

	    StringTokenizer st=new StringTokenizer(br.readLine());
	    n=Integer.parseInt(st.nextToken());
        
	    int len=n*(n+1)/2;
	    char[] arr=new char[len];
	    arr=br.readLine().toCharArray();
	    
	    result=new int[n];
	   int[][] sign=new int[n][n];

	    Arrays.fill(result, -1);
	    
	    
	    int c=0;
	    for(int i=0;i<n;i++) {
	    	for(int j=i;j<n;j++) {
	    		if(arr[c]=='+') {
	    			sign[i][j]=1;
	    		}
	    		else if(arr[c]=='-') {
	    			sign[i][j]=-1;
	    		}
	    		else {
	    			sign[i][j]=0;
	    		}
	    		c++;
	    	}
	    }


			solution(sign,0);

			for (int i=0; i<n; i++) {
	            System.out.print(result[i] + " ");
	        }
	        System.out.println();
	    
	    
	}
	    

}