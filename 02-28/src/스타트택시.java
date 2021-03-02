import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
 class Index{
	int i,j;
	Index(int i,int j){
		this.i=i;
		this.j=j;
	}
}


public class 스타트택시 {
	static int m,n,a;
	static int[][] map;
	static Index[] p_d;
	static int[] di= {-1,0,0,1};
	static int[] dj= {0,-1,1,0};
	
	//최소손님까지
	static Index short_dist (Index start) {
		int[][] dist=new int[n+1][n+1];
		boolean[][] chk=new boolean[n+1][n+1];
		Index result=null;
		

		 Queue<Index> q=new LinkedList<Index>();
		q.offer(new Index(start.i,start.j));
		chk[start.i][start.j]=true;
		int d=Integer.MAX_VALUE;
		Index d_idx=null;
		
		while(!q.isEmpty()) {
			Index tmp=q.poll();
			int i=tmp.i;
			int j=tmp.j;
			//손님이 있는경우 
			if(map[i][j]>1) {
				//행 열 비교
				if(d>dist[i][j]||d==-1) {
					d=dist[i][j];
					result=tmp;
				}
				else if(d==dist[i][j]) {
					if(result.i>i) {
						result=tmp;
					}
					else if(result.i==i) {
						if(result.j>j) {
							result=tmp;
						}
					}
				}
				continue;
			
			}
			for(int p=0;p<4;p++) {
				 int ni=i+di[p];
				 int nj=j+dj[p];
				
				if(ni<1||ni>n||nj<1||nj>n||map[ni][nj]==1)
					continue;
				
				if(!chk[ni][nj]) {
				q.offer(new Index(ni,nj));
				dist[ni][nj]=dist[i][j]+1;
				chk[ni][nj]=true;
				}
			}
		}
		
		  a=a-d;
		  return result;
		
	}
	
	public static int bfs(Index t_start,int p_num) {
		//제일 가까운 손님 뽑기(손님 시작위치)
		Index p_start=short_dist(t_start);
		
		//손님 데릴러가다가 멈추는 경우
		if(a<0||p_start==null)
			return -1;
		
		//손님의 도착위치
		Index p_dest=p_d[map[p_start.i][p_start.j]];
		boolean check=false;
		
		
		Queue <Index> q=new LinkedList<Index>();
		q.offer(p_start);
		
		int[][] dist=new int[n+1][n+1];
		boolean[][] chk=new boolean[n+1][n+1];
		chk[p_start.i][p_start.j]=true;
		
		while(!q.isEmpty()) {
			Index tmp=q.poll();
			int i=tmp.i;
			int j=tmp.j;
			if(i==p_dest.i&&j==p_dest.j) {
				a=a-dist[i][j];
				//목적지까지 가다가 멈추는 경우
				if(a<0)
					return -1;
				//온거리의 2배만큼 연료 충전
				a=a+(dist[i][j]*2);
			
				check=true;
				map[p_start.i][p_start.j]=0;		
				break;
			}
			for(int p=0;p<4;p++) {
				 int ni=i+di[p];
				 int nj=j+dj[p];
				
				if(ni<1||ni>n||nj<1||nj>n||map[ni][nj]==1)
					continue;
				
				if(!chk[ni][nj]) {
					q.offer(new Index(ni,nj));
					dist[ni][nj]=dist[i][j]+1;
					chk[ni][nj]=true;
					}
			}
		}
		
		if(!check)
			return -1;
		
		if(p_num==m)
			return a;
		
		return bfs(p_dest,p_num+1);
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    

	    StringTokenizer st=new StringTokenizer(br.readLine());
	    //행 열
	    n=Integer.parseInt(st.nextToken());
	    //승객 수
	    m=Integer.parseInt(st.nextToken());
	    //초기연료
	    a=Integer.parseInt(st.nextToken());
	    map=new int[n+1][n+1];
	    
	    for(int i=1;i<=n;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	for(int j=1;j<=n;j++) {
	    		map[i][j]=Integer.parseInt(st.nextToken());
	    		
	    	}
	      }

	    
	    st=new StringTokenizer(br.readLine());
	    //택시 출발지
	    int ti=Integer.parseInt(st.nextToken());
	    int tj=Integer.parseInt(st.nextToken());
	    Index t_start=new Index(ti,tj);
	    
        //손님들 도착지들 정보 배열
	   p_d=new Index[m+2];
	   int num=2;
	    
	    for(int i=0;i<m;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	int s_i=Integer.parseInt(st.nextToken());
	    	int s_j=Integer.parseInt(st.nextToken());
	    	map[s_i][s_j]=num;
	    	
	    	int d_i=Integer.parseInt(st.nextToken());
	    	int d_j=Integer.parseInt(st.nextToken());

	    	
	    	p_d[num]=new Index(d_i,d_j);
	    	
	    	num++;

	    }
	    
	    System.out.println(bfs(t_start,1));
	    
	}
}
