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


public class ��ŸƮ�ý� {
	static int m,n,a;
	static int[][] map;
	static Index[] p_d;
	static int[] di= {-1,0,0,1};
	static int[] dj= {0,-1,1,0};
	
	//�ּҼմԱ���
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
			//�մ��� �ִ°�� 
			if(map[i][j]>1) {
				//�� �� ��
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
		//���� ����� �մ� �̱�(�մ� ������ġ)
		Index p_start=short_dist(t_start);
		
		//�մ� ���������ٰ� ���ߴ� ���
		if(a<0||p_start==null)
			return -1;
		
		//�մ��� ������ġ
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
				//���������� ���ٰ� ���ߴ� ���
				if(a<0)
					return -1;
				//�°Ÿ��� 2�踸ŭ ���� ����
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
	    //�� ��
	    n=Integer.parseInt(st.nextToken());
	    //�°� ��
	    m=Integer.parseInt(st.nextToken());
	    //�ʱ⿬��
	    a=Integer.parseInt(st.nextToken());
	    map=new int[n+1][n+1];
	    
	    for(int i=1;i<=n;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	for(int j=1;j<=n;j++) {
	    		map[i][j]=Integer.parseInt(st.nextToken());
	    		
	    	}
	      }

	    
	    st=new StringTokenizer(br.readLine());
	    //�ý� �����
	    int ti=Integer.parseInt(st.nextToken());
	    int tj=Integer.parseInt(st.nextToken());
	    Index t_start=new Index(ti,tj);
	    
        //�մԵ� �������� ���� �迭
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
