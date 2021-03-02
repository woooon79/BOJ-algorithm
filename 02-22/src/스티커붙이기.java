import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*class Index{
	int i,j;
	Index(int i,int j){
		this.i=i;
		this.j=j;
	}
}*/
public class 스티커붙이기 {
	static int n,m,k;
	static boolean[][] map;

	public static boolean[][] rotate(boolean[][] sticker,int r,int c) {
		boolean[][] r_sticker=new boolean[c][r];
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(sticker[i][j]) {
					r_sticker[j][(r-1)-i]=true;
				}
			}
		}
	
		return r_sticker;
		
	}
	public static int find(boolean[][] sticker,int count,int num) {
	
		int r =sticker.length;
		int c=sticker[0].length;
		
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {

					boolean check=false;
					Queue<Index> s_q=new LinkedList<Index>();
					for(int t=0;t<r;t++) {
						for(int p=0;p<c;p++) {		
							if(i+t<0 || j+p<0 || i+t>=n || j+p>=m)
								continue;
							
							//스티커가 1이면
							if(sticker[t][p]) {
								//map이 이미 채워져있다면
								//for문 탈출, 다른 map위치 탐색
								if(map[i+t][j+p]) {
									check=true;
									break;
								}
								else {
									s_q.offer(new Index(i+t,j+p));
								}
							}	
						}
						//다른map 위치 탐색
						if(check)
							break;
					}
				    if(!check&&s_q.size()==count) {
						while(!s_q.isEmpty()) {
							Index tmp=s_q.poll();
							map[tmp.i][tmp.j]=true;
						}
						return count;
				    }

				}
			
		}

		//노트북에 못넣는경우
		if(num<3)
		    return find(rotate(sticker,r,c),count,num+1);
	
		return 0;
        		
		
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    n=Integer.parseInt(st.nextToken());
	    m=Integer.parseInt(st.nextToken());
	    k=Integer.parseInt(st.nextToken());
	    
	    map=new boolean[n][m];
	    int total=0;
	    for(int i=0;i<k;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	int row=Integer.parseInt(st.nextToken());
	    	int col=Integer.parseInt(st.nextToken());
	    	
	    	boolean[][] s=new boolean[row][col];
	    	int count=0;
	    	
	    	for(int j=0;j<row;j++) {
	    		st=new StringTokenizer(br.readLine());
	    		for(int p=0;p<col;p++) {
	    			int tmp=Integer.parseInt(st.nextToken());
	    			if(tmp==1) {
	    				s[j][p]=true;
	    				count++;
	    			}
	    		}
	    	}

	    	total+=find(s,count,0);
	    }
	    
	   System.out.println(total);
	    
	}
}
