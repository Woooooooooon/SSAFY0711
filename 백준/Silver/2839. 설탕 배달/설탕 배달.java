import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//5키로그램 봉지 최대한 많이 담아야함
		int N = sc.nextInt();
		int n = 0;//설탕봉지 개수
		while(N%5!=0) {
			N-=3;
			n++;
			if(N<0) {
				n=-1;
				N=0;
			}
		}
		n+=N/5;
		System.out.println(n);	
	}
}
