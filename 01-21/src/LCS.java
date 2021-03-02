import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LCS {

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
	    String str1=br.readLine();
	    String str2=br.readLine();
	    
	    int[][] lcs=new int[str1.length()+1][str2.length()+1];
	    
	    for(int i=0;i<str1.length();i++) {
	    	for(int j=0;j<str2.length();j++) {
	    		if(str1.charAt(i)==str2.charAt(j))
	    			lcs[i+1][j+1]=lcs[i][j]+1;
	    		else
	    			lcs[i+1][j+1]=Math.max(lcs[i][j+1],lcs[i+1][j] );
	    	}
	    }
	    
	    bw.write(lcs[str1.length()][str2.length()]+"");
	    bw.flush();
	    bw.close();
	    br.close();
	    
	}

}
