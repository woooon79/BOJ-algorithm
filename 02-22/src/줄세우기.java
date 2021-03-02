import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄세우기 {
	static int n,m;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//65+0=a

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    n=Integer.parseInt(st.nextToken());
	    m=Integer.parseInt(st.nextToken());
	    //indegree는 자신을 가리키고 있는 화살표의 수
	    int[] indegree=new int[n+1];
	    ArrayList<Integer>[] lst=new ArrayList[n+1];
	    
	    for(int i=1;i<=n;i++) {
	    	lst[i]=new ArrayList<Integer>();
	    }
	    
	 
	    for(int i=0;i<m;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	int a=Integer.parseInt(st.nextToken());
	    	int b=Integer.parseInt(st.nextToken());
	    	
	    	lst[a].add(b);
	    	indegree[b]++;
	   
	    }
	    
	    Queue <Integer> q=new LinkedList<Integer>();
	    
	    for(int i=1;i<=n;i++) {
	    	//나를 가리키는 화살표가 아무것도 없는 경우
	    	//내앞에 아무것도 오지 않는 경우 또는 조건이 없는 경우 큐에 삽입
	    	
	    	if(indegree[i]==0)
	    		q.offer(i);
	    }
	    
	    while(!q.isEmpty()) {
	    	  int now=q.poll();
	          System.out.print(now+" ");
	          //만약에 큐에서 뽑은 번호중, 조건이 있는경우 (뒤에 수가 오는 경우)
	          for(int i=0;i<lst[now].size();i++) {
	        	  int next=lst[now].get(i);
	        	  indegree[next]--;
	        	  if(indegree[next]==0)
	        		  q.offer(next);
	          }
	    }
	    
}
}
