import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

 class Todo implements Comparable<Todo>{
	double total;
	int num;
	
	Todo(double total,int num){
		this.total=total;
		this.num=num;
	}

	@Override
	public int compareTo(Todo o) {
		// TODO Auto-generated method stub
		if(o.total==total)
			return num-o.num;
		else
		    {
			if(o.total>total)
				return 1;
			else
				return -1;
		    }
	}
	
	
}
public class ���μ�����_14908 {
	 public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		    
		    int num=Integer.parseInt(br.readLine());
		    Todo[] tlist=new Todo[num];
		    
		    StringTokenizer st;
		    for(int i=0;i<num;i++) {
		    	st= new StringTokenizer(br.readLine());
		    	double days=Double.parseDouble(st.nextToken());
		    	double penalty=Double.parseDouble(st.nextToken());
		    	
		    	tlist[i]=new Todo(penalty/days,i+1);
		    }
		    
		    Arrays.sort(tlist);
		    
		    for(Todo tmp:tlist) {
		    	//bw.write(tmp.num+" ");
		    	System.out.print(tmp.num+" ");
		    }
		    
		
		    
		   // bw.flush();
		    bw.close();
		    br.close();
		    
	 }
}
