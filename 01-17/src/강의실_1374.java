import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
class Lecture implements Comparable <Lecture>{
	long start;
	long finish;
	Lecture(long start,long finish){
		this.start=start;
		this.finish=finish;
	}
	Lecture(){
		
	}
	 @Override
	    public int compareTo(Lecture o) {
		 if(this.finish==o.finish)
			 return (int) (this.start-o.start);
		 else
	        return (int) (this.finish - o.finish);
	    }
}*/
public class ���ǽ�_1374 {
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
    	bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	br =new BufferedReader(new InputStreamReader(System.in));
	    int num=Integer.parseInt(br.readLine());
	    
	    //���� ������ �ð� �� �迭�� ���۽ð� �� �迭�� ���� ����
	    int[] f_arr=new int[num];
	    int[] s_arr=new int[num];
	    
	    for(int i=0;i<num;i++) {
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    Integer.parseInt(st.nextToken());
	     s_arr[i]=Integer.parseInt(st.nextToken());
	    f_arr[i]=Integer.parseInt(st.nextToken());
	    
	    }
	   //������ �ð� �������� ����
	   Arrays.sort(f_arr);
	   //���� �ð� �������� ����
	   Arrays.sort(s_arr);
	   
	   
	  //result�� �������� �����Ҽ� �ִ� Ƚ��
	   
	   /* �ݺ����� ���鼭 ������� ���ϸ�, ���� ���۽ð��� ������ �ð����� ū ���  result�� +1
	    �׸��� ���� �� Ž��... ���� ���۽ð�>���ǳ����� �ð��� ���ӵ� ���(result)�� ��� ������ ���Ǽ� (num)���� ���ش�.*/ 
	   
	   //���� ��
	   //1 3
	   //4 7
	   //10 12
	   //13 17
	   
	   
	   int result=0;
	   int j=0;
	   for(int i=0;i<num;i++) {
		   while(j<num) {
			   
			   if(f_arr[i]<=s_arr[j]) {
				   result++;
				  j++;
				   break;
			   }
               j++;
		   }
	   }
	   
	    System.out.println(num-result);
	    
	    
	}
}
