import java.awt.geom.Line2D;
import java.util.Scanner;

public class birdman {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cases = sc.nextInt();
		
		for (int i =0 ; i < cases; i++) {
			int bx = sc.nextInt();
			int by = sc.nextInt();
			
			int sx = sc.nextInt();
			int sy = sc.nextInt();
			
			int p1x = sc.nextInt();
			int p1y = sc.nextInt();
			int p2x = sc.nextInt();
			int p2y = sc.nextInt();
			
			if (Line2D.linesIntersect(bx, by, sx, sy, p1x, p1y, p2x, p2y)) {
				System.out.println("Move to the left or right!");
			}else {
				System.out.println("Good picture, Birdman!");
			}
		}
	}

}
