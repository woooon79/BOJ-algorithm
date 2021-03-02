import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

public class Milkfactory_17199 {
	static BufferedReader br;
	static BufferedWriter bw;
    static boolean[][] arr;
    static int num;
    
    //재귀함수
    //만약 전달받은 스테이션의 연결된 스테이션이 다른 스테이션과 연결되었을 경우를 반복문을 통해 탐색하여 연결값 갱신
	public static void run(int i,int j) {
		for(int a=1;a<num+1;a++) {
			if(j!=a&&arr[j][a]&&!arr[i][a]) {
				arr[i][a]=true;
				run(i,a);
			}
				
		}
	}
    public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
    	 bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	br =new BufferedReader(new InputStreamReader(System.in));
	    num=Integer.parseInt(br.readLine());

	    arr=new boolean[num+1][num+1];
	    for(int i=0;i<num-1;i++) {
		    StringTokenizer st=new StringTokenizer(br.readLine());
	    	int n1=Integer.parseInt(st.nextToken());
	    	int n2=Integer.parseInt(st.nextToken());
	    	
	    	arr[n1][n2]=true; 
	    	
	    }
	    
	    //배열값 1부터 시작
	    for(int i=1;i<num+1;i++) {
	    	for(int j=1;j<num+1;j++) {
               //만약 연결되어 있으면 
	    	   //run 함수 호출을 통해 검사후 연결값 갱신
	    		if(arr[i][j]) {
	    			run(i,j);
	    		}
	    		//열과 행이 같으면 true 대입
		    	if(i==j)
		    	  arr[i][j]=true;
	    	}
	    }
	    
	   int result=-1;
	   
	   //여러 스테이션중 중 모든 스테이션에 연결되어있는 경우 값 찾기
	   //=>행렬에서 column값이 다 true 인 경우
	   //최소값을 찾는것이므로 앞에서부터 찾는다
	    for(int j=1;j<=num;j++) {
	    	 boolean temp=true;
	    	for(int i=1;i<=num;i++) {
	    		if(!arr[i][j]) {
	    			temp=false;
	    			break;
	    		}
	    			
	    	}
	    	if(temp) {
	    		result=j;
	    		break;
	    	}
	    		
	    }
	    
	    System.out.println(result);
	    
	    
    }
}
