import java.util.Scanner;

public class Main{

	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int i=0;
		int cnt=1;
		if(N!=1) {
			while(N>1) {
				i++;
				cnt++;
				N-=i*6;
			}			
		}
		System.out.println(cnt);
	}

}
