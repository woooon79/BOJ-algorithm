import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class ปýลยวะ_4358 {
	 public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            TreeMap<String,Integer> map=new TreeMap<>();
            
          
            
		    String line;
		    int total=0;
		    StringBuffer sb=new StringBuffer();
		    
		   while((line=br.readLine())!=null){
			   if(map.get(line)==null)
				   map.put(line,1);
			   else
			   {   int tmp=map.get(line);
			       map.put(line,tmp+1);
			   }
			   total++;
   
		   }
		   
		   
		   Iterator<String> keys=map.keySet().iterator();
		   while(keys.hasNext()) {
			   String name=keys.next();
			   double p=(double)(map.get(name)*100)/total;
			   //System.out.println(name+" "+String.format("%.4f", p));
			  sb.append(name+" "+String.format("%.4f", p)+"\n");
			  // bw.write(name+" "+String.format("%.4f", p)+"\n");
		   }
		   
		 System.out.print(sb);
		   
	 }
}
