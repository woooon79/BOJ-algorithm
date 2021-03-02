import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
class M implements Comparable<M>{
	int i;
	int mn;
	M(int i,int mn){
		this.i=i;
		this.mn=mn;
	}
	   @Override
	    public int compareTo(M o) {
	      return mn-o.mn;
	    }
}
public class 구간나누기_2228 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    int n=Integer.parseInt(st.nextToken());
	    int m=Integer.parseInt(st.nextToken());
	    
	    int[] arr=new int[n];
	    M[] except=new M[n];
	    
	    
	    int[] dp=new int[n];
	    
	    for(int i=0;i<n;i++) {
	    	int tmp=Integer.parseInt(br.readLine());
	    	arr[i]=tmp;
	    	except[i]=new M(i,tmp);
	    }
	    
	    //값이 작은 순서대로 오름차순 정렬 
	    Arrays.parallelSort(except);
	    Set <Integer> set=new HashSet<Integer>();
	    int last=-2;
	    int cnt=0;
	    for(int i=0;i<n;i++) {
	    	
	    	if(cnt==m-1)
	    		break;
	    	if(except[i].i!=0&&except[i].i!=n-1&&except[i].i!=last+1) {
	    		//System.out.println(except[i].i);
	    		set.add(except[i].i);
	    		last=except[i].i;
	    		cnt++;
	    	}
	    	
	    	
	    }
	    
	 dp[0]=arr[0];
	 int result=0;
	 
	    for(int i=1;i<n;i++) {
	    	
	    	if(set.contains(i)) {
	    		result+=dp[i-1];
	    		dp[i+1]=arr[i+1];
	    		i++;
	    	}
	    		
	    	else {
	        if(dp[i-1]+arr[i]>dp[i-1]) {
	    		dp[i]=Math.max(dp[i-1]+arr[i], arr[i]);
	    	}
	    	else
	    		dp[i]=dp[i-1];
	    	}
	    }
	    
	    result+=dp[n-1];
	    
	    System.out.println(result);
	    
	    
	    
	    
	    
	}
}
