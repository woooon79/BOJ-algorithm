import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class ��������ؿ�_1655 {
	static BufferedReader br;
	static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	br =new BufferedReader(new InputStreamReader(System.in));
	    int num=Integer.parseInt(br.readLine());
	    StringBuilder st=new StringBuilder();
	  
	    //�ΰ� �켱���� ť ����
	    //t_q: �������� ���� (�߰���~�ּҰ�)
	    //q: �������� ���� (�߰���+1~�ִ밪)
	    PriorityQueue<Integer> q = new PriorityQueue<>();
	    PriorityQueue<Integer> t_q = new PriorityQueue<Integer>(Collections.reverseOrder());
	    
	    /**������ t_q�� peek���� �߰��� 
	     => t_q�� ������� �׻� q�� ���ų� q���� 1��ŭ Ŀ����**/
	    
	    //ù��° �� t_q�� push
	    t_q.offer(Integer.parseInt(br.readLine()));
	    st.append(t_q.peek()+"\n");
	    
	    for(int i=1;i<num;i++) {
	    	int tmp=Integer.parseInt(br.readLine());
	    	
	    	//t_q�� �켱����
	    	t_q.offer(tmp);
            
	    	//t_q ����� q�� ������� 2 �̻� ���̳� ��� Ȥ�� �Է¹��� ���� q�� �ּҰ����� Ŭ��� t_q���� ���� �ٽ� q������
	    	if(t_q.size()-q.size()>1||tmp>q.peek()) {
	    		q.offer(t_q.poll());
	    	}
	    	//q�� ����� �� Ŭ ��쿡�� q���� �ϳ� �� �� �ٽ� t_q�� ����
	    	 if(q.size()>t_q.size()) {
	    		t_q.offer(q.poll());
	    	}
            

    		st.append(t_q.peek()+"\n");

	    }
	  System.out.print(st);

    }
}
