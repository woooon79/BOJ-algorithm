import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class IQTest_1111 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    int num=Integer.parseInt(br.readLine());
	    
	    if(num==1) {
	    	System.out.println("A");
	    	return;
	    }
	   
	    	
	    int[] nums=new int[num];
	    
	    
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    for(int i=0;i<num;i++) {
	    	nums[i]=Integer.parseInt(st.nextToken());
	    }
	    
	    
	    if(nums[0]==nums[1]) {
	    		for(int i=0;i<num-1;i++) {
	    			if(nums[i]!=nums[i+1]) {
	    				System.out.println("B");
	    				return;
	    			}	
	    		}
	    		System.out.println(nums[0]);
	    		return;   		
	    }
	    else if(num==2) {
	    	System.out.println("A");
	    	return;
	    }
	  
	    
	    	
	    
	   int a;
	   int b;
      a=(nums[1]-nums[2])/(nums[0]-nums[1]);
      b=nums[1]-(nums[0]*a);
      
      for(int i=0;i<num-1;i++) {
    	  if((nums[i]*a+b)==nums[i+1])
    		  continue;
    	  else {
    		  System.out.println("B");
    		  return;
    	  }
    		 
      }
      System.out.println(nums[num-1]*a+b);
      

	   
	   
	}
}
