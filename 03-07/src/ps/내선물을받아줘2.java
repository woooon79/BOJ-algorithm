package ps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 내선물을받아줘2 {
	static int n;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    

	    n=Integer.parseInt(br.readLine());
	    
	    char[] map=new char[n];
	    map=br.readLine().toCharArray();
	    
	    
	    char before=map[0];
	    int result;
	    
	    //WWW : 시작 인덱스에
	    //EEE: 끝 인덱스에 
	    
	    //EW 이면 E자리에 놓아야함
	    //WE 이면 W자리에 놓아야함
	    
	    //시작이 W이면 무조건 선물놓기 
	    if(before=='E')
	    	result=0;
	    else
	    	result=1;
	   
	    
	    for(int i=1;i<n;i++) {
	    	char tmp=map[i];
	    	//이전 문자와 같다면 계속 진행
	    	if(map[i]==before) {
	    		continue;
	    	}
	    	else {
	    		//문자가 다르다면
	    		//EW 인경우 E에선물을 놓는다
	    		
	    		//WE 인경우는 고려하지 않아도됨.
	    		// EEEEWE => EW 인경우임
	    		// WWWWWE => 처음에 초기화할때 고려했음
	    		
	    		if(before=='E') {
	    			result++;
	    		}
	    		
	    		before=tmp;
	    	}
	    		
	    }
	    
	    //E로 끝날 경우 선물을 E자리에 놓아야하므로
	    if(map[n-1]=='E')
	    	result++;
	    
	    System.out.println(result);
	    
	}
}
