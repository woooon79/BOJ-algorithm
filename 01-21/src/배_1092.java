import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 배_1092 {
	 public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		    
		    int t_num=Integer.parseInt(br.readLine());
		    Integer[] trucks=new Integer[t_num];
		    StringTokenizer st=new StringTokenizer(br.readLine());
		    for(int i=0;i<t_num;i++) {
		    	trucks[i]=Integer.parseInt(st.nextToken());
		    }
		    Arrays.sort(trucks,Collections.reverseOrder());
		        
		        
		    int b_num=Integer.parseInt(br.readLine());
		
		    
		   // int[] boxes=new int[b_num];
		    ArrayList<Integer> blst= new ArrayList<Integer>();
		    st=new StringTokenizer(br.readLine());
		    
		    for(int i=0;i<b_num;i++) {
		    	
		    	//boxes[i]=Integer.parseInt(st.nextToken());
		    	int box=Integer.parseInt(st.nextToken());
		    		
		    	blst.add(box);
		    }
		    
		    Collections.sort(blst,Collections.reverseOrder());

		      
		    
		    int result=0;
		    //blst: 박스 배열(arraylist)
		    //trucks: 트럭배열
	    	if(blst.get(0)>trucks[0]) {
	    		System.out.print(-1);
	    		return;
	    	}
		
	    	//j는 각 트럭 넘버
	    	//result는 시간
	    	
	    	else {
		    
		     while(!blst.isEmpty()) {
		    	 int j=0;
		    	 for(int i=0;i<b_num;i++) {
		    		 //만약 주어진 모든 트럭 한바퀴 다 비교하면 for문 break; result 1 증가
		    		 if(j==t_num)
		    			 break;
		    		 
		    		 //트럭이 박스를 옮길수 있다면
		    		 if(trucks[j]>=blst.get(i)) {
		    			 //다음트럭으로 넘어감
		    			 j++;
		    			 //박스개수 하나 빼기
		    			 blst.remove(i);
		    			 b_num--;
		    			 //blst에서 박스 하나를 삭제했기때문에 인덱스가 하나 감소함
		    			 i--;
	
		    		 }
	 
		    	 }
		    	 //시간 하나 증가
		    	 result++;
		     }
		 

	    	}
		    System.out.println(result);
	 }
}
