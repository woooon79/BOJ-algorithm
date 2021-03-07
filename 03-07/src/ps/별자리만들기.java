package ps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 class Node implements Comparable<Node>{
	double x,y;
	double dist;
	int number;
	Node(double x,double y,int number){
		this.x=x;
		this.y=y;
		this.number=number;
	}
	Node(double x,double y,int number,double dist){
		this.x=x;
		this.y=y;
		this.number=number;
		this.dist=dist;
	}
	public int compareTo(Node o) {
		return (int)(this.dist-o.dist);
	}
}
public class 별자리만들기 {
	static int n;
	public static double distance(Node first,Node second) {
		return Math.sqrt(Math.pow(first.x-second.x,2)+Math.pow(first.y-second.y,2));
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    

	    n=Integer.parseInt(br.readLine());
	    Node[] stars=new Node[n];
	    
	    //MST
	    for(int i=0;i<n;i++) {
    
		    StringTokenizer st=new StringTokenizer(br.readLine());
	    	double x=Double.parseDouble(st.nextToken());
	    	double y=Double.parseDouble(st.nextToken());
	    	//x좌표,y좌표,별 번호
	    	stars[i]=new Node(x,y,i);
	    }
	    //dist 오름차순 poll 우선순위 큐
	    PriorityQueue<Node> q=new PriorityQueue<Node>();
	    double result=0;
	   boolean[] visit=new boolean[n];
	    //첫번째 별
	    q.offer(new Node(stars[0].x,stars[0].y,0));
	    
	    while(!q.isEmpty()) {
	    	Node tmp=q.poll();
	    	//방문한 별이라면 continue
	    	if(visit[tmp.number])
	    		continue;
	    	//방문
	    	visit[tmp.number]=true;
	    	//결과에 dist 더함
	    	result=result+tmp.dist;
	    	
	    	//다른 별들을 방문
	    	for(int i=0;i<n;i++) {
	    		//방문했던 별이면 continue
	    		if(visit[i])
	    			continue;
	    		//현재 별과 해당 별의 거리 구해서 q에 push
	    		double dist= distance(tmp,stars[i]);
	    		q.offer(new Node(stars[i].x,stars[i].y,i,dist));
	    		
	    	}
	    	
	    }
	    //다 방문했다면 빠져나온다
   
	    System.out.println(String.format("%.2f", result));
	}
}
