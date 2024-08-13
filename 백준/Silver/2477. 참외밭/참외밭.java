import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main  {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//가로와 세로를 구분해서 받으면 좋을 것 같다.
		// 1,2 동쪽 서쪽
		// 3,4 남쪽 북쪽
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int K = Integer.parseInt(br.readLine());
		
		int r;
		int num;
		ArrayList<Integer> arrForR = new ArrayList<>();
		ArrayList<Integer> arrForNum = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			arrForR.add(r);
			num = Integer.parseInt(st.nextToken());
			arrForNum.add(num);				
		}
		
		for (int i = 0; i < 6; i++) {// 긴 배열 만들어 준다.
			arrForR.add(arrForR.get(i));
			arrForNum.add(arrForNum.get(i));
		}		
		
		int area=0;
		int small=0;
		for (int i = 0; i < 6; i++) {
			if(arrForR.get(i)==arrForR.get(i+2)&&arrForR.get(i+1)==arrForR.get(i+3)) {
				small = arrForNum.get(i+1)*arrForNum.get(i+2);
				area= arrForNum.get(i+4)*arrForNum.get(i+5);
				break;
			}
		}
		area=area-small;
		
		System.out.println(area*K);
	}

}

