import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 통나무건너뛰기_11497 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    int test=Integer.parseInt(br.readLine());
	    for(int i=0;i<test;i++) {
	    	int num=Integer.parseInt(br.readLine());
	    	int[] arr=new int[num];
	    	PriorityQueue<Integer> q=new PriorityQueue<Integer>();
	    	StringTokenizer st=new StringTokenizer(br.readLine());
	    	for(int j=0;j<num;j++) {
	    		int tmp=Integer.parseInt(st.nextToken());
	    		q.offer(tmp);
	    	}
	    	
	    	int k=0;
	    	int b1=q.poll();
	    	int b2=q.poll();
	    	
	    	int result=(int)Math.abs(b1-b2);
	    	
	    	while(!q.isEmpty()) {
	    		int n=q.poll();
	    		if(k%2==0) {
	    			if(result<(int)Math.abs(b1-n) )
	    				result=(int)Math.abs(b1-n);
	    		    b1=n;
	    		}
	    		else {
	    			if(result<(int)Math.abs(b2-n) )
	    				result=(int)Math.abs(b2-n);
	    			b2=n;
	    			
	    		}
	    		k++;
	    	}
	    	if(result<(int)Math.abs(b2-b1) )
				result=(int)Math.abs(b2-b1);
	    	
	    	System.out.println(result);
    	
	    	
	    }
	   
	    
	}
}
