import java.util.Scanner;

public class jump {

	static boolean[] used;
	static int[] perm, items;
	
	static int num;
	static int maxup, maxdown;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for (int oo =0 ; oo < n; oo++) {
			int blocks =sc.nextInt();
			
			items = new int[blocks];
			num =0 ;
			perm = new int[blocks];
			used = new boolean[blocks];
			
			for (int i =0 ; i < blocks; i++) {
				items[i] = sc.nextInt();
			}
			
			maxup = sc.nextInt();
			maxdown = sc.nextInt();
			
			perm(0);
			
			System.out.println(num);
		}
	}
	
	static void perm(int i) {
		if (i >= used.length) {
			//compute
			
			boolean good = true;
			
			for (int j =0 ; j < used.length-1; j++) {
				int diff = perm[j]-perm[j+1];
				
				if (diff < 0) {
					if (Math.abs(diff) > maxdown) {
						good = false;
						break;
					}
				}else if (diff > 0){
					if (diff > maxup) {
						good = false;
						break;
					}
				}
			}
			
			if (good) {
				num++;
			}
			
		}else {
			for (int j =0 ; j < used.length; j++) {
				if (!used[j]) {
					used[j] = true;
					perm[i] = items[j];
					perm(i+1);
					used[j] = false;
				}
			}
		}
	}

}
