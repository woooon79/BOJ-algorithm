import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Index{
	int i,j;
	Index(int i,int j){
		this.j=j;
		this.i=i;
	}
}
public class »§Áý {

	static boolean[][] chk;
    static int row,col;
    static int result=0;

    
    static void dfs() {
        Stack <Index> s=new Stack <Index>();

        int next=0;

        s.push(new Index(0,0));
        
        while(!s.isEmpty()) {
        	Index tmp=s.pop();
 
        	int i=tmp.i;
        	int j=tmp.j;
        	
        	chk[i][j]=true;
        	
        	
        	if(j==col-1) {
        		result++;
        	}
        	
        	if(j+1<=col-1) {
        		if(i+1<row&&!chk[i+1][j+1]) {
    				s.push(new Index(i+1,j+1)); 		
    			}
        		if(!chk[i][j+1]) {
    				s.push(new Index(i,j+1));			
    			}
    			if(i-1>=0&&!chk[i-1][j+1]) {
    				s.push(new Index(i-1,j+1));
    			}
    	
    	
        	}
    
        	if(j==col-1||s.isEmpty()) {
        		s.clear();
        		if(++next<row)
        		s.push(new Index(next,0));
        		else
        			break;
        	}

        }
    	
    }
    
  
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	   StringTokenizer st=new StringTokenizer(br.readLine());
	   row=Integer.parseInt(st.nextToken());
	   col=Integer.parseInt(st.nextToken());
	   

	 chk=new boolean[row][col];
	 
	   for(int i=0;i<row;i++) {
		   String tmp=br.readLine();
		   for(int j=0;j<col;j++) {
  
			   if(tmp.charAt(j)=='x') {
				   chk[i][j]=true;
			   }
			  
		   }
	   }
	   dfs();
	   System.out.print(result);
	   
	    
	}
}
