import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 스타트링크 {
	static int F,S,G,U,D;
	static boolean[] chk;
	static int[] time;
	
	public static int bfs() {
		int result=-1;
		
		Queue <Integer> q=new LinkedList <Integer>();
		q.offer(S);
		while(!q.isEmpty()) {
			int floor=q.poll();
			
			if(floor==G) {
				result=time[floor];
				break;
			}
			
			if(U!=0&&floor+U<=F&&!chk[floor+U]) {
				time[floor+U]=time[floor]+1;
				chk[floor+U]=true;
				q.offer(floor+U);
			}
			
			if(D!=0&&floor-D>=1&&!chk[floor-D]) {
				time[floor-D]=time[floor]+1;
				chk[floor-D]=true;
				q.offer(floor-D);
			}
			
			
		}
		return result;
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    F=Integer.parseInt(st.nextToken());
	    S=Integer.parseInt(st.nextToken());
	    G=Integer.parseInt(st.nextToken());
	    U=Integer.parseInt(st.nextToken());
	    D=Integer.parseInt(st.nextToken());
	    
	    chk=new boolean[F+1];
	    time=new int[F+1];
	    
	   
	    int result=bfs();
	    if(result==-1)
	        System.out.println("use the stairs");
	    else
	    	System.out.println(result);
	    
	}
}
