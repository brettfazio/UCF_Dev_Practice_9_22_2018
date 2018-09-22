import java.io.PrintWriter;
import java.util.Scanner;

public class search {

	static int[] dx = {1,0,-1,0,1,1,-1,-1};
	static int[] dy = {0,-1,0,1,-1,1,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int cases = 1;
		
		while (true) {
			
			int w = sc.nextInt();
			if (w == 0) break;
			sc.nextLine();
			String[] words = new String[w];
			
			for (int i =0 ; i < w; i++) {
				words[i] = sc.next();
			}
			
			int d = sc.nextInt();
			int a = sc.nextInt();
			sc.nextLine();
			char[][] grid = new char[d][a];
			
			for (int i =0 ; i < d; i++) {
				grid[i] = sc.next().toCharArray();
			}
			
			int notgot =0 ;
			
			out.println("Puzzle number "+cases+":");
			
			for (int word =0 ; word < w; word++) {
				boolean got = false;
				outer : for (int dd =0 ;dd <d; dd++) {
					for (int aa =0; aa < a; aa++) {
						
						for (int t =0 ; t < dx.length; t++) {
							int nd = dd;
							int na = aa;
							for (int i =0 ; i < words[word].length(); i++) {
								if (grid[nd][na] == words[word].charAt(i)) {
									//good
									if (i == words[word].length()-1) {
										got = true;
										break outer;
									}
								}else {
									break;
								}
								
								nd += dx[t];
								na += dy[t];
								
								if (nd >= d || nd < 0 || na >= a || na < 0) {
									break;
								}
							}
							
						}
						
					}
				}
				
				if (!got) {
					out.println(words[word]);
					notgot++;
				}
				
			}
			
			if (notgot == 0) {
				out.println("ALL WORDS FOUND");
			}
			out.println();
			
			cases++;
		}
		out.close();
	}

}
