import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int tc = 0; tc < 4; tc++) {  // 4개의 테스트 케이스
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            
            char res;
            
            // d: 두 사각형이 전혀 겹치지 않는 경우
            if (c < e || g < a || d < f || h < b) {
                res = 'd';
            }
            // c: 두 사각형이 점에서 만나는 경우
            else if ((a == g && b == h) || (a == g && d == f) || (c == e && b == h) || (c == e && d == f)) {
                res = 'c';
            }
            // b: 두 사각형이 변에서 만나는 경우
            else if (a == g || b == h || c == e || d == f) {
                res = 'b';
            }
            // a: 두 사각형이 내부에서 겹치는 경우
            else {
                res = 'a';
            }
            
            System.out.println(res);
        }
    }
}
