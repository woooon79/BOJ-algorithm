import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class 가운데를말해요_1655 {
	static BufferedReader br;
	static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	br =new BufferedReader(new InputStreamReader(System.in));
	    int num=Integer.parseInt(br.readLine());
	    StringBuilder st=new StringBuilder();
	  
	    //두개 우선순위 큐 생성
	    //t_q: 내림차순 정렬 (중간값~최소값)
	    //q: 오름차순 정렬 (중간값+1~최대값)
	    PriorityQueue<Integer> q = new PriorityQueue<>();
	    PriorityQueue<Integer> t_q = new PriorityQueue<Integer>(Collections.reverseOrder());
	    
	    /**무조건 t_q의 peek값이 중간값 
	     => t_q의 사이즈는 항상 q와 같거나 q보다 1만큼 커야함**/
	    
	    //첫번째 값 t_q에 push
	    t_q.offer(Integer.parseInt(br.readLine()));
	    st.append(t_q.peek()+"\n");
	    
	    for(int i=1;i<num;i++) {
	    	int tmp=Integer.parseInt(br.readLine());
	    	
	    	//t_q에 우선삽입
	    	t_q.offer(tmp);
            
	    	//t_q 사이즈가 q의 사이즈보다 2 이상 차이날 경우 혹은 입력받은 값이 q의 최소값보다 클경우 t_q에서 뺀후 다시 q에삽입
	    	if(t_q.size()-q.size()>1||tmp>q.peek()) {
	    		q.offer(t_q.poll());
	    	}
	    	//q의 사이즈가 더 클 경우에는 q에서 하나 뺀 후 다시 t_q에 삽입
	    	 if(q.size()>t_q.size()) {
	    		t_q.offer(q.poll());
	    	}
            

    		st.append(t_q.peek()+"\n");

	    }
	  System.out.print(st);

    }
}
