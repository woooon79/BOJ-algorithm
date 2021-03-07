package ps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호만들기 {
    static int l,c;
    static void count(char[] arr,int idx,String word,int v,int con) {
    	//=new StringBuilder(word);
    	
    	if(word.length()>=l) {
    	  	if(v>0&&con>1)
        		System.out.println(word);
    		return;
    	}
    	
    
    	for(int i=idx;i<c;i++) {
        	
	    	char next=arr[i];
	    	
	    	String tmp=word+Character.toString(next);
	    	
	    	//System.out.println(tmp);
	    	
	    	if(next=='a'||next=='e'||next=='i'||next=='o'||next=='u') 
	    		count(arr,i+1,tmp,v+1,con);
	    	
	    	else
	    		count(arr,i+1,tmp,v,con+1);

	    }
    
  
	    
    }
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    

	    StringTokenizer st=new StringTokenizer(br.readLine());
	    l=Integer.parseInt(st.nextToken());
	    c=Integer.parseInt(st.nextToken());
	    
	    char[] arr=new char[c];

	  	st=new StringTokenizer(br.readLine());
	    for(int i=0;i<c;i++) {
	    	arr[i]=st.nextToken().charAt(0);
	    }
	    
	    Arrays.parallelSort(arr);

	    
	  
	    	count(arr,0,"",0,0);
	    
	    
	}
}
