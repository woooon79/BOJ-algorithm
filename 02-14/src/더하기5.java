import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ¥ı«œ±‚5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	   // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    int num=Integer.parseInt(br.readLine());
        long[][] d=new long[100001][4];
	    	
	    	
	    	for(int j=1;j<100001;j++) {
	    		
	    			if(j-1>=0) {
	    				if(j==1) {
	    					d[j][1]=1;
	    				}
	    				else
	    				d[j][1]=d[j-1][2]+d[j-1][3];
	    				
	    			}
	    			if(j-2>=0) {
	    				if(j==2) {
	    					d[j][2]=1;
	    				}
	    				else
	    				d[j][2]=d[j-2][1]+d[j-2][3];
	    				
	    			}
	    			if(j-3>=0) {
	    				if(j==3) {
	    					d[j][3]=1;
	    				}
	    				else
	    				d[j][3]=d[j-3][1]+d[j-3][2];
	    			}
	    			
	    			 d[j][1] %= 1000000009;
	    	         d[j][2] %= 1000000009;
	    	         d[j][3] %= 1000000009;
	    		
	    	}
	    	
	    for(int i=0;i<num;i++) {
	    	int n=Integer.parseInt(br.readLine());
	    	
	    	System.out.println((d[n][1]+d[n][2]+d[n][3])%100000009);
	    	
	    }
	}
}
