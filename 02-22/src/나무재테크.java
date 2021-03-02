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


class Tree implements Comparable<Tree>{
	int i,j,age;
	Tree(int i,int j,int age){
		this.i=i;
		this.j=j;
		this.age=age;
	}
	  @Override
      public int compareTo(Tree o) {
          return this.age - o.age;
      }

}


public class ��������ũ {
	static int n,m,k;
	static int[][] a;
	static int[][] map;
	static LinkedList<Integer>[][] tree_info;
	static int[] di= {1,-1,0,0,-1,-1,1,1};
	static int[] dj= {0,0,-1,1,1,-1,1,-1};
	
	public static int bfs(PriorityQueue<Tree> q) {
		
		int result=0;
		Queue<Tree> breed=new LinkedList<Tree>();
		Queue<Tree> dead=new LinkedList<Tree>();
		
		for(int y=0;y<k;y++) {
			result=0;
			PriorityQueue<Tree> n_q=new PriorityQueue<Tree>();
			
			//��
				while(!q.isEmpty()) {
					Tree tmp=q.poll();
					int i=tmp.i;
					int j=tmp.j;
					int age=tmp.age;

				if(map[i][j]-age>=0) {
				    map[i][j]-=age;
				    n_q.offer(new Tree(i,j,++age));
				    result++;
				    if(age%5==0) {
				    	breed.offer(new Tree(i,j,age));	
				    }
				}
				else {
					dead.offer(new Tree(i,j,age));
				}
				
			}
				q=new PriorityQueue(n_q);
			
			
			//����
			while(!dead.isEmpty()) {
				Tree d=dead.poll();
                int i=d.i;
                int j=d.j;
				map[d.i][d.j]+=d.age/2;
			}
			
			//����
			while(!breed.isEmpty()) {
				Tree tmp=breed.poll();
				for(int p=0;p<8;p++) {
					 int ni=tmp.i+di[p];
					 int nj=tmp.j+dj[p];
					
					if(ni<1||ni>n||nj<1||nj>n)
						continue;
						
					result++;
					q.offer(new Tree(ni,nj,1));
		
				}
			}
			
			//�ܿ�
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					map[i][j]+=a[i][j];
				}
			}

		}
		
		return result;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    //�� : ��������� ���̸�ŭ ��� ����(�������� ����) . ����+1, 
	    //����: ����  �������� ����/2 ��ŭ ������� �߰�
	    //����: ���̰� 5�� ����� ������ ����. ���� 8ĭ�� ���̰� 1�� ������ ����
        //�ܿ�: ����߰� 	
	    
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    n=Integer.parseInt(st.nextToken());
	    m=Integer.parseInt(st.nextToken());
	    k=Integer.parseInt(st.nextToken());
	    a=new int[n+1][n+1];
	    map=new int[n+1][n+1];
	
	    
	    for(int[] r:map)
	    	Arrays.fill(r,5);
	    
	    for(int i=1;i<=n;i++) {
	    	 st=new StringTokenizer(br.readLine());
	    	for(int j=1;j<=n;j++) {
	    		a[i][j]=Integer.parseInt(st.nextToken());
	    	}
	    }
	    
	    PriorityQueue<Tree> q=new PriorityQueue<Tree>();
	    
	    for(int i=0;i<m;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	 
	    	int row=Integer.parseInt(st.nextToken());
	    	int col=Integer.parseInt(st.nextToken());
	    	int age=Integer.parseInt(st.nextToken());
	    	
	    	q.offer(new Tree(row,col,age));	    	
	    }

	    System.out.println(bfs(q));
	}
}