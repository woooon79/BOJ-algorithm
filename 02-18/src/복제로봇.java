import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Index implements Comparable<Index>{
	int i,j;
	int move;
	Index(int i,int j,int move){
		this.i=i;
		this.j=j;
		this.move=move;
	}
	@Override 
	public int compareTo (Index o) { 
		return this.move - o.move; 
		}


}


public class 복제로봇 {
	static char[][] map;
	static int[] di= {1,-1,0,0};
	static int[] dj= {0,0,-1,1};
	static int[][] time;
	static boolean[][] chk;
	static int m,n;
	static Queue <Index> q=new LinkedList<Index>();
	
	static int bfs(Index[] keys) {
		int key=0;
		int ni,nj;
		while(!q.isEmpty()) {
			Index tmp=q.poll();
			//key에 첫 방문했다면
			if(!chk[tmp.i][tmp.j]&&map[tmp.i][tmp.j]=='K') {
			     chk[tmp.i][tmp.j]=true;
				 time[tmp.i][tmp.j]=tmp.move;
				 
				 key++;
				 //만약 모든 키를 다 방문했다면 각 키 위치의 time변수값의 합을 리턴
					if(key==m) {
						int sum=0;
						for(int i=0;i<m;i++) {
							Index t=keys[i];
							sum+=time[t.i][t.j];
						}
						
						return sum;
					}
				//아니라면 거리가 0인 새로운 복제로봇 생성
				q.offer(new Index(tmp.i,tmp.j,0));
				continue;
			}
			
			for(int k=0;k<4;k++) {
				 ni=tmp.i+di[k];
				 nj=tmp.j+dj[k];
				
				if(ni<=0||ni>=n-1||nj<=0||nj>=n-1||map[ni][nj]=='1')
					continue;
			//만약 옆자리(동서남북)가 키이면
				if(map[ni][nj]=='K') {
					//아직 그 키에 방문하지 않았다면
					if(!chk[ni][nj])
					//키로 이동
					q.offer(new Index(ni,nj,tmp.move+1));
				}
			//키가 아니고, 옆자리까지 이동거리가 이전값보다 짧다면
				else if(tmp.move+1<time[ni][nj]) {
					//time값 업데이트
					time[ni][nj]=tmp.move+1;
					//옆자리(동서남북)로 이동
					q.offer(new Index(ni,nj,tmp.move+1));
				}
				
			}
		}
		
		
		//나머지 경우엔 -1 리턴
		return -1;
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub


		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    n=Integer.parseInt(st.nextToken());
	    m=Integer.parseInt(st.nextToken());
	    
	    map=new char[n][n];
	    time=new int[n][n];
	    chk=new boolean[n][n];
	    Index[] keys=new Index[m];
	    int k=0;
	    
	    for(int i=0;i<n;i++) {
	    	
	    		map[i]=br.readLine().toCharArray();
	    		
	    		Arrays.fill(time[i], Integer.MAX_VALUE);

	    		for(int j=0;j<n;j++) {
	    			if(map[i][j]=='S') {
	    				q.offer(new Index(i,j,0));
	    				q.offer(new Index(i,j,0));
	    				chk[i][j]=true;
	    			}
	    			if(map[i][j]=='K') {
	    				keys[k]=new Index(i,j,0);
	    				k++;
	    			}
	    				
	    			
	    		}
	    }
	    
	    
	    System.out.println(bfs(keys));
	    
	  /*  for(int i=0;i<n;i++) {
	    	for(int j=0;j<n;j++) {
	    		System.out.print(time[i][j]+" ");
	    	}
	    	System.out.println();
	    }*/
	}
}








		









