import java.util.Arrays;
import java.util.Scanner;

public class jacuzzi {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int cases = sc.nextInt();
		
		for (int i =0; i < cases; i++) {
			int sides = sc.nextInt();
			
			int[] s =new int[sides];
			
			for (int j =0; j < sides; j++) {
				s[j] = sc.nextInt();
			}
			Arrays.sort(s);
			
			long sum = 0;
			for (int j =0; j < sides-1;j ++) {
				sum+=s[j];
			}
			System.out.print("Jacuzzi #" + (i+1) + ": ");
			if (sum > s[sides-1]) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}

}
