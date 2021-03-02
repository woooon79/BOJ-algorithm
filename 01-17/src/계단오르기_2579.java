import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ��ܿ�����_2579 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	   int num=Integer.parseInt(br.readLine());
	   
	   int[] stairs=new int[301];
	   int[] dp=new int[301];
	   
	   for(int i=0;i<num;i++) {
		   stairs[i]=Integer.parseInt(br.readLine());
	   }
	   //ù��° ���
	   dp[0]=stairs[0];
	   //�ι�°��� / ù��°��� + �ι�° ��� ���ؼ� ū ��
	   dp[1]=Math.max(stairs[0]+stairs[1],stairs[1]);
	   //ù��°���+������ ��� / �ι�°���+����°��� ���ؼ� ū ��
	   dp[2]=Math.max(stairs[0]+stairs[2],stairs[1]+stairs[2]);
	   
	   for(int i=3;i<num;i++) {
		   //���� ���+������ / �����+������+�����������(���� �� ��� x) ��� ���ؼ� ū ��
		   dp[i]=Math.max(dp[i-2]+stairs[i], dp[i-3]+stairs[i-1]+stairs[i]);
		   
	   }
	   System.out.println(dp[num-1]);
	   //bw.write(dp[num-1]);
	   //bw.flush();
	   bw.close();
	   br.close();
	   
	}
}
