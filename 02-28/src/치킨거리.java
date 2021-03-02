import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
class Index {
	int i,j;
	Index(int i,int j){
		this.i=i;
		this.j=j;
	}

}*/
public class ġŲ�Ÿ� {
	static int m,n;
	static ArrayList<Index> h=new ArrayList<Index>();
	static int result=Integer.MAX_VALUE;
	
	static void combination(ArrayList<Index> chicken_arr, boolean[] visited, int start,int r,int chicken_num) {
        if (r == 0) {
            bfs(chicken_arr,visited,chicken_num);
            return;
        }

        for (int i = start; i < chicken_num; i++) {
            visited[i]=true;
            combination(chicken_arr, visited, i + 1, r - 1,chicken_num);
            visited[i]=false;
        }
    }
	
	
	static void bfs(ArrayList<Index> chicken_arr, boolean[] visited,int chicken_num) {
   //���� ġŲ�� �迭 c
		Index[] c=new Index[m];
		int num=0;
		
		
		for(int i=0;i<chicken_num;i++) {
			if(visited[i]) {
				Index tmp=chicken_arr.get(i);
				c[num]=tmp;
				num++;
			}

		}
		
		int m_dist=0;
		
		for(int t=0;t<h.size();t++) {
			Index house=h.get(t);
			int min=Integer.MAX_VALUE;
			
			for(int k=0;k<m;k++) {
				int dist=Math.abs(house.i-c[k].i)+Math.abs(house.j-c[k].j);
			//�ּҰŸ��� ġŲ��
				if(min>dist) {
					min=dist;
				}
			}
			//��� ���� �ּҰŸ� ġŲ�� ���ϱ�
			m_dist+=min;

		}
		
		if(result>m_dist)
			result=m_dist;

	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    

	    StringTokenizer st=new StringTokenizer(br.readLine());
	    //�� ��
	    n=Integer.parseInt(st.nextToken());
	    //�ִ� ġŲ���� 
	    m=Integer.parseInt(st.nextToken());

	    
	    
	    ArrayList <Index> chicken_arr=new <Index> ArrayList();
	    int chicken_num=0;
	    
	    for(int i=0;i<n;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	for(int j=0;j<n;j++) {
	    		int tmp=Integer.parseInt(st.nextToken());
	    		//�� arraylist
	    		if(tmp==1) {
	    			h.add(new Index(i,j));
	    		}
	    		//ġŲ�� arraylist
	    		else if(tmp==2) {
	    			chicken_arr.add(new Index(i,j));
	    			chicken_num++;
	    		}

	    	}
	    }
    
        boolean[] visited=new boolean[chicken_num];
	    combination(chicken_arr, visited, 0,m,chicken_num);
	    System.out.print(result);
	}
}
