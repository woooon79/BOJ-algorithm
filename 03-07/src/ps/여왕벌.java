package ps;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 여왕벌{
	static int m,n;
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//매일 한번 자람
		//첫날 모든 애벌레 크기 1
		//0열 0행 은 입력으로 주어진만큼
		//나머지: 왼, 왼위,위 다 자란다음 제일 많이 자란만큼
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    

	    StringTokenizer st=new StringTokenizer(br.readLine());
	    m=Integer.parseInt(st.nextToken());
	    n=Integer.parseInt(st.nextToken());


	 int[][] increase=new int[m][m];
	 int[] first_rc=new int[2*m-1];
        
	 for(int i=0;i<2*m-1;i++) {
	    	Arrays.fill(first_rc, 1);
	    }
	    
	    for(int i=0;i<n;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	int n_0=Integer.parseInt(st.nextToken());
	    	int n_1=Integer.parseInt(st.nextToken());
	    	int n_2=Integer.parseInt(st.nextToken());
            
            for(int j=n_0;j<n_0+n_1;j++){
                first_rc[j]++;
            }
            for(int j=n_0+n_1;j<n_0+n_1+n_2;j++){
                first_rc[j]+=2;
            }
	    
	    }
        
        
	    
	    for(int i=0;i<m;i++) {
	    	for(int j=0;j<m;j++) {
	    		//첫번째 행일경우 + 첫번째 열이 아닐 경우 
	    		if(i==0||j!=0)
	    			bw.write(first_rc[m-1+j]+" ");
                else{
                    bw.write(first_rc[m-1-i]+" ");
                }
	    	}
	    	bw.write("\n");
	    }
        bw.flush();

	}
}