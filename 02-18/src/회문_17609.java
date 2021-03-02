import java.io.*;

public class È¸¹®_17609 {
	
	static int check(String str,boolean chk) {
		int len=str.length();
    	int k=0;
    	int p=len-1;
    	int result=0;
    	while(k<p) {
    			
    		if(str.charAt(k)!=str.charAt(p)) {
    			if(chk==false) {
    				chk=true;
    			result=2;
    			if(str.charAt(k+1)==str.charAt(p)) {
    				result=check(str.substring(k+1,p+1),chk); 
    				}
    				
    				
    			if(result!=1&&str.charAt(k)==str.charAt(p-1)) {
    				result=check(str.substring(k,p),chk);
    			}
  		
    			return result;
    		  }
    		   else
    			 return 2;
    		}
    		
    		k++;
    		p--;
    	}
    	if(chk==true)
    		return 1;
    	
    	else
    		return 0;
    	}

		
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    int num=Integer.parseInt(br.readLine());
	    for(int i=0;i<num;i++) {
	    	String str=br.readLine();
	    	int len=str.length();
	    	int k=0;
	    	int p=len-1;
	    	int result=0;

	    	System.out.println(check(str,false));
	    }
	}
}

