import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class 탈출_3055 {
	static BufferedReader br;
    static BufferedWriter bw;
    static int row,column;
    static String[][] map;
    static boolean[][] water;
    //고슴도치 이동
   static Queue <Index> q=new LinkedList <Index>();
   //물 이동
   static Queue <Index> w_q=new LinkedList <Index>();;
    
    public static String bfs(Index D,Index S) {
    	//S: 고슴도치 위치
    	//D: 비버굴 위치
    	//visited: 고슴도치 방문여부
    	//water: 물 도달 여부
    	//time: 고숨도치 이동시간 기록
	    boolean[][] visited=new boolean[row][column];
	    int[][] time=new int[row][column];
    
	    //q에 초기 고슴도치 위치값 집어넣는다.
	    q.offer(S);
	    time[S.i][S.j]=0;
	    
	    /**물의 이동**/
	    
	    while(!q.isEmpty()) {
	    	//고슴도치 이동하기전 물의 이동부터 고려함
	    	int num=w_q.size();
	    	//w_q에 있는 모든 물의 위치를 pop 하고 동서남북으로 갱신하여, 갱신된 물의 위치를 water 배열에 표시하고 w_q에 다시 push한다
    		//즉, 동서남북 이동한 물의 위치 값이 장애물(X)이 아니고, 비버의 굴이 아니고, 물이 차오른적이 없을 경우 (water 배열이 false 인 경우)
    		// 이동한 물의 위치 값을 w_q에 push한다
	    	for(int k=0;k<num;k++) {
	    		Index w=w_q.poll();
	    		if(w.i>0&&!map[w.i-1][w.j].equals("X")&&!map[w.i-1][w.j].equals("D")&&!water[w.i-1][w.j]) {
	    			water[w.i-1][w.j]=true;
	    			w_q.offer(new Index(w.i-1,w.j));
	    		}
	    		if(w.i<row-1&&!map[w.i+1][w.j].equals("X")&&!map[w.i+1][w.j].equals("D")&&!water[w.i+1][w.j]) {
	    			water[w.i+1][w.j]=true;
	    			w_q.offer(new Index(w.i+1,w.j));
	    		}
	    		if(w.j>0&&!map[w.i][w.j-1].equals("X")&&!map[w.i][w.j-1].equals("D")&&!water[w.i][w.j-1]) {
	    			water[w.i][w.j-1]=true;
	    			w_q.offer(new Index(w.i,w.j-1));
	    		}
	    		if(w.j<column-1&&!map[w.i][w.j+1].equals("X")&&!map[w.i][w.j+1].equals("D")&&!water[w.i][w.j+1]) {
	    			water[w.i][w.j+1]=true;
	    			w_q.offer(new Index(w.i,w.j+1));
	    		}
	    	}
	    	
	    	
	    	/**고슴도치 이동**/
	    	
	    	//현재  q에 있는 고슴도치의 위치를 모두 pop하여, 고슴도치를  동서남북 방향으로 이동한 후 q 값 갱신
	    	//이동한 위치의 값이 "X"와 일치하는지,visited를 통해 방문한적이 없는지,water를 통해 물이 없는 지 확인 한후 
	    	//q에 push
	    	//이 때 이동하면서 time값도 이전값에 +1을 하여 갱신해준다
	    	
	    	num=q.size();
	    	for(int k=0;k<num;k++) {
	    	Index tmp=q.poll();
	    	if(tmp.i==D.i&&tmp.j==D.j) {
	    		//고슴도치의 위치와 비버굴의 위치가 일치할경우 해당 time값 return 
	    		return Integer.toString(time[D.i][D.j]);
	    	}
	    	if(tmp.i>0&&!map[tmp.i-1][tmp.j].contentEquals("X")&&!visited[tmp.i-1][tmp.j]&&!water[tmp.i-1][tmp.j])
	    	{
	    		q.offer(new Index(tmp.i-1,tmp.j));
	    		time[tmp.i-1][tmp.j]=time[tmp.i][tmp.j]+1;
	    		visited[tmp.i-1][tmp.j]=true;
	    	}
	    	if(tmp.i<row-1&&!map[tmp.i+1][tmp.j].contentEquals("X")&&!visited[tmp.i+1][tmp.j]&&!water[tmp.i+1][tmp.j])
	    	{
	    		q.offer(new Index(tmp.i+1,tmp.j));
	    		time[tmp.i+1][tmp.j]=time[tmp.i][tmp.j]+1;
	    		visited[tmp.i+1][tmp.j]=true;
	    	}
	    	if(tmp.j>0&&!map[tmp.i][tmp.j-1].contentEquals("X")&&!visited[tmp.i][tmp.j-1]&&!water[tmp.i][tmp.j-1])
	    	{
	    		q.offer(new Index(tmp.i,tmp.j-1));
	    		time[tmp.i][tmp.j-1]=time[tmp.i][tmp.j]+1;
	    		visited[tmp.i][tmp.j-1]=true;
	    	}
	    	if(tmp.j<column-1&&!map[tmp.i][tmp.j+1].contentEquals("X")&&!visited[tmp.i][tmp.j+1]&&!water[tmp.i][tmp.j+1])
	    	{
	    		q.offer(new Index(tmp.i,tmp.j+1));
	    		time[tmp.i][tmp.j+1]=time[tmp.i][tmp.j]+1;
	    		visited[tmp.i][tmp.j+1]=true;
	    	}
	    	}
	    }
	    
	    return "KAKTUS";
	    
    }
    
    public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br =new BufferedReader(new InputStreamReader(System.in));
	    bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	     row=Integer.parseInt(st.nextToken());
	     column=Integer.parseInt(st.nextToken());
	    
	     //map: 전체 지도
	     map=new String[row][column];
	     
	     //water: 물 도달 여부
         water=new boolean[row][column];
         
        //S: 고슴도치 위치
     	//D: 비버굴 위치
	    Index D=new Index();
	    Index S=new Index();
	    
	    for(int i=0;i<row;i++) {
	    	String[] tmp=br.readLine().split("");
	    	for(int j=0;j<column;j++) {
	    	     map[i][j]=tmp[j];
	    	     if(tmp[j].equals("."))
	    	    	 continue;
	    	     else if(tmp[j].equals("D"))
	    	    	 D=new Index(i,j);
	    	     else if(tmp[j].equals("S"))
	    	    	 S=new Index(i,j);
	    	     //물인 경우 water 배열값 true로 바꾸고 w_q 큐에 push
	    	     else if(tmp[j].equals("*")) {
	    	    	 water[i][j]=true;
	    	    	 w_q.offer(new Index(i,j));
	    	     }
	    	}
	    }
	    
	   System.out.println( bfs(D,S));
	    
	    
    }
}


