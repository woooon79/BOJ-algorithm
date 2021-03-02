import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

//브루트 포스

public class 감시피하기_18428 {
	static BufferedReader br;
    static BufferedWriter bw;
    static String[][] map;
    static int num;
    static ArrayList <Index> t;
    static String result="NO";
    static void combination(ArrayList<Index> arr, boolean[] visited, int start,  int r) {
        if (r == 0) {
        	//장애물의 위치를 obs 에 true로 표시
        	boolean[][] obs=new boolean[num][num];
        	for(int i=0;i<arr.size();i++) {
        		if(visited[i]) {
        			obs[arr.get(i).i][arr.get(i).j]=true; 
        		}
        	}
        	//check 함수로 검사
        	check(obs);
            return;
        }

        for (int i = start; i < arr.size(); i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, r - 1);
            visited[i] = false;
        }
    }
    static void check(boolean[][] obs) {

          boolean[][] chk=new boolean[num][num]; 
    	  
          //선생님들의 수만큼 반복문
       for(int k=0;k<t.size();k++) {
    	
    	   //ii:선생님 행 값
    	   //jj:선생님 열 값
    		   int ii=t.get(k).i;
    		   int jj=t.get(k).j;
    		   
    		  
        	//남
    		  for(int i=ii;i+1<num;i++) {
    			  if(chk[i+1][jj])
    				  continue;
    			  //학생찾을 경우 return
    			   if(map[i+1][jj].equals("S"))
    				   return;
    			   //장애물 있을 경우 남쪽 탐색 종료
    			   if(obs[i+1][jj])
    				   break;
    			   //탐색 후 chk 값 true로 변경
    			   chk[i+1][jj]=true;
    		  }
    		  
    		  //동
    		  for(int j=jj;j+1<num;j++) {
       			  if(chk[ii][j+1])
    				  continue;
    			   if(map[ii][j+1].equals("S"))
    				   return;
       			   if(obs[ii][j+1])
    				   break;
    			   chk[ii][j+1]=true;
    		   }
    		  //북
    		  for(int i=ii;i-1>=0;i--) {
     			  if(chk[i-1][jj])
    				  continue;
    			   if(map[i-1][jj].equals("S"))
    				   return;
       			   if(obs[i-1][jj])
    				   break;
    			   chk[i-1][jj]=true;
    		   }
    		  //서
    		  for(int j=jj;j-1>=0;j--){
     			  if(chk[ii][j-1])
    				  continue;
    			   if(map[ii][j-1].equals("S"))
    				   return;
       			   if(obs[ii][j-1])
    				   break;
    			   chk[ii][j-1]=true;
    		   }

    		   
    		   }
    	   
    	   result="YES";
    	   
    	   
    	   }
    	   

    			   
       
    	
    	
    	
    
	  public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			br =new BufferedReader(new InputStreamReader(System.in));
		    bw = new BufferedWriter(new OutputStreamWriter(System.out));
		    num=Integer.parseInt(br.readLine());
		    map=new String[num][num];
		    t=new ArrayList <Index>();
		    
		    ArrayList <Index> arr=new ArrayList <Index>();
		    for(int i=0;i<num;i++) {
		    StringTokenizer st=new StringTokenizer(br.readLine());
		    for(int j=0;j<num;j++) {
		        String tmp=st.nextToken();	
		        map[i][j]=tmp;
		        if(tmp.equals("T")) {
		        	//T인경우 t리스트에 추가
		        	t.add(new Index(i,j));
		        }
		        //X인경우 arr리스트에 추가 (장애물을 놓을수 있는 위치)
		        if(tmp.contentEquals("X"))
		        	arr.add(new Index(i,j));
		      }		    
	        }
		    
		    boolean[] visited=new boolean[arr.size()];
		    //장애물 3개를 놓을 수 있는 위치 조합
		    combination(arr,visited,0,3);
		    System.out.println(result);
		     
		    
		    
		    

	  }
}