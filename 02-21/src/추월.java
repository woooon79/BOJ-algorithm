import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ãß¿ù {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//65+0=a

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    int num=Integer.parseInt(br.readLine());
	    LinkedList<String> lst=new LinkedList<String>();
	    Queue<String> exit_q=new LinkedList<String>();

	    
	    for(int i=0;i<num;i++) {
	    	
	    	lst.add(br.readLine());

	    	
	    }
        for(int i=0;i<num;i++) {
        	exit_q.offer(br.readLine());

	    }
	   int result=0;

	   

	   while(!exit_q.isEmpty()) {
		   String tmp=exit_q.poll();
		   if(lst.get(0).equals(tmp)) {
			   lst.remove(0);
		   }
		   else {
			   result++;
			   lst.remove(lst.indexOf(tmp));
		   }
		  
	   }
   
	   System.out.println(result);
	   
	}
}
