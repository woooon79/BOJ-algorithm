import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
class hello{
	int i,j;
	hello(int i,int j){
		this.i=i;
		this.j=j;
	}
	@Override
	public boolean equals(Object object) {
	    boolean sameSame = false;

	    if (object != null ){
	        sameSame = (this.i == ((Index)object).i);
	    }

	    return sameSame;
	}

}
public class ss {
	static void combination(int[] arr, Set visited, int start, int n, int r) {
        if (r == 0) {
            print(arr, visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited.add(i);
            combination(arr, visited, i + 1, n, r - 1);
            visited.remove(i);
        }
    }
	 static void print(int[] arr, Set visited, int n) {
	        for (int i = 0; i < n; i++) {
	        	 if(visited.contains(i))
	                System.out.print(arr[i] + " ");
	            
	        }
	        System.out.println();
	    }
	public static void main(String[] args) {
	/*
		// TODO Auto-generated method stub
		int n = 4;
        int[] arr = {1, 2, 3, 4};
        boolean[] visited = new boolean[n];
        Set s=new HashSet();
         System.out.println("\n" + n + " 개 중에서 " + 3+ " 개 뽑기");
            combination(arr, s, 0, n, 3);*/
		
boolean[][] k=new boolean[3][4];
System.out.println(k.length);//행
System.out.println(k[0].length);
	}

}
