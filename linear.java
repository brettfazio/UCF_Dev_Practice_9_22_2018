import java.util.Scanner;

public class linear {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cases =sc.nextInt();
		
		for (int i =0 ; i < cases; i++) {
			long a = sc.nextInt();
			long b= sc.nextInt();
			long l = sc.nextInt();
			long h = sc.nextInt();
			
			int cnt = 0;
			double thing = a;
//			thing /= b;
			double number = (h-l)/(thing);
			System.out.println(number);
			for (long j = l; j <= h; j++) {
				if ((1-a*j)%b==0) {
					cnt++;
				}
			}
			
			System.out.println(cnt);
		}
		
	}

}

/*

2
3 4 -10 5
17 6 0 50

*/