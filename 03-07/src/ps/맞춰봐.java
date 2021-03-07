package ps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class �����{
	static int n;
    static int[] result;
    
    static boolean chk(int[][] sign,int idx) {
    	int sum=0;
    	//������Ʈ�� �ε������� �ձ��ϸ鼭 ��
    	//���� idx�� 2��� 
    	//sign[2][2],sign[1][2],sign[0][2] ���� �� �� 
    	
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
		
		//sign[x][x]�� ��ȣ�� ����, result[x]���� ��ȣ�� �˼� �ִ�
		if(sign[idx][idx]==0) {
			result[idx]=0;
			 return solution(sign,idx+1);
		}
		
		else if(sign[idx][idx]>0) {
			//1~10
			for(int i=1;i<=10;i++) {
				result[idx]=i;
				//idx �ε������� �հ� sign��ȣ ���ϸ� �˻� 
				 
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
        
	    //���ڿ� arr�� �Է¹���
	    int len=n*(n+1)/2;
	    char[] arr=new char[len];
	    arr=br.readLine().toCharArray();
	    
	    //��� �迭
	    result=new int[n];
	    
	    //arr 2���� �迭�� �ٽ� ����
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