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


public class �����κ� {
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
			//key�� ù �湮�ߴٸ�
			if(!chk[tmp.i][tmp.j]&&map[tmp.i][tmp.j]=='K') {
			     chk[tmp.i][tmp.j]=true;
				 time[tmp.i][tmp.j]=tmp.move;
				 
				 key++;
				 //���� ��� Ű�� �� �湮�ߴٸ� �� Ű ��ġ�� time�������� ���� ����
					if(key==m) {
						int sum=0;
						for(int i=0;i<m;i++) {
							Index t=keys[i];
							sum+=time[t.i][t.j];
						}
						
						return sum;
					}
				//�ƴ϶�� �Ÿ��� 0�� ���ο� �����κ� ����
				q.offer(new Index(tmp.i,tmp.j,0));
				continue;
			}
			
			for(int k=0;k<4;k++) {
				 ni=tmp.i+di[k];
				 nj=tmp.j+dj[k];
				
				if(ni<=0||ni>=n-1||nj<=0||nj>=n-1||map[ni][nj]=='1')
					continue;
			//���� ���ڸ�(��������)�� Ű�̸�
				if(map[ni][nj]=='K') {
					//���� �� Ű�� �湮���� �ʾҴٸ�
					if(!chk[ni][nj])
					//Ű�� �̵�
					q.offer(new Index(ni,nj,tmp.move+1));
				}
			//Ű�� �ƴϰ�, ���ڸ����� �̵��Ÿ��� ���������� ª�ٸ�
				else if(tmp.move+1<time[ni][nj]) {
					//time�� ������Ʈ
					time[ni][nj]=tmp.move+1;
					//���ڸ�(��������)�� �̵�
					q.offer(new Index(ni,nj,tmp.move+1));
				}
				
			}
		}
		
		
		//������ ��쿣 -1 ����
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








		









