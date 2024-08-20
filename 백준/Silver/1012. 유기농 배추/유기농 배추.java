import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static boolean [][] arrV; 
	static boolean [][] arrived; 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			arrV = new boolean[M][N];
			arrived = new boolean[M][N];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arrV[x][y]=true;
			}
			
			int count=0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(arrV[i][j]&&bfs(i,j,N,M)) count++;
				}
			}
			
			
			System.out.println(count);
		}
	}
		
	static Queue<int[]> queue;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static boolean bfs(int r, int c, int N, int M) {
		if(arrived[r][c]) {
			return false;
		}else {
			arrived[r][c]=true;
			queue = new LinkedList<int[]>();
			queue.offer(new int[] { r, c });
			
			while (!queue.isEmpty()) {
				int [] current = queue.poll();
	            int cr = current[0];
	            int cc = current[1];
	            
	            for (int d = 0; d < 4; d++) {
	                int nr = cr + dr[d];
	                int nc = cc + dc[d];
	            
	            if (0 <= nr && nr < M && 0 <= nc && nc < N && !arrived[nr][nc] && arrV[nr][nc]) {
                    queue.offer(new int[] {nr, nc});
                    arrived[nr][nc] = true;
                	}
	            }
			}
			return true;
		}
	}
}
	