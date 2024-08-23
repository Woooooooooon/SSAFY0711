import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static int N;
	static int map [][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		for (int i = 0; i < N; i++) {
			char [] line = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if(line[j]=='.') {
					map[i][j]=0;
				}else {
					map[i][j]=line[j]-'0';
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]!=0) {
					System.out.print("*");
				}else {
					int num = count(i,j);
					if(num<10) System.out.print(num);
					else {
						System.out.print("M");
					}
				}
			}
			System.out.println();
		}
		
		
		
		
	}
	
	static int [] dr = {1,1,1,0,0,-1,-1,-1};//8방향 순회
	static int [] dc = {1,0,-1,1,-1,1,0,-1};
	
	
	static int count(int r, int c) {
		int cnt = 0;
		loop :
		for (int i = 0; i < 8; i++) {			
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr>=0&&nr<N&&nc>=0&&nc<N && map[nr][nc]!=0){
				cnt+=map[nr][nc];
				if(cnt>=10) { // 10 이상일 경우 더 계산할 필요 없이 종료
					break loop;
				}
			}
		}
		
		return cnt;
	}

}
