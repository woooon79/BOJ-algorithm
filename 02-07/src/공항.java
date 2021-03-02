import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class °øÇ× {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    int ngate=Integer.parseInt(br.readLine());
	    int nplane=Integer.parseInt(br.readLine());
	    int[] parent=new int[ngate+1];
	    boolean[] gate=new boolean[ngate+1];
	    
	    for(int i=0;i<=ngate;i++) {
	    	parent[i]=i;
	    }
	    
	    
	    int result=0;
	    

	    int j=0;
	    
	    for(int i=0;i<nplane;i++) {
	    	int g=Integer.parseInt(br.readLine());
	    	for(j=g;j>0;j--) {
	    		if(!gate[j]) {
	    			gate[j]=true;
	    			result++;
	    			break;
	    		}
	    	}
	    	if(j==0) {
	    		break;
	    	}
	    	
	    }
	    
	    
	   
    System.out.println(result);
    	
	}
}
