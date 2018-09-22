import java.util.Scanner;

public class euclid_convoluted {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			
			double checkbreak = 0;
			
			double ax = sc.nextDouble();
			double ay = sc.nextDouble();
			double bx = sc.nextDouble();
			double by = sc.nextDouble();
			double cx = sc.nextDouble();
			double cy = sc.nextDouble();
			double dx = sc.nextDouble();
			double dy = sc.nextDouble();
			double ex = sc.nextDouble();
			double ey = sc.nextDouble();
			double fx = sc.nextDouble();
			double fy = sc.nextDouble();
			
			checkbreak = ax+ay+bx+by+cx+cy+dx+dy+ex+ey+fx+fy;
			
			if (checkbreak < 1e-9) {
				break;
			}
			
			double triangle = dx*ey - ex*dy + ex*fy - fx*ey + fx*dy - dx*fy;
//			double triangle = dx*fy - fx*dy + fx*ey - ex*fy + ex*dy - dx*ey;
			triangle/=2;
			
			triangle = Math.abs(triangle);
			
			System.out.println("tri area = " + triangle);
			
			double magab = distance(ax,ay,bx,by);
			
			System.out.println("mag a b = " + magab);
			
			double need = triangle/magab;
			System.out.println("need = " + need);
			
			double hx=0,hy=0,gx=0,gy=0;
			
			double cos = costheta(distance(ax,ay,cx,cy),distance(cx,cy,bx,by),distance(ax,ay,bx,by));
			
			System.out.println("cos = " + cos);
			
			System.out.println("cos*need = " + (cos*need) + " sqrt(need^2+cos^2)" + (Math.sqrt(need*need+cos*cos)));
			System.out.println("cos/need = " + (cos/need) + " " + (need/cos));
			hx = ax+(cos*need);
			hy = ay + Math.sqrt(need*need+cos*cos);
			
			gx = bx + cos*need;
			gy = by + Math.sqrt(need*need+cos*cos);

			System.out.printf("%f %f %f %f\n", gx,gy,hx,hy);
		}
	}
	
	static double costheta(double r1, double r2, double d) {
		return (r1*r1 + d*d -r2*r2)/(2*r1*d);
	}
	
	static double theta(double r1, double r2, double d) {
		return Math.acos((r1*r1 + d*d -r2*r2)/(2*r1*d));
	}
	
	static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
	}

}

/*
0 0 5 0 0 5 3 2 7 2 0 4
1.3 2.6 12.1 4.5 8.1 13.7 2.2 0.1 9.8 6.6 1.9 6.7
0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0

0 0 5 0 0 5 0 0 1 1 2 0
0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0
*/