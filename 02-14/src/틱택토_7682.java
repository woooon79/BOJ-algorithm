import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class 틱택토_7682 {
    

    private static char[][] tc;
    private static char[] bingo= {'O','X'};
	
	public static int check(int i) {
		
		int chk=0;

        if(tc[0][0] == tc[0][1] && tc[0][1] == tc[0][2]) {
            if(tc[0][0]==bingo[1-i]) {
               return -1;
            }
            

            else if(tc[0][0]==bingo[i]) chk++;
        }

        if(tc[1][0] == tc[1][1] && tc[1][1] == tc[1][2]) {
        	if(tc[1][0]==bingo[1-i]) {
        		return -1;
             }
             

             else if(tc[1][0]==bingo[i]) chk++;
        }

        if(tc[2][0] == tc[2][1] && tc[2][1] == tc[2][2]) {
        	if(tc[2][0]==bingo[1-i]) {
        		return -1;
             }
             

             else if(tc[2][0]==bingo[i]) chk++;
        }

        if(tc[0][0] == tc[1][0] && tc[1][0] == tc[2][0]) {
        	if(tc[0][0]==bingo[1-i]) {
        		return -1;
             }
             

             else if(tc[0][0]==bingo[i]) chk++;
        }

        if(tc[0][1] == tc[1][1] && tc[1][1] == tc[2][1]) {
        	if(tc[0][1]==bingo[1-i]) {
        		return -1;
             }
             

             else if(tc[0][1]==bingo[i]) chk++;
        }

        if(tc[0][2] == tc[1][2] && tc[1][2] == tc[2][2]) {
        	if(tc[0][2]==bingo[1-i]) {
        		return -1;
             }
             

             else if(tc[0][2]==bingo[i]) chk++;
        }

        if(tc[0][0] == tc[1][1] && tc[1][1] == tc[2][2]) {
        	if(tc[0][0]==bingo[1-i]) {
        		return -1;
             }
             

             else if(tc[0][0]==bingo[i]) chk++;
        }

        if(tc[0][2] == tc[1][1] && tc[1][1] == tc[2][0]) {
        	if(tc[0][2]==bingo[1-i]) {
        		return -1;
             }
             

             else if(tc[0][2]==bingo[i]) chk++;
        }

 	   return chk;
 	
	
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    String line;
	 while(!(line=br.readLine()).contentEquals("end")) {
		 tc=new char[3][3];
		 int x_cnt=0;
		 int o_cnt=0;

		 
		 for(int i=0;i<9;i++) {
			 char c=line.charAt(i);
			 tc[i/3][i%3]=c;
			 if(c=='O') {
				 o_cnt++;
			 }
			 else if(c=='X') {
				 x_cnt++;
			 }
 
		 }
		     
		 if(Math.abs(o_cnt-x_cnt)>1||(o_cnt>x_cnt)) {
			 System.out.println("invalid");
			 continue;
		 }
		 
		 
		 //o가 성공한 후 끝나는 경우
		 else if(x_cnt==o_cnt) {
	    	if(x_cnt<3) {
	    		System.out.println("invalid");
				 continue;
	    	}
	    	 if(check(0)>0){
		    		System.out.println("valid");
					 continue;
		    	}
	    		
	    	 else {
			    		System.out.println("invalid");
						 continue;
	    	 }
	    		
	    		
	     }
	     //x이기는 경우 또는 다 채운경우
	     else {
	    	 if(x_cnt<3) {
		    		System.out.println("invalid");
					 continue;
		    	}
	    	 //o가 성공한경우
		    	 if(check(1)<0){
			    		System.out.println("invalid");
						 continue;
			    	}
		    //x가 성공하였을경우 또는 꽉찻을때
		    	 else if(check(1)>0||(x_cnt==5&&o_cnt==4)) {
				    		System.out.println("valid");
							 continue;
		    	 }
		    	 else {
		    		 System.out.println("invalid");
					 continue;
		    	 }
		    	
	    	 
	    	 
	     }
	     
	     
	     
		 
	 }

	}
}
