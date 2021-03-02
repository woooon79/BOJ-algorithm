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
	Index(int i, int j){
		this.i=i;
		this.j=j;
	}
}
public class 빙산 {
	static int[][] map;

	static boolean[][] visited;
	static int[] d_i= {-1,0,1,0};
	static int[] d_j= {0,1,0,-1};
	static Queue <Index> q=new LinkedList<Index>();
    static int col,row;
    

    public static int cnt() {
        visited = new boolean[row][col];
 
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                   dfs(i, j); // i,j와 연결된 빙하 모두 true로 만들기
                    count++; //빙하개수++
                }
            }
        }
        return count;
    }
 
    public static void dfs(int i, int j) {
        visited[i][j] = true;
 
        int t_i,t_j;
        for (int k = 0; k < 4; k++) {
            t_i = i + d_i[k];
            t_j = j + d_j[k];
 
            if (t_i < 0 || t_j < 0 || t_i >= row || t_j >= col) {
                continue;
            }
            
            
            if (map[t_i][t_j]!=0&&!visited[t_i][t_j]) {
                dfs(t_i,t_j);
            }
        }
    }
    
    
    
    
	public static int bfs() {
   int time=0;
	while(!q.isEmpty()) {
			
			if(cnt()>=2)
				return time;
			 boolean[][] chk=new boolean[row][col];
			
           int size=q.size();
           for(int p=0;p<size;p++) {
			Index tmp=q.poll();
			chk[tmp.i][tmp.j]=true;
			int i,j;
			
			for(int k=0;k<4;k++) {
				i=tmp.i+d_i[k];
				j=tmp.j+d_j[k];
				
				if(i<0||j<0||i>=row||j>=col)
					continue;

				if(!chk[i][j]&&map[i][j]==0)
				    map[tmp.i][tmp.j]--;
	
			}


			if(map[tmp.i][tmp.j]<=0) {
				map[tmp.i][tmp.j]=0;
			}
			else
				q.offer(new Index(tmp.i,tmp.j));
			}
           
           
           time++;
		}

		return 0;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	   StringTokenizer st=new StringTokenizer(br.readLine());
	   row=Integer.parseInt(st.nextToken());
	   col=Integer.parseInt(st.nextToken());
	   map=new int[row][col];

	   
	   for(int i=0;i<row;i++) {
		   st=new StringTokenizer(br.readLine());
		   for(int j=0;j<col;j++) {
			   int tmp=Integer.parseInt(st.nextToken());
			   map[i][j]=tmp;
			   if(tmp!=0) {
				   q.offer(new Index(i,j));
			   }
		   }
	   }
	   
	  System.out.println(bfs());
	   
	   
	}
}
