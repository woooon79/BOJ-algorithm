import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
class Student{
	int g;
	int s;
	
	Student(int g,int s){
		this.s=s;
		this.g=g;
	}
	
}
public class 스위치켜고끄기 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    int snum=Integer.parseInt(br.readLine());
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    int[] arr=new int[snum+1];
	    for(int i=1;i<snum+1;i++) {
	    	arr[i]=Integer.parseInt(st.nextToken());
	    }
	    
	    int stnum=Integer.parseInt(br.readLine());
	    Student[] starr=new Student[stnum];
	    for(int i=0;i<stnum;i++) {
	    st=new StringTokenizer(br.readLine());
	   
	    int g=Integer.parseInt(st.nextToken());
	    int s=Integer.parseInt(st.nextToken());
	    //System.out.println(g+" "+s);
	    starr[i]=new Student(g,s);
	    }
	  
	    
	    for(int i=0;i<stnum;i++) {
	    	int gender=starr[i].g;
	    	int number=starr[i].s;
	    	
	    
	    	
	    	//남자
	    	if(gender==1) {
	    		while(number<snum+1) {
	    			arr[number]=1-arr[number];
	    			number+=starr[i].s;
	    		}
	    	}
	    	//여자
	    	else {
	    		arr[number]=1-arr[number];
	    		int k=1;
	    		while(number+k<snum+1&&number-k>=1) {
	    			if(arr[number+k]==arr[number-k]) {
	    				arr[number+k]=1-arr[number+k];
	    				arr[number-k]=1-arr[number-k];
	    			}
	    			else
	    				break;
	    			k++;
	    		}
	    	}
	
	    	
	    }
		
	    StringBuilder sb=new StringBuilder();
	    for(int i=1;i<snum+1;i++) {
	    	sb.append(arr[i]+" ");
	    	if(i%20==0)
	    		sb.append("\n");
	    }
	    System.out.println(sb); 
	    
	    
	}

}
