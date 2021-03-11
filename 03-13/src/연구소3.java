import java.io.*;
import java.util.*;
 class Index{
	int i,j;
	
	Index(int i,int j){
		this.i=i;
		this.j=j;
	}
}
public class 연구소3 {
	static int n,m;
	static int[][] map;
	static int[] di= {1,-1,0,0};
	static int[] dj= {0,0,-1,1};
	static int empty_num=0;
	static int result=Integer.MAX_VALUE;
	
	
	static void combination(ArrayList<Index> virus_arr, boolean[] visited, int start,int virus_num, int r) {
        if (r == 0) {
        	int value=bfs(virus_arr,visited,virus_num);
        	if(value!=-1)
                result=Math.min(result,value);
            return;
        }

        for (int i = start; i < virus_num; i++) {
            visited[i]=true;
            combination(virus_arr, visited, i + 1,virus_num, r - 1);
            visited[i]=false;
        }
    }
	public static int bfs(ArrayList<Index> virus_arr, boolean[] visited,int virus_num){
		int fill=0;
		int[][] time=new int[n][n];
		boolean[][] chk=new boolean[n][n];
		
		Queue <Index> q=new LinkedList<Index>();
		
		for(int i=0;i<virus_num;i++) {

			if(visited[i]) {
				Index virus=virus_arr.get(i);
				q.offer(virus);
				chk[virus.i][virus.j]=true;
				
			}
		}
		
		int i=-1;
		int j=-1;
		
		while(!q.isEmpty()) {
			Index tmp=q.poll();
			i=tmp.i;
			j=tmp.j;	
			
			if(map[i][j]==0)
				fill++;
			
			if(fill==empty_num) {
			
					break;
			}
	
			
			
			for(int k=0;k<4;k++) {
				int ni=i+di[k];
				int nj=j+dj[k];
				
				if(ni<0||ni>=n||nj<0||nj>=n) {
					continue;
				}
				
				if(!chk[ni][nj]&&map[ni][nj]!=1) {
					
					q.offer(new Index(ni,nj));
					chk[ni][nj]=true;
					time[ni][nj]=time[i][j]+1;
				
				}
			}
		}
		
		if(fill>=empty_num)
			return time[i][j];
		else
		    return -1;
		
	}
	
	   public static void main(String[] args) throws IOException {
	    BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	   n=Integer.parseInt(st.nextToken());
	   m=Integer.parseInt(st.nextToken());
	   map=new int[n][n];
	   
	   ArrayList<Index> virus_arr=new ArrayList<Index>();
	    int virus_num=0;

	    for(int i=0;i<n;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	for(int j=0;j<n;j++) {
	    		int status=Integer.parseInt(st.nextToken());
	    		map[i][j]=status;
	    		
	    		if(status==0) {
	    			empty_num++;
	    		}
	    		//바이러스를 놓을 수 있는 위치를  virus_arr 에 삽입
	    		else if(status==2) {
	    			virus_arr.add(new Index(i,j));
	    			virus_num++;
	    		}
	    	}
	    }
	    
	    boolean[] visited=new boolean[virus_num];

	    combination(virus_arr,visited,0,virus_num,m);
	    
	    if(result==Integer.MAX_VALUE)
	        System.out.println(-1);
	    else
	    	System.out.println(result);
    }
}
