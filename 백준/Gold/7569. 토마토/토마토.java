import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static int M;
	static int N;
	static int H;
	static int map [][][];
	static int year;
	static int[] dz = {1,-1,0,0,0,0};
	static int[] dc = {0,0,1,-1,0,0};
	static int[] dr = {0,0,0,0,1,-1};
	static int unriped;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N= Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int [H][N][M];
		unriped =0;
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					map[i][j][k]= Integer.parseInt(st.nextToken());
					if(map[i][j][k]==0) {
						unriped++;
					}
				}
			}
		}
		if (unriped==0) {
			System.out.println(0);
		}else {
			year =0;
			bfs();
			System.out.println(year);			
		}

		
	}
	
	static LinkedList<int[]> queue;
	static void bfs() {
		int maxYear =0;
		queue = new LinkedList<>();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if(map[i][j][k]==1) {
						queue.offer(new int[] {i,j,k,year});
					}
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int[] pick = queue.pop();
			int pz = pick[0];
			int pc = pick[1];
			int pr = pick[2];
			int pYear = pick[3]+1;
			for (int i = 0; i < 6; i++) {
				int nz = pz +dz[i];
				int nc = pc +dc[i];
				int nr = pr +dr[i];
				if(nz>=0&&nz<H&&nc>=0&&nc<N&&nr>=0&&nr<M&& map[nz][nc][nr]==0) {
					map[nz][nc][nr]=1;
					maxYear = Math.max(pYear, maxYear);
					queue.offer(new int[] {nz,nc,nr,pYear});
				}
			}
		}
		
		for (int i = 0; i < H; i++) {//다 끝나고도 안익은 것이 있을 때
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if(map[i][j][k]==0) {
						year = -1;
						return;
					}
				}
			}
		}
		year = maxYear;
		return;
	}
}
