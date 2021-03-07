package ps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Index{
	int i,j;
	Index(int i, int j){
		this.i=i;
		this.j=j;
	}
}
public class 불켜기 {
	static int m,n;
	static ArrayList<Index>[][] map;
	static int[] di= {-1,0,0,1};
	static int[] dj= {0,-1,1,0};
	
	static int solution() {
		
		boolean[][] turn_on=new boolean[n+1][n+1];
		boolean[][] visit=new boolean[n+1][n+1];
		
		Queue<Index> q=new LinkedList<Index>();
		q.offer(new Index(1,1));
		//불키고
		turn_on[1][1]=true;
		//방문
		visit[1][1]=true;
		//불켜짐 결과 +1
		int result=1;
		
		while(!q.isEmpty()) {
			Index tmp=q.poll();
			int i=tmp.i;
			int j=tmp.j;
            
			//해당 방에 연결된 스위치들
			//불키는 작업
			for(int k=0;k<map[i][j].size();k++) {
				
				Index s =map[i][j].get(k);
				int new_i=s.i;
				int new_j=s.j;
				
				//이미 불이 켜져 있다면 continue
				if(turn_on[s.i][s.j])
					continue;
				//불킨다
				turn_on[s.i][s.j]=true;
				result++;
				
				//불을 킨 방이 내가 현재 갈수 있는 위치에 있는지 검사
				//즉 새로 불킨 방이 내가 방문했던 방과 연결되어있는지 검사
				for(int p=0;p<4;p++) {
					 int ni=new_i+di[p];
					 int nj=new_j+dj[p];
					
					if(ni<1||ni>n||nj<1||nj>n)
						continue;
					
					//만약 내가 방문했던 방과 연결되어 있다면 현재위치에서 새로운 불킨 방으로 갈 수 있으므로 큐에 삽입
					if(visit[ni][nj]) {
					q.offer(new Index(new_i,new_j));
					//방문
					visit[new_i][new_j]=true;
					}
					
				}
				
			}
			
			//현재위치에서 갈수 있는 새로운 방도 고려
			for(int p=0;p<4;p++) {
				 int ni=i+di[p];
				 int nj=j+dj[p];
				
				if(ni<1||ni>n||nj<1||nj>n)
					continue;
				//방문한적없고, 불이 켜져있다면 큐에 삽입
				if(!visit[ni][nj]&&turn_on[ni][nj]) {
				q.offer(new Index(ni,nj));
				visit[ni][nj]=true;
				}
			}
		}
		
		
		return result;
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    n=Integer.parseInt(st.nextToken());
	    m=Integer.parseInt(st.nextToken());
	    //arraylist 2차원 배열
	    map=new ArrayList[n+1][n+1];
	    
	    for(int i=1;i<=n;i++) {
	    	for(int j=1;j<=n;j++) {
	    		map[i][j]=new ArrayList<Index>();
	    	}
	    }
	    //방에 있는 스위치들 arraylist 로 연결
	    for(int i=0;i<m;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	int x=Integer.parseInt(st.nextToken());
	    	int y=Integer.parseInt(st.nextToken());
	    	int a=Integer.parseInt(st.nextToken());
	    	int b=Integer.parseInt(st.nextToken());
	    	
	    	map[x][y].add(new Index(a,b));
	    }
	    
	    System.out.println(solution());
	    
	}
}
