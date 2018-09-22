import java.util.Arrays;
import java.util.Scanner;

public class doubleland {

	static boolean[] used;
	static int[] items, perm;
	
	static int[] want;
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		
		int cases = sc.nextInt();
		
		for (int i =0; i < cases; i++) {
			int pcnt = sc.nextInt();
			
			items = new int[pcnt];
			perm = new int[pcnt];
			used = new boolean[pcnt];
			
			for (int j =0; j < pcnt; j++) {
				items[j] = sc.nextInt();
			}
			
			want = new int[sc.nextInt()];
			boolean[] need = new boolean[pcnt];
			for (int j = 0; j < want.length; j++) {
				want[j] = sc.nextInt();
				need[want[j]-1] = true;
			}
//			System.out.println(Arrays.toString(need));
			
			int totaleven =0 ;
			int totalgood = 0;
			
			for (int j =0 ; j < (1 << (pcnt)); j++) {
				
				int neededhave =0 ;
				int mine = 0;
				int other = 0;
				for (int k =0; k < pcnt; k++) {
					int res = j & (1 << k);
					if (res == 0) {
						//have
						mine += items[k];
						if (need[k]) {
							neededhave++;
						}
					}else {
						//brother
						other+=items[k];
					}
				}
				
				if (mine == other) {
					totaleven++;
				}
				if (mine == other && neededhave == want.length) {
					totalgood++;
				}
				
			}
			
			int g = gcd(totalgood,totaleven);
			totalgood /= g;
			totaleven /= g;
			
			System.out.println(totalgood +"/" + totaleven);
			
		}
	}
	
	static int gcd(int a, int b) {
		while (b>0) {
			int temp =b;
			b = a%b;
			a =temp;
		}
		return a;
	}
	
	static void perm(int i) {
		if (i >= used.length) {
			//compute
			
			
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
/*
1
20 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
1 1

3
4 8 10 6 4
1 3
7 1 2 3 4 5 6 7
2 3 7
10 15 15 15 10 10 5 8 8 13 1
2 1 10

*/
