package ps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ���������޾���2 {
	static int n;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    

	    n=Integer.parseInt(br.readLine());
	    
	    char[] map=new char[n];
	    map=br.readLine().toCharArray();
	    
	    
	    char before=map[0];
	    int result;
	    
	    //WWW : ���� �ε�����
	    //EEE: �� �ε����� 
	    
	    //EW �̸� E�ڸ��� ���ƾ���
	    //WE �̸� W�ڸ��� ���ƾ���
	    
	    //������ W�̸� ������ �������� 
	    if(before=='E')
	    	result=0;
	    else
	    	result=1;
	   
	    
	    for(int i=1;i<n;i++) {
	    	char tmp=map[i];
	    	//���� ���ڿ� ���ٸ� ��� ����
	    	if(map[i]==before) {
	    		continue;
	    	}
	    	else {
	    		//���ڰ� �ٸ��ٸ�
	    		//EW �ΰ�� E�������� ���´�
	    		
	    		//WE �ΰ��� ������� �ʾƵ���.
	    		// EEEEWE => EW �ΰ����
	    		// WWWWWE => ó���� �ʱ�ȭ�Ҷ� �������
	    		
	    		if(before=='E') {
	    			result++;
	    		}
	    		
	    		before=tmp;
	    	}
	    		
	    }
	    
	    //E�� ���� ��� ������ E�ڸ��� ���ƾ��ϹǷ�
	    if(map[n-1]=='E')
	    	result++;
	    
	    System.out.println(result);
	    
	}
}
