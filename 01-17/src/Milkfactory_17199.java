import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

public class Milkfactory_17199 {
	static BufferedReader br;
	static BufferedWriter bw;
    static boolean[][] arr;
    static int num;
    
    //����Լ�
    //���� ���޹��� �����̼��� ����� �����̼��� �ٸ� �����̼ǰ� ����Ǿ��� ��츦 �ݺ����� ���� Ž���Ͽ� ���ᰪ ����
	public static void run(int i,int j) {
		for(int a=1;a<num+1;a++) {
			if(j!=a&&arr[j][a]&&!arr[i][a]) {
				arr[i][a]=true;
				run(i,a);
			}
				
		}
	}
    public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
    	 bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	br =new BufferedReader(new InputStreamReader(System.in));
	    num=Integer.parseInt(br.readLine());

	    arr=new boolean[num+1][num+1];
	    for(int i=0;i<num-1;i++) {
		    StringTokenizer st=new StringTokenizer(br.readLine());
	    	int n1=Integer.parseInt(st.nextToken());
	    	int n2=Integer.parseInt(st.nextToken());
	    	
	    	arr[n1][n2]=true; 
	    	
	    }
	    
	    //�迭�� 1���� ����
	    for(int i=1;i<num+1;i++) {
	    	for(int j=1;j<num+1;j++) {
               //���� ����Ǿ� ������ 
	    	   //run �Լ� ȣ���� ���� �˻��� ���ᰪ ����
	    		if(arr[i][j]) {
	    			run(i,j);
	    		}
	    		//���� ���� ������ true ����
		    	if(i==j)
		    	  arr[i][j]=true;
	    	}
	    }
	    
	   int result=-1;
	   
	   //���� �����̼��� �� ��� �����̼ǿ� ����Ǿ��ִ� ��� �� ã��
	   //=>��Ŀ��� column���� �� true �� ���
	   //�ּҰ��� ã�°��̹Ƿ� �տ������� ã�´�
	    for(int j=1;j<=num;j++) {
	    	 boolean temp=true;
	    	for(int i=1;i<=num;i++) {
	    		if(!arr[i][j]) {
	    			temp=false;
	    			break;
	    		}
	    			
	    	}
	    	if(temp) {
	    		result=j;
	    		break;
	    	}
	    		
	    }
	    
	    System.out.println(result);
	    
	    
    }
}
