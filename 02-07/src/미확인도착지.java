import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class ��Ȯ�ε����� {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    int testcase=Integer.parseInt(br.readLine());
	   
	    for(int k=0;k<testcase;k++) {
	    	StringTokenizer st=new StringTokenizer(br.readLine());
	    	//������
	    	int n=Integer.parseInt(st.nextToken());
	    	//����
	    	int m=Integer.parseInt(st.nextToken());
	    	//������ �ĺ�
	    	int t=Integer.parseInt(st.nextToken());
	    	int[] ts=new int[t];
	    	
	    	st=new StringTokenizer(br.readLine());
	    	//������ �����
	    	int s=Integer.parseInt(st.nextToken());
	    	
	    	int g=Integer.parseInt(st.nextToken());
	    	int h=Integer.parseInt(st.nextToken());
	    	int[][] map=new int[n+1][n+1];
	    	
	        for(int i=0;i<m;i++) {
	        	st=new StringTokenizer(br.readLine());
	        	int a=Integer.parseInt(st.nextToken());
	        	int b=Integer.parseInt(st.nextToken());
	        	int d=Integer.parseInt(st.nextToken());
	        	
	        	map[a][b]=d;
	        	map[b][a]=d;
	        }
	        
	        for(int i=0;i<t;i++) {
	        	ts[i]=Integer.parseInt(br.readLine());
	        }
	        Arrays.parallelSort(ts);
	    	
	       
	        int[] dist=new int[n+1];
	        Arrays.fill(dist, Integer.MAX_VALUE);
	        boolean[] chk=new boolean[n+1];
	        int[] route=new int[n+1];
	        
	        //������ �ʱ�ȭ
	        dist[s]=0;
	        chk[s]=true;
	        route[s]=s;
	        
	        
	      //������ s�� ����� ��� �� dist�迭�� ���� 
	        for(int i=1;i<n+1;i++){
	            if(!chk[i] && map[s][i]!=0){
	                dist[i] = map[s][i];
	                route[i]=s;
	            }
	        }

	        for(int i=0;i<n-1;i++){

	            int min=Integer.MAX_VALUE;
	            int min_i=0;
	             
	            //s�� ����Ȱ��� �ּҰŸ��� ��� ã��
	            for(int j=1;j<n+1;j++){
	                if(!chk[j] && dist[j]!=Integer.MAX_VALUE){
	                    if(dist[j]<min ){
	                        min=dist[j];
	                        min_i = j;
	                    }
	                    else if(dist[j]==min) {
	                    	if(dist[j]==g||dist[j]==h) {
	                    		min=dist[j];
	 	                        min_i = j;
	                    	}
	                    }
	                }
	            }
	            //�ּҰŸ��� ��忡 �湮(true) ǥ��
	            chk[min_i] = true;
	            //���� �湮���� �ʾҰ�, �ּҰŸ��� ��忡 ����� ���� �ּҰŸ��� ����
	            for(int j=1;j<n+1;j++){
	                if(!chk[j] && map[min_i][j]!=0){
	                    if(dist[j]>dist[min_i]+map[min_i][j]){
	                        dist[j] = dist[min_i]+map[min_i][j];
	                        route[j]=min_i;
	                    }
	                    
	                }
	            }
	            //�ݺ�...
	 
	        }

            StringBuilder sb=new StringBuilder();
            
	        for(int i=0;i<t;i++) {
	        	int dest=ts[i];
	        	while(true) {
	        		if(route[dest]==s)
	        			break;
	        			
	        		if(route[dest]==g) {
	        			dest=route[dest];
	        			if(route[dest]==h)
	        				sb.append(ts[i]+" ");	
	        			break;
	        		}
	        		
	        		if(route[dest]==h) {
	        			dest=route[dest];
	        			if(route[dest]==g)
	        				sb.append(ts[i]+" ");	
	        			break;
	        		}
	        		
	        		dest=route[dest];
	        	}
	        	
	        }
	        
	        System.out.println(sb);

	       
	    }

	}
}
