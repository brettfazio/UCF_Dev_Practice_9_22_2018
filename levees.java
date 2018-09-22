import java.util.Arrays;
import java.util.Scanner;

public class levees {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			
			double x1 = sc.nextDouble();
			double y1 = sc.nextDouble();
			double x2 = sc.nextDouble();
			double y2 = sc.nextDouble();
			double x3 = sc.nextDouble();
			double y3 = sc.nextDouble();
			double x4 = sc.nextDouble();
			double y4 = sc.nextDouble();
			
			if (x1 == 0 && y1 == 0 &&
					x2 == 0 && y2 == 0 &&
					x3 == 0 && y3 == 0 &&
					x4 == 0 && y4 == 0) {
				break;
			}
			
			Vector v13 = new Vector(x1,y1,x3,y3);
//			Vector v42 = new Vector(x4,y4,x2,y2);
			Vector v24 = new Vector(x2,y2,x4,y4);
//			System.out.println("v13 = " + v13);
//			System.out.println("v24 = " + v24);
			Pair center = v13.intersection(v24);
//			System.out.println("center = " + center.x + " " + center.y);
			Thing[] things = new Thing[4];
			things[0] = new Thing(x1,y1,x2,y2,center.x,center.y);
			things[1] = new Thing(x2,y2,x3,y3,center.x,center.y);
			things[2] = new Thing(x3,y3,x4,y4,center.x,center.y);
			things[3] = new Thing(x4,y4,x1,y1,center.x,center.y);
			
			Arrays.sort(things);
			
			for (int i =0 ; i < things.length; i++) {
//				System.out.printf(things[i].area + " " + things[i].per);
				System.out.printf("%.3f %.3f%s", things[i].area, things[i].per, i == things.length-1 ? "" : " ");
			}
			System.out.println();
			
		}
	}

}

class Vector {
	double a,b;
	double c,d;
	double beta;
	
	public Vector(double x1, double y1, double x2, double y2) {
		a = x1;
		b = y1;
		c = x2-x1;
		d = y2-y1;
	}
	
	public Pair intersection(Vector o) {
		Pair ret = new Pair(0,0);
		
		//x
		double xconst = o.a - a;
		double xmybeta = c;
		double xobeta = -1*o.c;
//		System.out.println("xmyb xob = xconst " + xmybeta + " " + xobeta + " = " + xconst);
		//y
		double yconst = o.b - b;
		double ymybeta = d;
		double yobeta = -1*o.d;
//		System.out.println(ymybeta + " " + yobeta + " =  "  + yconst);
		double top = xconst * yobeta - yconst * xobeta;
//		System.out.println("top = " + xconst +" * " + yobeta + " - " + yconst + " " + xobeta);
		double bot = xmybeta * yobeta - xobeta * ymybeta;
//		System.out.println("bot = " + xmybeta + " * " + yobeta + " - " + xobeta +" * " + ymybeta);
//		System.out.println(top + " / " + bot);
		double div = top / bot;

		ret = new Pair(a + (div*c), b + (div*d));
		
		return ret;
	}
	
	public String toString() {
		return "Vector (a b c d) = " + a + " " + b + " " + c + " " + d;
	}
}

/*

1 2 1 5 5 2 2 0
3.5 2.2 4.8 -9.6 -1.2 -4.4 -8.9 12.4
0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0

1 2 1 5 5 2 2 0
0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0

0 0 0 1 1 1 1 0
0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0
 */

class Pair {
	double x, y;
	
	public Pair(double x, double y) {
		this.x = x;
		this.y = y;
	}
}

class Thing implements Comparable<Thing>{

	double area, per;
	
	public Thing(double x1, double y1, double x2, double y2, double x3, double y3) {
		area = x1*y2 - x2*y1 + x2*y3 - x3*y2 + x3*y1 - x1*y3;
		area /= 2;
		area = Math.abs(area);
		per = distance(x1,y1,x2,y2) + distance(x2,y2,x3,y3) + distance(x3,y3,x1,y1);
	}
	
	@Override
	public int compareTo(Thing o) {
		
		if (Math.abs(o.area-area) > 1e-3) {
			return Double.compare(o.area, area);
		}
		
		return Double.compare(o.per, per);
	}
	
	public double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
	}
	
}