package ps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 게리맨더링 {
	static int n;
	static int[] p;
	static int p_num=0;
	static boolean[][] region; 
	static boolean chk[];
	static int result=Integer.MAX_VALUE;

	
	
	//부분집합 구하기 
	static void powerSet(boolean[] visited, int n, int idx) {
	    if(idx == n) {
	    	int c=chk_connect(visited);
	        if(c!=-1) {
	        	result=Math.min(result, Math.abs(c-(p_num-c)));
	        }
	        return;
	    }
	 
	    visited[idx] = false;
	    powerSet(visited, n, idx + 1);
	 
	    visited[idx] = true;
	    powerSet(visited, n, idx + 1);
	}
	
	//visited 배열에서 true 인 것이 해당 선거구
	//false 인 것은 다른 선거구
	static int chk_connect(boolean[] visited) {
		Queue<Integer> q= new LinkedList<Integer>();
		
		int t_start=0;
		int f_start=0;
		int t_num=0;
		int f_num=0;
		
		for(int i=1;i<=n;i++) {
			if(visited[i]) {
				t_start=i;
				t_num++;
			}
			else {
				f_start=i;
				f_num++;
			}
		}
	
		
		if(t_num==0 || f_num==0)
			return -1;
		

		
		boolean[] v=new boolean[n+1];
		q.offer(t_start);
		v[t_start]=true;
		int tcount=1;
		
		while(!q.isEmpty()) {
			int tmp=q.poll();
			for(int i=1;i<=n;i++) {
				if(region[tmp][i]&&!v[i]&&visited[i]) {
					q.offer(i);
					v[i]=true;
					tcount++;
					
				}
			}
		}
		
		if(tcount!=t_num)
			return -1;
	
		
		q.clear();
		q.offer(f_start);
		v[f_start]=true;
		
		int fcount=1;
		
		
		while(!q.isEmpty()) {
			int tmp=q.poll();
			for(int i=1;i<=n;i++) {
				if(region[tmp][i]&&!v[i]&&!visited[i]) {
					q.offer(i);
					v[i]=true;
					fcount++;
				}
			}
		}

		if(fcount!=f_num)
			return -1;
		
		int t_popul=0;
		for(int i=1;i<=n;i++) {
			if(visited[i]) {
				t_popul+=p[i];
			}
		}
		return t_popul;
		
	}
	
	
	
	//끊어졌는지 확인
	//끊어진게 2개면 그게 답 / 3개이상이면 -1
	//안끊어졌으면 작은거부터 더해보기
	public static int check(int idx) {
		Queue<Integer> q=new LinkedList<Integer>();
		
		q.offer(idx);
		chk[idx]=true;
		//int total=1;
		int grouptotal=p[idx];
		
		while(!q.isEmpty()) {
			int tmp=q.poll();
			
			for(int i=1;i<=n;i++) {
				if(region[tmp][i]==true&&!chk[i]) {
					q.offer(i);
					chk[i]=true;
					//total++;
					grouptotal+=p[i];
				}
			}	
		}
		
		return grouptotal;
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    

	    //지역수 
	    n=Integer.parseInt(br.readLine());
	    //지역별 인구수 배열(1부터 시작)
	    p=new int[n+1];
	    //연결여부
	    region=new boolean[n+1][n+1];
	    
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    
	    for(int i=1;i<=n;i++) {
	    	
	    	p[i]=Integer.parseInt(st.nextToken());
	    	p_num+=p[i];
	    }
	    
	    
	    
	    for(int i=1;i<=n;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	int num=Integer.parseInt(st.nextToken());
	    	for(int j=0;j<num;j++) {
	    		int tmp=Integer.parseInt(st.nextToken());
	    		region[i][tmp]=true;
	    		region[tmp][i]=true;
	    	}
	    }

	    
	    chk=new boolean[n+1];
	    int connect_total=check(1);
	    if(connect_total==p_num) {
	    	boolean[] visited=new boolean[n+1];
	    	powerSet(visited,n+1,1);
	    	System.out.println(result);
	    }
	    else {
	    	for(int i=1;i<=n;i++) {
	    		if(!chk[i]) {
	    			int rest=check(i);
	    			if(rest+connect_total==p_num) {
	    				System.out.println(Math.abs(rest-connect_total));	
	    			}
	    			else {

	    				System.out.println(-1);
	    			}
	    			return;
	    				
	    		}
	    	}
	    }
	
	}
}
