import java.util.Scanner;

public class sequences {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int cases = sc.nextInt();
		
		for (int i = 0; i < cases; i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			int[][]s = new int[k+1][];
			
			for (int j = 0; j < k+1;j++) {
				s[j] = new int[n-j];
			}
			
			for (int j =0; j < n; j++) {
				s[0][j] =sc.nextInt();
			}
			
			for (int j = 1; j <= k; j++) {
				for (int h = 0; h < s[j].length; h++) {
					s[j][h] = s[j-1][h] + s[j-1][h+1];
				}
			}
			
			for (int j = 0; j < s[k].length; j++) {
				System.out.print(s[k][j]);
				if (j != s[k].length-1) {
					System.out.print(" ");
				}
			}
			System.out.println();
			
		}
	}

}
