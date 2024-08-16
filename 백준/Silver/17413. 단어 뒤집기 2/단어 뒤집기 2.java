import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static char c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sen = br.readLine();
		StringTokenizer st = new StringTokenizer(sen,"< >", true);
		
		ArrayList<String> arr = new ArrayList<>();		
		while(st.hasMoreTokens()) {
			arr.add(st.nextToken());
		}
		
		for (int i = 0; i < arr.size(); i++) {
			if(arr.get(i).equals("<")) {
				System.out.print(arr.get(i));
				while(!(arr.get(i).equals(">"))) {
					System.out.print(arr.get(++i));
				}
			}else if(arr.get(i).equals(" ")) {
				System.out.print(arr.get(i));
			}else {
				System.out.print(reverse(arr.get(i)));
			}
	
		}
			
	}
	
	static String reverse(String word) {
		String reverseWord ="";
		for (int i = word.length()-1; i >= 0; i--) {
			reverseWord +=word.charAt(i);
		}
		
		return reverseWord;
		
	}	
		
		
	
}
