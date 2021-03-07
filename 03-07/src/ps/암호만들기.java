package ps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ��ȣ����� {
    static int l,c;
    //��밡���� ���ĺ� �迭, ���� �ε���, ���� �ܾ�, ��������, ��������
    static void count(char[] arr,int idx,String word,int v,int con) {
 
    	//���� �ܾ� ���̰� l�̶��
    	if(word.length()>=l) {
    		//������ 1�� �̻�, ������ 2�� �̻��̸� ���
    	  	if(v>0&&con>1)
        		System.out.println(word);
    		return;
    	}
    	
    
    	for(int i=idx;i<c;i++) {
        	
	    	char next=arr[i];
	    	
	    	//���� �ܾ next ����
	    	String tmp=word+Character.toString(next);

	    	//next�� �����̶��
	    	if(next=='a'||next=='e'||next=='i'||next=='o'||next=='u') 
	    		//�������� +1 
	    		count(arr,i+1,tmp,v+1,con);
	    	
	    	else
	    		//��������+1
	    		count(arr,i+1,tmp,v,con+1);

	    }
    
  
	    
    }
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    

	    StringTokenizer st=new StringTokenizer(br.readLine());
	    //c���� ���ĺ� ������
	    //l ������ ���� ���ڿ� ���
	    l=Integer.parseInt(st.nextToken());
	    c=Integer.parseInt(st.nextToken());
	    
	    char[] arr=new char[c];

	  	st=new StringTokenizer(br.readLine());
	    for(int i=0;i<c;i++) {
	    	arr[i]=st.nextToken().charAt(0);
	    }
	    
	    //���ĺ������� ����
	    Arrays.parallelSort(arr);

	    	count(arr,0,"",0,0);
	    
	    
	}
}
