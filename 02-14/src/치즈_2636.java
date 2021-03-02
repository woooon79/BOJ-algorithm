import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Index{
	int i,j;
	Index(int i,int j){
		this.i=i;
		this.j=j;
	}
}
public class ДЎБо_2636 {
	static int row,col;
	static int[][] map;
	static boolean[][] chk;
	static Queue<Index> q=new LinkedList<Index>();
	static Queue<Index> c_q=new LinkedList<Index>();
    static int result=0;
    static int time=0;
	
	static int a_bfs() {
		int c=0;
		while(!q.isEmpty()) {
			Index tmp=q.poll();
			if(tmp.i-1>0&&!chk[tmp.i-1][tmp.j]) {
				chk[tmp.i-1][tmp.j]=true;
				if(map[tmp.i-1][tmp.j]==0) {
				q.offer(new Index(tmp.i-1,tmp.j));
				
				}
				else if(map[tmp.i-1][tmp.j]==1) {
					c_q.offer(new Index(tmp.i-1,tmp.j));
					
					c++;
				}
			}
			if(tmp.j-1>0&&!chk[tmp.i][tmp.j-1]){
				chk[tmp.i][tmp.j-1]=true;
				if(map[tmp.i][tmp.j-1]==0) {
				q.offer(new Index(tmp.i,tmp.j-1));
				
				}
				else if(map[tmp.i][tmp.j-1]==1) {
					c_q.offer(new Index(tmp.i,tmp.j-1));
					
					c++;
				}
			}
			if(tmp.i+1<row&&!chk[tmp.i+1][tmp.j]){
				chk[tmp.i+1][tmp.j]=true;
				if(map[tmp.i+1][tmp.j]==0) {
				q.offer(new Index(tmp.i+1,tmp.j));
				
				}
				else if(map[tmp.i+1][tmp.j]==1) {
					c_q.offer(new Index(tmp.i+1,tmp.j));
					
					c++;
				}
			}
			if(tmp.j+1<col&&!chk[tmp.i][tmp.j+1]) {
				chk[tmp.i][tmp.j+1]=true;
				if(map[tmp.i][tmp.j+1]==0) {
			    q.offer(new Index(tmp.i,tmp.j+1));
				}
				else if(map[tmp.i][tmp.j+1]==1) {
					 c_q.offer(new Index(tmp.i,tmp.j+1));
					
					 c++;
				}
			}
			
		}
		
		
		return c;
	}
	static void bfs(int c) {
		result=c;
		while(!c_q.isEmpty()) {
			int t_result=0;
			for(int k=0;k<result;k++) {
			Index tmp=c_q.poll();
			map[tmp.i][tmp.j]=0;
			
			if(tmp.i-1>0&&!chk[tmp.i-1][tmp.j]) {
				chk[tmp.i-1][tmp.j]=true;
				if(map[tmp.i-1][tmp.j]==0) {
					q.offer(new Index(tmp.i-1,tmp.j));
					t_result+=a_bfs();
				}
				else if(map[tmp.i-1][tmp.j]==1) {
					c_q.offer(new Index(tmp.i-1,tmp.j));
					t_result++;
				}
			}
			if(tmp.j-1>0&&!chk[tmp.i][tmp.j-1]){
				chk[tmp.i][tmp.j-1]=true;
				if(map[tmp.i][tmp.j-1]==0) {
					q.offer(new Index(tmp.i,tmp.j-1));
					t_result+=a_bfs();
				}
				
				else if(map[tmp.i][tmp.j-1]==1) {
					c_q.offer(new Index(tmp.i,tmp.j-1));
					
					t_result++;
				}
			}
			if(tmp.i+1<row&&!chk[tmp.i+1][tmp.j]){
				chk[tmp.i+1][tmp.j]=true;
				if(map[tmp.i+1][tmp.j]==0) {
					q.offer(new Index(tmp.i+1,tmp.j));
					t_result+=a_bfs();
				}
				
				
				else if(map[tmp.i+1][tmp.j]==1) {
					c_q.offer(new Index(tmp.i+1,tmp.j));
					
					t_result++;
				}
			}
			if(tmp.j+1<col&&!chk[tmp.i][tmp.j+1]) {
				chk[tmp.i][tmp.j+1]=true;
				if(map[tmp.i][tmp.j+1]==0) {
					q.offer(new Index(tmp.i,tmp.j+1));
					t_result+=a_bfs();
				}
				
				else if(map[tmp.i][tmp.j+1]==1) {
					 c_q.offer(new Index(tmp.i,tmp.j+1));
					
					 t_result++;
				}
			}
			}
			if(t_result!=0)
			result=t_result;
			
			time++;
			
		}
		
		
		
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    row=Integer.parseInt(st.nextToken());
	    col=Integer.parseInt(st.nextToken());
	    map=new int[row][col];
	    chk=new boolean[row][col];
	    
	    for(int i=0;i<row;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	for(int j=0;j<col;j++) {
	    		map[i][j]=Integer.parseInt(st.nextToken());
	    		if(j==0||j==col-1||i==0||i==row-1)
	    			q.offer(new Index(i,j));
	    	}
	    }
	   int c= a_bfs();
	    bfs(c);
	    System.out.println(time+"\n"+result);
	}
}
