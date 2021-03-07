package ps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class 맞춰봐{
	static int n;
    static int[] result;
    
    static boolean chk(int[][] sign,int idx) {
    	int sum=0;
    	//업데이트한 인덱스까지 합구하면서 비교
    	//만약 idx가 2라면 
    	//sign[2][2],sign[1][2],sign[0][2] 세개 값 비교 
    	
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
		
		//sign[x][x]의 부호를 보고, result[x]값의 부호를 알수 있다
		if(sign[idx][idx]==0) {
			result[idx]=0;
			 return solution(sign,idx+1);
		}
		
		else if(sign[idx][idx]>0) {
			//1~10
			for(int i=1;i<=10;i++) {
				result[idx]=i;
				//idx 인덱스까지 합과 sign부호 비교하며 검사 
				 
				if(chk(sign,idx)&& solution(sign,idx+1))
				   return true;
			}
		}
		else {
			for(int i=-10;i<0;i++) {
				result[idx]=i;
				if(chk(sign,idx)&& solution(sign,idx+1))
					   return true;
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
        
	    //문자열 arr에 입력받음
	    int len=n*(n+1)/2;
	    char[] arr=new char[len];
	    arr=br.readLine().toCharArray();
	    
	    //결과 배열
	    result=new int[n];
	    
	    //arr 2차원 배열에 다시 삽입
	   int[][] sign=new int[n][n];

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


			if(solution(sign,0)) {

			for (int i=0; i<n; i++) {
	            System.out.print(result[i] + " ");
	        }
	        System.out.println();
			}
	    
	}
	    

}