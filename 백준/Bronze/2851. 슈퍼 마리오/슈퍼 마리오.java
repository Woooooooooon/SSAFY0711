import java.util.Iterator;
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum=0;
		int temp=0;
		int num;
		for (int i = 0; i < 10; i++) {
			num = sc.nextInt();
			if(Math.abs(100-sum)>=Math.abs(100-(sum+num))){
			sum+=num;
			}else {
				break;
			}
		}
		System.out.println(sum);
	}

}
