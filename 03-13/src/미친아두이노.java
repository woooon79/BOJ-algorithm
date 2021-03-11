import java.util.*;
import java.io.*;
/*
class Index{
	int i,j;
	
	Index(int i,int j){
		this.i=i;
		this.j=j;
	}
}*/
	/*
 * 종수 8방향으로 이동 또는 제자리
 * 미친 아두이노칸으로 이동한경우 짐
 * 미친 아두이노는 종수와 가장 가까워지는 방향으로 한칸 
 * 미친 아두이노가 종수칸으로 이동한경우에도 짐
 * 미친 아두이노 2개이상 같은 칸에 동시에있는경우 파괴
 * => 보드 상태 출력 또는 언제 죽는지
 * */


public class 미친아두이노 {
	static int r,c;
	static char[][] map;
	static char[] move;
	static int[] di= {1,1,1,0,0,-1,-1,-1};
	static int[] dj= {-1,0,1,-1,1,-1,0,1};

	
	public static int len(int x,int y,int i,int j) {
		return Math.abs(x-i)+Math.abs(y-j);
	}
	public static void solve(Queue<Index> q, int x,int y) {
		
		int t=1;
		int[][] chk_now=new int[r][c];

		for(;t<=move.length;t++) {
			
			switch(move[t-1]) {
			case '1':
				x+=1;
				y-=1;
				break;
			case '2':
				x+=1;
				break;
			case '3':
				x+=1;
				y+=1;
				break;
			case '4':
				y-=1;
				break;
			case '5':
				break;
			case '6':
				y+=1;
				break;
			case '7':
				x-=1;
				y-=1;
				break;
			case '8':
				x-=1;
				break;
			case'9':
				x-=1;
				y+=1;
				break;

			}
			
			//종수 움직임
			//미친 아두이노가 잇다면 빠져나감
			if(chk_now[x][y]==1) {
				System.out.println("kraj "+ t);
				
				return;
			}
			
			
			Queue<Index> new_q=new LinkedList<Index>();
			int[][] chk=new int[r][c];
			
			//미친 아두이노들 움직일 차례
			while(!q.isEmpty()) {
				Index robot=q.poll();
				int i=robot.i;
				int j=robot.j;
				//만약 여러 해당 위치에 미친아두이노가 모여있다면 continue
				
				
				if(chk_now[i][j]>1) 
					continue;


				
				int min=Integer.MAX_VALUE;
				Index next=null;
				
				
				
				//제일 짧은 거리로 이동
				for(int k=0;k<8;k++) {
					
					int ni=i+di[k];
					int nj=j+dj[k];
					
					if(ni<0||ni>=r||nj<0||nj>=c) 
						continue;
					
					int l=len(x,y,ni,nj);
					
					//만약 종수와 거리가 0이라면
					if(l==0) {
						System.out.println("kraj "+t);
						return;
					}
					
					if(min>l) {
						next=new Index(ni,nj);
						min=l;
					}

				}
				
				if(chk[next.i][next.j]==0){
					new_q.offer(next);
				}

				
				chk[next.i][next.j]++;

			}
			
			chk_now=chk;
			q=new_q;
		}
		
		for(int i=0;i<r;i++) {
		Arrays.fill(map[i],'.');
		}
		while(!q.isEmpty()) {
			Index tmp=q.poll();
			int i=tmp.i;
			int j=tmp.j;
			//System.out.println(t);
			
			if(chk_now[i][j]>1) {
				continue;
			}

			map[i][j]='R';
		}
		map[x][y]='I';
		
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				  sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
		
	
    public static void main(String[] args) throws IOException{
    	BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
   
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	r=Integer.parseInt(st.nextToken());
    	c=Integer.parseInt(st.nextToken());
    	
        map=new char[r][c];

    	
        Queue<Index> q=new LinkedList<Index>();
        int x=0;
        int y=0;
    	for(int i=0;i<r;i++) {
    		
    		map[i]=br.readLine().toCharArray();
    		for(int j=0;j<c;j++) {
    			if(map[i][j]=='R') {
    				q.offer(new Index(i,j));
    			}
    			else if(map[i][j]=='I') {
    				x=i;
    				y=j;
    			}
    				
    		}
    	}
    	
    	move=br.readLine().toCharArray();
    	

    	solve(q,x,y);
	
    }
}


