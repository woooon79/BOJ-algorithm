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
public class ¿¬±¸¼Ò {
	static int[][] map;

	static int[] di= {1,-1,0,0};
	static int[] dj= {0,0,-1,1};
	static int n,m;
	static int max=0;
	static void combination(ArrayList<Index> safe_arr, boolean[] visited, int start,int safe_num, int r,ArrayList<Index> virus_arr) {
        if (r == 0) {
            int tmp=bfs(safe_arr,visited,safe_num,virus_arr);
            if(max<tmp)
            	max=tmp;
            return;
        }

        for (int i = start; i < safe_num; i++) {
            visited[i]=true;
            combination(safe_arr, visited, i + 1,safe_num, r - 1,virus_arr);
            visited[i]=false;
        }
    }
	public static int bfs(ArrayList<Index> safe_arr, boolean[] visited, int safe_num,ArrayList<Index> virus_arr) {
		
		boolean[][] chk=new boolean[n][m];
		
		for(int i=0;i<safe_num;i++) {
			if(visited[i]) {
				Index tmp=safe_arr.get(i);
				chk[tmp.i][tmp.j]=true;
			}

		}
		Queue <Index> q=new LinkedList<Index>();
		for(int i=0;i<virus_arr.size();i++) {	
			q.offer( virus_arr.get(i));
		}
		int infect=0;
		while(!q.isEmpty()) {
			Index tmp=q.poll();
			
			for(int k=0;k<4;k++) {
				int ni=tmp.i+di[k];
				int nj=tmp.j+dj[k];
				
				if(ni<0||ni>=n||nj<0||nj>=m)
					continue;
				
				if(!chk[ni][nj]&&map[ni][nj]==0) {
					chk[ni][nj]=true;
					infect++;
					q.offer(new Index(ni,nj));
				}
				
			}
		}
		return safe_num-infect-3;
		
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
	    map=new int[n][m];

	    ArrayList <Index> safe_arr=new <Index> ArrayList();
	    ArrayList <Index> virus_arr=new <Index> ArrayList();
	    int safe_num=0;

	    
	    for(int i=0;i<n;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	for(int j=0;j<m;j++) {
	    		map[i][j]=Integer.parseInt(st.nextToken());
	    		if(map[i][j]==2) {
	    			virus_arr.add(new Index(i,j));
	    		}
	    		else if(map[i][j]==0) {
	    			 safe_arr.add(new Index(i,j));
	    			 safe_num++;
	    		}
	    	}
	    }
	    
	    boolean[] visited=new boolean[safe_num];
	    
	    combination(safe_arr, visited, 0, safe_num,3,virus_arr);
	    System.out.println(max);
    
	}
}
