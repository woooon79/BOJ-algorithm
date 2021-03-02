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

public class ��_1092 {
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
		    //blst: �ڽ� �迭(arraylist)
		    //trucks: Ʈ���迭
	    	if(blst.get(0)>trucks[0]) {
	    		System.out.print(-1);
	    		return;
	    	}
		
	    	//j�� �� Ʈ�� �ѹ�
	    	//result�� �ð�
	    	
	    	else {
		    
		     while(!blst.isEmpty()) {
		    	 int j=0;
		    	 for(int i=0;i<b_num;i++) {
		    		 //���� �־��� ��� Ʈ�� �ѹ��� �� ���ϸ� for�� break; result 1 ����
		    		 if(j==t_num)
		    			 break;
		    		 
		    		 //Ʈ���� �ڽ��� �ű�� �ִٸ�
		    		 if(trucks[j]>=blst.get(i)) {
		    			 //����Ʈ������ �Ѿ
		    			 j++;
		    			 //�ڽ����� �ϳ� ����
		    			 blst.remove(i);
		    			 b_num--;
		    			 //blst���� �ڽ� �ϳ��� �����߱⶧���� �ε����� �ϳ� ������
		    			 i--;
	
		    		 }
	 
		    	 }
		    	 //�ð� �ϳ� ����
		    	 result++;
		     }
		 

	    	}
		    System.out.println(result);
	 }
}
