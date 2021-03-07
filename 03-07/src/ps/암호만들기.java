package ps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호만들기 {
    static int l,c;
    //사용가능한 알파벳 배열, 현재 인덱스, 만든 단어, 모음개수, 자음개수
    static void count(char[] arr,int idx,String word,int v,int con) {
 
    	//현재 단어 길이가 l이라면
    	if(word.length()>=l) {
    		//모음이 1개 이상, 자음이 2개 이상이면 출력
    	  	if(v>0&&con>1)
        		System.out.println(word);
    		return;
    	}
    	
    
    	for(int i=idx;i<c;i++) {
        	
	    	char next=arr[i];
	    	
	    	//현재 단어에 next 붙임
	    	String tmp=word+Character.toString(next);

	    	//next가 모음이라면
	    	if(next=='a'||next=='e'||next=='i'||next=='o'||next=='u') 
	    		//모음개수 +1 
	    		count(arr,i+1,tmp,v+1,con);
	    	
	    	else
	    		//자음개수+1
	    		count(arr,i+1,tmp,v,con+1);

	    }
    
  
	    
    }
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    

	    StringTokenizer st=new StringTokenizer(br.readLine());
	    //c개의 알파벳 가지고
	    //l 길이의 정답 문자열 출력
	    l=Integer.parseInt(st.nextToken());
	    c=Integer.parseInt(st.nextToken());
	    
	    char[] arr=new char[c];

	  	st=new StringTokenizer(br.readLine());
	    for(int i=0;i<c;i++) {
	    	arr[i]=st.nextToken().charAt(0);
	    }
	    
	    //알파벳순으로 정렬
	    Arrays.parallelSort(arr);

	    	count(arr,0,"",0,0);
	    
	    
	}
}
