import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 알파벳 {
	static int[] di= {1,-1,0,0};
	static int[] dj= {0,0,-1,1};
	static boolean[][] chk;
	static char[][] map;
	static int r,c;
	static int ans;
	
	static int rdfs(boolean[] alphabet,int i,int j,int count) {

		alphabet[map[i][j]-65]=true;
		//System.out.print(count);
		//for(int k=0;k<26;k++)
       // System.out.print(alphabet[k]+" ");
		//처음 문자 count 값(초기값)
		int max=count;
		//System.out.println();
			
			for(int k=0;k<4;k++) {
				int ni=i+di[k];
				int nj=j+dj[k];
				
				if(ni<0||ni>=r||nj<0||nj>=c)
					continue;
				
				if(!alphabet[map[ni][nj]-65]) {
					int t=rdfs(alphabet.clone(),ni,nj,count+1);
					//count값 =max값 큰값으로 없데이트
					if(t>max);{
					   max=t;
                       ans=t;
					}
				}
			
	       	}

			return ans>max?ans:max;
			
			
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//65+0=a

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    r=Integer.parseInt(st.nextToken());
	    c=Integer.parseInt(st.nextToken());
	    map=new char[r][c];
	    chk=new boolean[r][c];
	    
	    for(int i=0;i<r;i++) {
	    	map[i]=br.readLine().toCharArray();
	    }
		boolean[] alphabet= new boolean[26];
		
		System.out.println(rdfs(alphabet,0,0,1));
	    
	}
}
