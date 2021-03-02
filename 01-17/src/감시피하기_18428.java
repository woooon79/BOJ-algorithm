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

//���Ʈ ����

public class �������ϱ�_18428 {
	static BufferedReader br;
    static BufferedWriter bw;
    static String[][] map;
    static int num;
    static ArrayList <Index> t;
    static String result="NO";
    static void combination(ArrayList<Index> arr, boolean[] visited, int start,  int r) {
        if (r == 0) {
        	//��ֹ��� ��ġ�� obs �� true�� ǥ��
        	boolean[][] obs=new boolean[num][num];
        	for(int i=0;i<arr.size();i++) {
        		if(visited[i]) {
        			obs[arr.get(i).i][arr.get(i).j]=true; 
        		}
        	}
        	//check �Լ��� �˻�
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
    	  
          //�����Ե��� ����ŭ �ݺ���
       for(int k=0;k<t.size();k++) {
    	
    	   //ii:������ �� ��
    	   //jj:������ �� ��
    		   int ii=t.get(k).i;
    		   int jj=t.get(k).j;
    		   
    		  
        	//��
    		  for(int i=ii;i+1<num;i++) {
    			  if(chk[i+1][jj])
    				  continue;
    			  //�л�ã�� ��� return
    			   if(map[i+1][jj].equals("S"))
    				   return;
    			   //��ֹ� ���� ��� ���� Ž�� ����
    			   if(obs[i+1][jj])
    				   break;
    			   //Ž�� �� chk �� true�� ����
    			   chk[i+1][jj]=true;
    		  }
    		  
    		  //��
    		  for(int j=jj;j+1<num;j++) {
       			  if(chk[ii][j+1])
    				  continue;
    			   if(map[ii][j+1].equals("S"))
    				   return;
       			   if(obs[ii][j+1])
    				   break;
    			   chk[ii][j+1]=true;
    		   }
    		  //��
    		  for(int i=ii;i-1>=0;i--) {
     			  if(chk[i-1][jj])
    				  continue;
    			   if(map[i-1][jj].equals("S"))
    				   return;
       			   if(obs[i-1][jj])
    				   break;
    			   chk[i-1][jj]=true;
    		   }
    		  //��
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
		        	//T�ΰ�� t����Ʈ�� �߰�
		        	t.add(new Index(i,j));
		        }
		        //X�ΰ�� arr����Ʈ�� �߰� (��ֹ��� ������ �ִ� ��ġ)
		        if(tmp.contentEquals("X"))
		        	arr.add(new Index(i,j));
		      }		    
	        }
		    
		    boolean[] visited=new boolean[arr.size()];
		    //��ֹ� 3���� ���� �� �ִ� ��ġ ����
		    combination(arr,visited,0,3);
		    System.out.println(result);
		     
		    
		    
		    

	  }
}