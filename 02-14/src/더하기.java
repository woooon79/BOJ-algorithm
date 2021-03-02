import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ¥ı«œ±‚ {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    int num=Integer.parseInt(br.readLine());
        long[] d=new long[1000001];
	    	d[0]=1;
	    	for(int j=1;j<1000001;j++) {
	    		if(j-1>=0)
	    		    d[j]+=d[j-1];
	    	    if(j-2>=0)
	    	    	d[j]+=d[j-2];
	    	    if(j-3>=0)
	    	    	d[j]+=d[j-3];
	    	    
	    	    d[j]%=1000000009;
	    	}
	    	
	    for(int i=0;i<num;i++) {
	    	int n=Integer.parseInt(br.readLine());
	    	
	    	System.out.println(d[n]);
	    	
	    }
	}
}
