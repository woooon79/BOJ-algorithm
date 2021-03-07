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
		//현재 인덱스가 n이라면
	    if(idx == n) {
	    	//두집합이 각각 연결되어있는지 판별(-1 또는 t선거구 인구수)
	    	int c=chk_connect(visited);
	    	//연결되어 있다면 두 지역 인구수의 차를 최소값으로 업데이트
	        if(c!=-1) {
	        	result=Math.min(result, Math.abs(c-(p_num-c)));
	        }
	        return;
	    }
	 
	    //현재 인덱스가 포함되지 않는 경우
	    visited[idx] = false;
	    powerSet(visited, n, idx + 1);
	 
	    //현재 인덱스가 포함되는 경우
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
				//t 선거구 시작 인덱스와 t 선거구 지역 개수
				t_start=i;
				t_num++;
			}
			else {
				//f 선거구 시작 인덱스와 f 선거구 지역 개수
				f_start=i;
				f_num++;
			}
		}
	
		//두 선거구 중 하나라도 지역개수가 0이라면 -1 리턴
		//선거구는 지역이 1이상 이어야함
		if(t_num==0 || f_num==0)
			return -1;
		

		
		boolean[] v=new boolean[n+1];
		q.offer(t_start);
		v[t_start]=true;
		int tcount=1;
		
		while(!q.isEmpty()) {
			int tmp=q.poll();
			for(int i=1;i<=n;i++) {
				//연결되어있고, 방문한적 없으며, t 선거구인경우 큐 삽입
				if(region[tmp][i]&&!v[i]&&visited[i]) {
					q.offer(i);
					v[i]=true;
					//해당 경우 개수 구함
					tcount++;
					
				}
			}
		}
		
		//t선거구가 연결되어있지 않은경우이므로 -1 리턴
		if(tcount!=t_num)
			return -1;
	
		//f도 반복
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
		
		
		//t 선거구 인구수 리턴
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
		int grouptotal=p[idx];
		
		while(!q.isEmpty()) {
			int tmp=q.poll();
			
			for(int i=1;i<=n;i++) {
				//방문하지 않았고 연결되어있다면 해당 지역 큐 삽입
				if(region[tmp][i]==true&&!chk[i]) {
					q.offer(i);
					chk[i]=true;
					//해당 지역 인구수를 grouptotal에 더함
					grouptotal+=p[i];
				}
			}	
		}
		
		//idx와 연결된 지역의 모든 인구수
		return grouptotal;
	}
	

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		/*구역을 두 개의 선거구로 나눠야 하고, 각 구역은 두 선거구 중 하나에 포함되어야 한다. 
		 * 선거구는 구역을 적어도 하나 포함해야 하고, 
		 * 한 선거구에 포함되어 있는 구역은 모두 연결되어 있어야 한다.*/
		
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
	    	//총 인구수
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
	    //연결되어있는 지역 수
	    int connect_total=check(1);
	    
	    //connect total이 모든 인구수와 같다면 
	    //모든 지역이 연결되어있다면
	    //두 부분집합으로 나눈후, 최소값 출력
	    if(connect_total==p_num) {
	    	boolean[] visited=new boolean[n+1];
	    	powerSet(visited,n+1,1);
	    	System.out.println(result);
	    }
	    
	    //연결이 끊겨 있을 경우
	    else {
	    	for(int i=1;i<=n;i++) {
	    		//연결이 끊겨 있는 지역이라면 
	    		if(!chk[i]) {
	    			//해당 지역에서 연결된 지역 인구수 rest 탐색
	    			int rest=check(i);
	    			
	    			//현재 연결 지역 인구수와 아까구한 연결지역인구수 합이 모든 인구수라면 그 차를 출력
	    			if(rest+connect_total==p_num) {
	    				System.out.println(Math.abs(rest-connect_total));	
	    			}
	    			
	    			//아니라면 3개이상 지역이 연결이 끊겨있는 경우이므로 -1 출력
	    			//두 선거구로 나눌 수 없다
	    			else {

	    				System.out.println(-1);
	    			}
	    			return;
	    				
	    		}
	    	}
	    }
	
	}
}
