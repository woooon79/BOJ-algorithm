package Prac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Chkpoint{
	int x,y;
	Chkpoint(int x,int y){
		this.x=x;
		this.y=y;
	}
}
public class ∏∂∂Û≈Ê1 {

       public static int len(Chkpoint now,Chkpoint last) {
    	   return Math.abs(now.x-last.x)+Math.abs(now.y-last.y);
       }

		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		    
		    int num=Integer.parseInt(br.readLine());
		    Chkpoint[] arr=new Chkpoint[num];
		    int[] len=new int[num];
		    int[] check=new int[num];
		    
		    Chkpoint last=null;
		    int max=-1;int max_i=0;
		    int max_j=0,jump;
		    int total=0;
		    
		    for(int i=0;i<num;i++) {
		    	StringTokenizer st=new StringTokenizer(br.readLine());
		    	int x=Integer.parseInt(st.nextToken());
		    	int y=Integer.parseInt(st.nextToken());
		    	Chkpoint now=arr[i]=new Chkpoint(x,y);
		    	
		    	if(i!=0) {
		    	    len[i]=len(now,last);
		    	    total+=len[i];
		    	    //System.out.println(len[i]);
		    	}
		    	last=now;
		   
		    	
		    	if(i>=2) {
		    		jump=len(arr[i-2],now);
		    		check[i-1]=(len[i-1]+len[i])-jump;

		    		if(check[i-1]>max) {
		    			max=check[i-1];
		    			max_i=i-1;
		    			max_j=jump;
		    		}
		    	}
		    	
		    }
		    max=total-(len[max_i]+len[max_i+1]-max_j);
		    System.out.println(max);
		    
	}

}
