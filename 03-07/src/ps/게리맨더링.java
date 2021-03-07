package ps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class �Ը��Ǵ��� {
	static int n;
	static int[] p;
	static int p_num=0;
	static boolean[][] region; 
	static boolean chk[];
	static int result=Integer.MAX_VALUE;

	
	
	//�κ����� ���ϱ� 
	static void powerSet(boolean[] visited, int n, int idx) {
		//���� �ε����� n�̶��
	    if(idx == n) {
	    	//�������� ���� ����Ǿ��ִ��� �Ǻ�(-1 �Ǵ� t���ű� �α���)
	    	int c=chk_connect(visited);
	    	//����Ǿ� �ִٸ� �� ���� �α����� ���� �ּҰ����� ������Ʈ
	        if(c!=-1) {
	        	result=Math.min(result, Math.abs(c-(p_num-c)));
	        }
	        return;
	    }
	 
	    //���� �ε����� ���Ե��� �ʴ� ���
	    visited[idx] = false;
	    powerSet(visited, n, idx + 1);
	 
	    //���� �ε����� ���ԵǴ� ���
	    visited[idx] = true;
	    powerSet(visited, n, idx + 1);
	}
	
	
	
	//visited �迭���� true �� ���� �ش� ���ű�
	//false �� ���� �ٸ� ���ű�
	static int chk_connect(boolean[] visited) {
		Queue<Integer> q= new LinkedList<Integer>();
		
		int t_start=0;
		int f_start=0;
		int t_num=0;
		int f_num=0;
		
		for(int i=1;i<=n;i++) {
			if(visited[i]) {
				//t ���ű� ���� �ε����� t ���ű� ���� ����
				t_start=i;
				t_num++;
			}
			else {
				//f ���ű� ���� �ε����� f ���ű� ���� ����
				f_start=i;
				f_num++;
			}
		}
	
		//�� ���ű� �� �ϳ��� ���������� 0�̶�� -1 ����
		//���ű��� ������ 1�̻� �̾����
		if(t_num==0 || f_num==0)
			return -1;
		

		
		boolean[] v=new boolean[n+1];
		q.offer(t_start);
		v[t_start]=true;
		int tcount=1;
		
		while(!q.isEmpty()) {
			int tmp=q.poll();
			for(int i=1;i<=n;i++) {
				//����Ǿ��ְ�, �湮���� ������, t ���ű��ΰ�� ť ����
				if(region[tmp][i]&&!v[i]&&visited[i]) {
					q.offer(i);
					v[i]=true;
					//�ش� ��� ���� ����
					tcount++;
					
				}
			}
		}
		
		//t���ű��� ����Ǿ����� ��������̹Ƿ� -1 ����
		if(tcount!=t_num)
			return -1;
	
		//f�� �ݺ�
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
		
		
		//t ���ű� �α��� ����
		int t_popul=0;
		for(int i=1;i<=n;i++) {
			if(visited[i]) {
				t_popul+=p[i];
			}
		}
		return t_popul;
		
	}
	
	
	
	//���������� Ȯ��
	//�������� 2���� �װ� �� / 3���̻��̸� -1
	//�Ȳ��������� �����ź��� ���غ���
	public static int check(int idx) {
		Queue<Integer> q=new LinkedList<Integer>();
		
		q.offer(idx);
		chk[idx]=true;
		int grouptotal=p[idx];
		
		while(!q.isEmpty()) {
			int tmp=q.poll();
			
			for(int i=1;i<=n;i++) {
				//�湮���� �ʾҰ� ����Ǿ��ִٸ� �ش� ���� ť ����
				if(region[tmp][i]==true&&!chk[i]) {
					q.offer(i);
					chk[i]=true;
					//�ش� ���� �α����� grouptotal�� ����
					grouptotal+=p[i];
				}
			}	
		}
		
		//idx�� ����� ������ ��� �α���
		return grouptotal;
	}
	

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		/*������ �� ���� ���ű��� ������ �ϰ�, �� ������ �� ���ű� �� �ϳ��� ���ԵǾ�� �Ѵ�. 
		 * ���ű��� ������ ��� �ϳ� �����ؾ� �ϰ�, 
		 * �� ���ű��� ���ԵǾ� �ִ� ������ ��� ����Ǿ� �־�� �Ѵ�.*/
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    

	    //������ 
	    n=Integer.parseInt(br.readLine());
	    //������ �α��� �迭(1���� ����)
	    p=new int[n+1];
	    //���Ῡ��
	    region=new boolean[n+1][n+1];
	    
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    
	    for(int i=1;i<=n;i++) {
	    	p[i]=Integer.parseInt(st.nextToken());
	    	//�� �α���
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
	    //����Ǿ��ִ� ���� ��
	    int connect_total=check(1);
	    
	    //connect total�� ��� �α����� ���ٸ� 
	    //��� ������ ����Ǿ��ִٸ�
	    //�� �κ��������� ������, �ּҰ� ���
	    if(connect_total==p_num) {
	    	boolean[] visited=new boolean[n+1];
	    	powerSet(visited,n+1,1);
	    	System.out.println(result);
	    }
	    
	    //������ ���� ���� ���
	    else {
	    	for(int i=1;i<=n;i++) {
	    		//������ ���� �ִ� �����̶�� 
	    		if(!chk[i]) {
	    			//�ش� �������� ����� ���� �α��� rest Ž��
	    			int rest=check(i);
	    			
	    			//���� ���� ���� �α����� �Ʊ�� ���������α��� ���� ��� �α������ �� ���� ���
	    			if(rest+connect_total==p_num) {
	    				System.out.println(Math.abs(rest-connect_total));	
	    			}
	    			
	    			//�ƴ϶�� 3���̻� ������ ������ �����ִ� ����̹Ƿ� -1 ���
	    			//�� ���ű��� ���� �� ����
	    			else {

	    				System.out.println(-1);
	    			}
	    			return;
	    				
	    		}
	    	}
	    }
	
	}
}
