import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 가르침 {
	static boolean[] alpha=new boolean[26];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    StringTokenizer st=new StringTokenizer(br.readLine());

	    int num=Integer.parseInt(st.nextToken());
	    int k=Integer.parseInt(st.nextToken());
	    if(k<5) {
	    	System.out.println(0);
	    	return;
	    }
	    else if(k==26) {
	    	System.out.println(num);
	    	return;
	    }
	    
	    
	    String[] arr=new String[num];
	    for(int i=0;i<num;i++) {
	    	String tmp=br.readLine();
	    	arr[i]=tmp.substring(4,tmp.length()-4);
	    }
	    
	  //아스키코드 97 a
	    int m=5;
	    alpha[0]=true;
	    alpha[2]=true;
	    alpha[8]=true;
	    alpha[13]=true;
	    alpha[19]=true;
	    
	   
	    
	    
	    
	    	
	    
	    		
	    
	}

        
    }

