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
	Index(int i,int j){
		this.i=i;
		this.j=j;
	}

}
public class ¿¬±¸¼Ò2 {
	static int[][] map;
    static boolean check=false;
	static int[] di= {1,-1,0,0};
	static int[] dj= {0,0,-1,1};
	static int n,m;
	static int min=Integer.MAX_VALUE;
    static int safe_num=0;
	static void combination(ArrayList<Index> virus_arr, boolean[] visited, int start,int virus_num, int r) {
        if (r == 0) {
            bfs(virus_arr,visited,virus_num);
            return;
        }

        for (int i = start; i < virus_num; i++) {
            visited[i]=true;
            combination(virus_arr, visited, i + 1,virus_num, r - 1);
            visited[i]=false;
        }
    }
	public static void bfs(ArrayList<Index> virus_arr, boolean[] visited, int virus_num) {
		
		boolean[][] chk=new boolean[n][n];
		int[][] time=new int[n][n];
		Queue <Index> q=new LinkedList<Index>();
		
		for(int i=0;i<virus_num;i++) {
			if(visited[i]) {
				
				Index tmp=virus_arr.get(i);
				chk[tmp.i][tmp.j]=true;
				q.offer(new Index(tmp.i,tmp.j));
			}

		}

        
		int i=0;
		int j=0;
       int infect=m;
		while(!q.isEmpty()) {
			Index tmp=q.poll();
			i=tmp.i;
			j=tmp.j;
			for(int k=0;k<4;k++) {
				int ni=i+di[k];
				int nj=j+dj[k];
				
				if(ni<0||ni>=n||nj<0||nj>=n)
					continue;
				
				if(!chk[ni][nj]&&(map[ni][nj]==0||map[ni][nj]==2)) {
					infect++;
					chk[ni][nj]=true;
					q.offer(new Index(ni,nj));
					time[ni][nj]=time[i][j]+1;


					}
				}
				
			}
		
	
		if(infect==safe_num+virus_num) {
			check=true;
			if(min>time[i][j])
			    min=time[i][j];
		}
		
		
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//65+0=a

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    Queue <Index> q=new LinkedList<Index>();
	    
	    
	    n=Integer.parseInt(st.nextToken());
	    m=Integer.parseInt(st.nextToken());
	    map=new int[n][n];


	    ArrayList <Index> virus_arr=new <Index> ArrayList();

	    int virus_num=0;

	    
	    for(int i=0;i<n;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	for(int j=0;j<n;j++) {
	    		map[i][j]=Integer.parseInt(st.nextToken());
	    		if(map[i][j]==2) {
	    			virus_arr.add(new Index(i,j));
	    			virus_num++;
	    		}
	    		else if(map[i][j]==0) {
	    			 safe_num++;
	    		}
	    	}
	    }
	    
	    boolean[] visited=new boolean[virus_num];
	    
	    combination(virus_arr, visited, 0, virus_num,m);
	    if(check)
	    System.out.println(min);
	    else
	    	System.out.println(-1);
	}
}
