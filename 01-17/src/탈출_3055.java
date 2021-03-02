import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Ż��_3055 {
	static BufferedReader br;
    static BufferedWriter bw;
    static int row,column;
    static String[][] map;
    static boolean[][] water;
    //����ġ �̵�
   static Queue <Index> q=new LinkedList <Index>();
   //�� �̵�
   static Queue <Index> w_q=new LinkedList <Index>();;
    
    public static String bfs(Index D,Index S) {
    	//S: ����ġ ��ġ
    	//D: ����� ��ġ
    	//visited: ����ġ �湮����
    	//water: �� ���� ����
    	//time: �����ġ �̵��ð� ���
	    boolean[][] visited=new boolean[row][column];
	    int[][] time=new int[row][column];
    
	    //q�� �ʱ� ����ġ ��ġ�� ����ִ´�.
	    q.offer(S);
	    time[S.i][S.j]=0;
	    
	    /**���� �̵�**/
	    
	    while(!q.isEmpty()) {
	    	//����ġ �̵��ϱ��� ���� �̵����� �����
	    	int num=w_q.size();
	    	//w_q�� �ִ� ��� ���� ��ġ�� pop �ϰ� ������������ �����Ͽ�, ���ŵ� ���� ��ġ�� water �迭�� ǥ���ϰ� w_q�� �ٽ� push�Ѵ�
    		//��, �������� �̵��� ���� ��ġ ���� ��ֹ�(X)�� �ƴϰ�, ����� ���� �ƴϰ�, ���� ���������� ���� ��� (water �迭�� false �� ���)
    		// �̵��� ���� ��ġ ���� w_q�� push�Ѵ�
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
	    	
	    	
	    	/**����ġ �̵�**/
	    	
	    	//����  q�� �ִ� ����ġ�� ��ġ�� ��� pop�Ͽ�, ����ġ��  �������� �������� �̵��� �� q �� ����
	    	//�̵��� ��ġ�� ���� "X"�� ��ġ�ϴ���,visited�� ���� �湮������ ������,water�� ���� ���� ���� �� Ȯ�� ���� 
	    	//q�� push
	    	//�� �� �̵��ϸ鼭 time���� �������� +1�� �Ͽ� �������ش�
	    	
	    	num=q.size();
	    	for(int k=0;k<num;k++) {
	    	Index tmp=q.poll();
	    	if(tmp.i==D.i&&tmp.j==D.j) {
	    		//����ġ�� ��ġ�� ������� ��ġ�� ��ġ�Ұ�� �ش� time�� return 
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
	    
	     //map: ��ü ����
	     map=new String[row][column];
	     
	     //water: �� ���� ����
         water=new boolean[row][column];
         
        //S: ����ġ ��ġ
     	//D: ����� ��ġ
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
	    	     //���� ��� water �迭�� true�� �ٲٰ� w_q ť�� push
	    	     else if(tmp[j].equals("*")) {
	    	    	 water[i][j]=true;
	    	    	 w_q.offer(new Index(i,j));
	    	     }
	    	}
	    }
	    
	   System.out.println( bfs(D,S));
	    
	    
    }
}


