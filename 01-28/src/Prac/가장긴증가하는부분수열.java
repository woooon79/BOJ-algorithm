package Prac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열 {
	static int[] result;
	static int[] arr;
	
	public static void go(int p) {
		if(p==-1)
			return;
		go(result[p]);
		System.out.print(arr[p]+" ");
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    int num=Integer.parseInt(br.readLine());
	    arr=new int[num];
	    int[] dp=new int[num];
	    
	    
	    result=new int[num];
	    
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    for(int i=0;i<num;i++) {
	    	arr[i]=Integer.parseInt(st.nextToken());
	    	dp[i]=1;
	    	result[i]=-1;
	    }
	    int answer=0;
	    int answer_i=0;
	    
	    for(int i=0;i<num;i++) {
	    	
	    	for(int j=i;j>=1;j--) {
	    	if(arr[i]>arr[j-1]) {
	    	if(dp[i]<dp[j-1]+1) {
	    		dp[i]=dp[j-1]+1;
	    	    result[i]=j-1;
	    	}
	    	}

	    	}

	    	if(dp[i]>answer) {
	    		answer=dp[i]; 
	    		answer_i=i;
	    	}
	    	
	    }
	    
	    
	    //bw.write(answer+"\n");
	    System.out.println(answer);
	    go(answer_i);
	   
	}
}
