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
public class 치킨거리 {
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
   //뽑은 치킨집 배열 c
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
			//최소거리값 치킨집
				if(min>dist) {
					min=dist;
				}
			}
			//모든 집의 최소거리 치킨집 더하기
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
	    //행 열
	    n=Integer.parseInt(st.nextToken());
	    //최대 치킨집수 
	    m=Integer.parseInt(st.nextToken());

	    
	    
	    ArrayList <Index> chicken_arr=new <Index> ArrayList();
	    int chicken_num=0;
	    
	    for(int i=0;i<n;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	for(int j=0;j<n;j++) {
	    		int tmp=Integer.parseInt(st.nextToken());
	    		//집 arraylist
	    		if(tmp==1) {
	    			h.add(new Index(i,j));
	    		}
	    		//치킨집 arraylist
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
