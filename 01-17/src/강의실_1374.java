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
public class 강의실_1374 {
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
    	bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	br =new BufferedReader(new InputStreamReader(System.in));
	    int num=Integer.parseInt(br.readLine());
	    
	    //강의 끝나는 시간 값 배열과 시작시간 값 배열을 따로 생성
	    int[] f_arr=new int[num];
	    int[] s_arr=new int[num];
	    
	    for(int i=0;i<num;i++) {
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    Integer.parseInt(st.nextToken());
	     s_arr[i]=Integer.parseInt(st.nextToken());
	    f_arr[i]=Integer.parseInt(st.nextToken());
	    
	    }
	   //끝나는 시간 오름차순 정렬
	   Arrays.sort(f_arr);
	   //시작 시간 오름차순 정렬
	   Arrays.sort(s_arr);
	   
	   
	  //result는 연속으로 진행할수 있는 횟수
	   
	   /* 반복문을 돌면서 순서대로 비교하며, 강의 시작시간이 끝나는 시간보다 큰 경우  result값 +1
	    그리고 다음 값 탐색... 강의 시작시간>강의끝나는 시간인 연속된 경우(result)를 모두 구한후 강의수 (num)에서 빼준다.*/ 
	   
	   //시작 끝
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
