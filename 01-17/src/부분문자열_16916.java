import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
//KMP

public class 부분문자열_16916 {
	static BufferedReader br;
	static BufferedWriter bw;
	
	//접두사와 접미사 일치하는 최대 길이 찾기

	static int[] fail(String str) {
		int[] pi=new int[str.length()];
		int j=0;
		for(int i=1;i<str.length();i++) {
			while(j>0 && str.charAt(i)!=str.charAt(j)) {
				j = pi[j-1];
			}		
			if(str.charAt(i)==str.charAt(j)) 
				pi[i] = ++j;
			
		}
		
		return pi;
		
	}
	static int KMP(String str,String p_str){
		int[] pi=fail(p_str);
		int j=0;
		int result=0;
		
		for(int i=0;i<str.length();i++) {
			while(j>0 && str.charAt(i)!=p_str.charAt(j)) {
				j=pi[j-1];
			}
			if(str.charAt(i)==p_str.charAt(j)) {
				if(j==p_str.length()-1) {
					result=1;
					break;
				}
				else
					j++;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br =new BufferedReader(new InputStreamReader(System.in));
	    bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    String str=br.readLine();
	    String p_str=br.readLine();
	    
	    System.out.println(KMP(str,p_str));
	}
}
