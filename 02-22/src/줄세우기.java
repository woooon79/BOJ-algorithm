import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class �ټ���� {
	static int n,m;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//65+0=a

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    n=Integer.parseInt(st.nextToken());
	    m=Integer.parseInt(st.nextToken());
	    //indegree�� �ڽ��� ����Ű�� �ִ� ȭ��ǥ�� ��
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
	    	//���� ����Ű�� ȭ��ǥ�� �ƹ��͵� ���� ���
	    	//���տ� �ƹ��͵� ���� �ʴ� ��� �Ǵ� ������ ���� ��� ť�� ����
	    	
	    	if(indegree[i]==0)
	    		q.offer(i);
	    }
	    
	    while(!q.isEmpty()) {
	    	  int now=q.poll();
	          System.out.print(now+" ");
	          //���࿡ ť���� ���� ��ȣ��, ������ �ִ°�� (�ڿ� ���� ���� ���)
	          for(int i=0;i<lst[now].size();i++) {
	        	  int next=lst[now].get(i);
	        	  indegree[next]--;
	        	  if(indegree[next]==0)
	        		  q.offer(next);
	          }
	    }
	    
}
}
