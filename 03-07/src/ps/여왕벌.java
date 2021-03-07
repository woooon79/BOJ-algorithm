package ps;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 여왕벌{
	static int m,n;
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//매일 한번 자람
		//첫날 모든 애벌레 크기 1
		//0열 0행 은 입력으로 주어진만큼
		//나머지: 왼, 왼위,위 다 자란다음 제일 많이 자란만큼
		
		//이때 0열 0행이 왼쪽아래부터 오른쪽 위까지 오름차순으로 증가하기 때문에
		//결국 제일 많이 자란건 내위치 위에 있는 것
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    

	    StringTokenizer st=new StringTokenizer(br.readLine());
	    m=Integer.parseInt(st.nextToken());
	    n=Integer.parseInt(st.nextToken());

    
	 int[] first_rc=new int[2*m-1];
        
	 for(int i=0;i<2*m-1;i++) {
		 //애벌레 크기 1부터 시작하므로 1을 다 채움
	    	Arrays.fill(first_rc, 1);
	    }
	    
	 // 0열 0행 값 마지막날까지 업데이트
	 
	    for(int i=0;i<n;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	int n_0=Integer.parseInt(st.nextToken());
	    	int n_1=Integer.parseInt(st.nextToken());
	    	int n_2=Integer.parseInt(st.nextToken());
            
            for(int j=n_0;j<n_0+n_1;j++){
            	//1증가한 위치에 1 더함
                first_rc[j]++;
            }
            for(int j=n_0+n_1;j<n_0+n_1+n_2;j++){
            	//2증가한 위치에 2더함 
                first_rc[j]+=2;
            }
	    
	    }
        
        
	    
	    for(int i=0;i<m;i++) {
	    	for(int j=0;j<m;j++) {
	    		//첫번째 행일경우  또는 첫번째 열이 아닐 경우 
	    		if(i==0||j!=0)
	    			//가로를 차례로 출력 (열 값)
	    			bw.write(first_rc[m-1+j]+" ");
                else{
                	//나머지 행의 첫번째 열 일경우
                    bw.write(first_rc[m-1-i]+" ");
                }
	    	}
	    	bw.write("\n");
	    }
        bw.flush();

	}
}