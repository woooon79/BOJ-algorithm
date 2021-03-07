package ps;

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
	Index(int i, int j){
		this.i=i;
		this.j=j;
	}
}
public class ���ѱ� {
	static int m,n;
	static ArrayList<Index>[][] map;
	static int[] di= {-1,0,0,1};
	static int[] dj= {0,-1,1,0};
	
	static int solution() {
		
		boolean[][] turn_on=new boolean[n+1][n+1];
		boolean[][] visit=new boolean[n+1][n+1];
		
		Queue<Index> q=new LinkedList<Index>();
		q.offer(new Index(1,1));
		//��Ű��
		turn_on[1][1]=true;
		//�湮
		visit[1][1]=true;
		//������ ��� +1
		int result=1;
		
		while(!q.isEmpty()) {
			Index tmp=q.poll();
			int i=tmp.i;
			int j=tmp.j;
            
			//�ش� �濡 ����� ����ġ��
			//��Ű�� �۾�
			for(int k=0;k<map[i][j].size();k++) {
				
				Index s =map[i][j].get(k);
				int new_i=s.i;
				int new_j=s.j;
				
				//�̹� ���� ���� �ִٸ� continue
				if(turn_on[s.i][s.j])
					continue;
				//��Ų��
				turn_on[s.i][s.j]=true;
				result++;
				
				//���� Ų ���� ���� ���� ���� �ִ� ��ġ�� �ִ��� �˻�
				//�� ���� ��Ų ���� ���� �湮�ߴ� ��� ����Ǿ��ִ��� �˻�
				for(int p=0;p<4;p++) {
					 int ni=new_i+di[p];
					 int nj=new_j+dj[p];
					
					if(ni<1||ni>n||nj<1||nj>n)
						continue;
					
					//���� ���� �湮�ߴ� ��� ����Ǿ� �ִٸ� ������ġ���� ���ο� ��Ų ������ �� �� �����Ƿ� ť�� ����
					if(visit[ni][nj]) {
					q.offer(new Index(new_i,new_j));
					//�湮
					visit[new_i][new_j]=true;
					}
					
				}
				
			}
			
			//������ġ���� ���� �ִ� ���ο� �浵 ���
			for(int p=0;p<4;p++) {
				 int ni=i+di[p];
				 int nj=j+dj[p];
				
				if(ni<1||ni>n||nj<1||nj>n)
					continue;
				//�湮��������, ���� �����ִٸ� ť�� ����
				if(!visit[ni][nj]&&turn_on[ni][nj]) {
				q.offer(new Index(ni,nj));
				visit[ni][nj]=true;
				}
			}
		}
		
		
		return result;
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    n=Integer.parseInt(st.nextToken());
	    m=Integer.parseInt(st.nextToken());
	    //arraylist 2���� �迭
	    map=new ArrayList[n+1][n+1];
	    
	    for(int i=1;i<=n;i++) {
	    	for(int j=1;j<=n;j++) {
	    		map[i][j]=new ArrayList<Index>();
	    	}
	    }
	    //�濡 �ִ� ����ġ�� arraylist �� ����
	    for(int i=0;i<m;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	int x=Integer.parseInt(st.nextToken());
	    	int y=Integer.parseInt(st.nextToken());
	    	int a=Integer.parseInt(st.nextToken());
	    	int b=Integer.parseInt(st.nextToken());
	    	
	    	map[x][y].add(new Index(a,b));
	    }
	    
	    System.out.println(solution());
	    
	}
}
