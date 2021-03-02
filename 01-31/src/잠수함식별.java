import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;

public class 잠수함식별 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	  int[] arr=Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
	   
	  int i=0;
	
	  while(i<arr.length) {
		  if(arr[i]==0) {
			  i++;
			  if(arr[i]!=1) {
				  //System.out.println('a');
				  System.out.println("NOISE");
				  return;
			  }
		  }
		  else {
			  i=i+2;
			  if(i>=arr.length||arr[i]!=0||arr[i-1]!=0) {
				  //System.out.println('b');
				  System.out.println("NOISE");
				  return;
			  }
			  while(true) {
				  i++;
				  if(i>=arr.length) {
					  //System.out.println('c');
					  System.out.println("NOISE");
					  return;
				  }
					  
				  if(arr[i]==1)
					  break;
			  }
			  while(true) {
				  
				  if(i>=arr.length) {
					  break;
				  }
				  if(arr[i]==0) {
					  //System.out.println('d');
					  System.out.println("NOISE");
					  return;
				  }
				  
				  if(i+2<arr.length) {
					  
				  if(arr[i+1]==0&&arr[i+2]==1)
					  break;
				  if(arr[i-1]!=0&&arr[i+1]==0&&arr[i+2]==0) {
					  i--;
					  break;
				  }
				  }
				  
				  i++;
				  
			  }
			  
				  
		  }
			  i++;
	  }
	  
	  System.out.println("SUBMARINE");
	  
	}
}
