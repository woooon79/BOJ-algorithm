package ps;

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
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class 이차원배열과연산 {
	static int r,c,k;

	//행 크기가 길어짐.행 개수는 그대로(r)
	public static int[][] r_cal(int[][] map,int row,int col) {
		//행 개수 만큼의 arraylist
		ArrayList<Integer>[] tmp_map=new ArrayList[row];
		for(int i=0;i<row;i++) {
			tmp_map[i]=new ArrayList<Integer>();
		}
		int[][] new_map;
		int max=0;
		
		for(int i=0;i<row;i++) {
			//행을 돌면서 새로운 배열로 업데이트
			//numbers 라는 맵
			//key에는 숫자
			//value에는 개수
			Map<Integer,Integer> numbers = new HashMap<>();
			for(int j=0;j<col;j++) {
				int key=map[i][j];
				//값이 0이면 무시
				if(key==0)
					continue;
				//numbers에 값있다면 value +1
				if(numbers.containsKey(key)) {
					numbers.put(key,numbers.get(key)+1);
				}
				else {
					//numbers에 값없다면 value는 1로 map 삽입
					numbers.put(key,1);
				}
			}
			
		
			List<Entry<Integer, Integer>> list_entries = new ArrayList<Entry<Integer, Integer>>(numbers.entrySet());
			// 비교함수 Comparator를 사용하여 오름차순으로 정렬
			Collections.sort(list_entries, new Comparator<Entry<Integer, Integer>>() {
				// compare로 값을 비교
				public int compare(Entry<Integer, Integer> obj1, Entry<Integer, Integer> obj2) {
					// 오름 차순 정렬
					//value 값이 같으면 키가 작은 값이 먼저오도록
					if(obj1.getValue()==obj2.getValue())
						return obj1.getKey()-obj2.getKey();
					else
						//value 값 작은게 먼저오도록
					    return obj1.getValue()-obj2.getValue();
				}
			});
			
			ArrayList arr=new ArrayList();
			int size=0;
			
			for(Entry<Integer, Integer> entry : list_entries) {
				//키는 숫자
				//value는 개수
				arr.add(entry.getKey()); 
				arr.add(entry.getValue());
				size=size+2;
			}

			//제일 긴 행의 길이
			if(size>max)
				max=size;
			
			tmp_map[i]=arr;
			
		}
		//최대 행 크기가 100이므로 max가 100보다 크면 100 값 바꿔줌
		if(max>100)
			max=100;
		//행크기=열개수 max로
		new_map=new int[row][max];
		
		for(int i=0;i<row;i++) {
			int mcol=tmp_map[i].size();
			//행크기가 100보다 크면 100으로 설정
			if(mcol>100)
				mcol=100;
			//해당 행의 크기만큼 값채우고
			for(int j=0;j<mcol;j++) {
				new_map[i][j]=tmp_map[i].get(j);
			}
			//남는 열은 0으로 채운다
			if(mcol<max) {
				for(int k=mcol;k<max;k++) {
					new_map[i][k]=0;
				}
			}
				
		}

		return new_map;
	}
	
	
	
	//열의 크기가 바뀜
	//열의 개수는 그대로(c)
	
	public static int[][] c_cal(int[][] map,int row,int col) {
		ArrayList<Integer>[] tmp_map=new ArrayList[col];
		for(int i=0;i<col;i++) {
			tmp_map[i]=new ArrayList<Integer>();
		}
		
		int[][] new_map;
		int max=0;
		
		for(int i=0;i<col;i++) {
			Map<Integer,Integer> numbers = new HashMap<>();
			for(int j=0;j<row;j++) {
				int key=map[j][i];
				if(key==0)
					continue;
				if(numbers.containsKey(key)) {
					numbers.put(key,numbers.get(key)+1);
				}
				else {
					numbers.put(key,1);
				}
			}
			
			//key에는 숫자
			//value에는 개수
			List<Entry<Integer, Integer>> list_entries = new ArrayList<Entry<Integer, Integer>>(numbers.entrySet());
			// 비교함수 Comparator를 사용하여 오름차순으로 정렬
			Collections.sort(list_entries, new Comparator<Entry<Integer, Integer>>() {
				// compare로 값을 비교
				public int compare(Entry<Integer, Integer> obj1, Entry<Integer, Integer> obj2) {
					// 오름 차순 정렬
					
					if(obj1.getValue()==obj2.getValue())
						return obj1.getKey()-obj2.getKey();
					else
					    return obj1.getValue()-obj2.getValue();
				}
			});
			
			ArrayList arr=new ArrayList();
			int size=0;
			
			for(Entry<Integer, Integer> entry : list_entries) {
				//키는 숫자
				//value는 개수
				arr.add(entry.getKey()); 
				arr.add(entry.getValue());
				size=size+2;
			}
			//제일 긴 열의 길이
			if(size>max)
				max=size;
			
			tmp_map[i]=arr;
			
		}
		if(max>100)
			max=100;
		
		new_map=new int[max][col];
		
		
		
		for(int i=0;i<col;i++) {
			int mrow=tmp_map[i].size();
			if(mrow>100)
				mrow=100;
			for(int j=0;j<mrow;j++) {
				new_map[j][i]=tmp_map[i].get(j);
			}
			if(mrow<max) {
				for(int k=mrow;k<max;k++) {
					new_map[k][i]=0;
				}
			}
		}
		

		return new_map;
	}
	
	
	
	public static int calculate(int[][] map) {
		int i=0;
	
		//100초동안 검사
		for(;i<=100;i++) {
			int row=map.length;
			int col=map[0].length;
			
			if(r-1<row&&c-1<col&&map[r-1][c-1]==k) {
				break;
			}

			
			if(row>=col) {
				map=r_cal(map,row,col);
			}
			else {
				map=c_cal(map,row,col);
			}
			
			
		}
		
		//100초가 넘으면 -1
		if(i>100)
			return -1;
		
		//이내라면 i리턴
		else
			return i;
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    

	    StringTokenizer st=new StringTokenizer(br.readLine());
	    r=Integer.parseInt(st.nextToken());
	    c=Integer.parseInt(st.nextToken());
	    k=Integer.parseInt(st.nextToken());
	    
	    int[][] map=new int[3][3];
	    
	    for(int i=0;i<3;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	for(int j=0;j<3;j++) {
	    		map[i][j]=Integer.parseInt(st.nextToken());
	    	}
	    }
	    
	    
	    System.out.println(calculate(map));
	    
	}
}
