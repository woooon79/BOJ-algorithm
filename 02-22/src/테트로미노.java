import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 테트로미노 {
	static int n,m;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//65+0=a

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    n=Integer.parseInt(st.nextToken());
	    m=Integer.parseInt(st.nextToken());
	    
	    int[][] map=new int[n][m];
	    for (int i=0; i<n; i++) {
	    	st=new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
	    
	    int result=0;
	    
	    for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
            	// ####
                if (j+3 < m) {
                    int tmp = map[i][j] + map[i][j+1] + map[i][j+2] + map[i][j+3];
                    if (result < tmp) result = tmp;
                }
                
               /* 
                #
                #
                #
                #
                */
                if (i+3 < n) {
                    int tmp = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+3][j];
                    if (result < tmp) result = tmp;
                }
                
                // #
                // ###;
                
                if (i+1 < n && j+2 < m) {
                    int tmp = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+1][j+2];
                    if (result < tmp) result = tmp;
                }
                
                // ##
                // #
                // #
                
                if (i+2 < n && j+1 < m) {
                    int tmp = map[i][j] + map[i][j+1] + map[i+1][j] + map[i+2][j];
                    if (result < tmp) result = tmp;
                }
                
                // ###
                //   #
                if (i+1 < n && j+2 < m) {
                    int temp = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+2];
                    if (result < temp) result = temp;
                }
                
                //#
                //#
               //##
                if (i+2 < n && j-1 >= 0) {
                    int temp = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+2][j-1];
                    if (result < temp) result = temp;
                }
                
                //  #
                //###
                if (i-1 >= 0 && j+2 < m) {
                    int temp = map[i][j] + map[i][j+1] + map[i][j+2] + map[i-1][j+2];
                    if (result < temp) result = temp;
                }
                
       
                //#
                //#
                //##
                if (i+2 < n && j+1 < m) {
                    int temp = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+2][j+1];
                    if (result < temp) result = temp;
                }
                
                //###
                //#
                
                if (i+1 < n && j+2 < m) {
                    int temp = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j];
                    if (result < temp) result = temp;
                }
                //##
                // #
                // #
                if (i+2 < n && j+1 < m) {
                    int temp = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+2][j+1];
                    if (result < temp) result = temp;
                }
                
                //##
                //##
                if (i+1 < n && j+1 < m) {
                    int temp = map[i][j] + map[i][j+1] + map[i+1][j] + map[i+1][j+1];
                    if (result < temp) result = temp;
                }
                
                
                // ##
                //##            
                if (i-1 >= 0 && j+2 < m) {
                    int temp = map[i][j] + map[i][j+1] + map[i-1][j+1] + map[i-1][j+2];
                    if (result < temp) result = temp;
                }
                //#
                //##
                // #
                if (i+2 < n && j+1 < m) {
                    int temp = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+2][j+1];
                    if (result < temp) result = temp;
                }
                
                //##
                // ##
                if (i+1 < n && j+2 < m) {
                    int temp = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+1][j+2];
                    if (result < temp) result = temp;
                }
                
                //#
               //##
               //#
                if (i+2 < n && j-1 >= 0) {
                    int temp = map[i][j] + map[i+1][j] + map[i+1][j-1] + map[i+2][j-1];
                    if (result < temp) result = temp;
                }
                
                // #
                //###
                if (j+2 < m&&i-1>=0) {
               
              
                        int temp = map[i][j] + map[i][j+1] + map[i][j+2] + map[i-1][j+1];
                        if (result < temp) result = temp;
                    
                 
                }   
                //###
                // #
                
                if (j+2 < m&&i+1 < n) {
                        int temp = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+1];
                        if (result < temp) result = temp;
                    }

                    if (i+2 < n&&j+1 < m) {
                        int temp = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+1][j+1];
                        if (result < temp) result = temp;
                    }
                    if (i+2 < n&&j-1 >= 0) {
                        int temp = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+1][j-1];
                        if (result < temp) result = temp;
                    }
                
            }
        }
        System.out.println(result);
	    
	    
	    
	}
}
