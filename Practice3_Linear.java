import java.io.*;
import java.util.*;

public class Practice3_Linear {

	public static void main(String[] args) {
		//Read up on the Extended Euclidean Algorithm:
		//https://en.wikipedia.org/wiki/Extended_Euclidean_algorithm
		//This is a pretty straight-forward application of it I think.
		
		//Uncomment this to see how the coefficients change for a solution.
//		int A = 3, B = 4;
//		for(int x = -20; x <= 10; x++) {
//			int ret = 1 - A*x;
//			if(ret % B == 0) {
//				System.out.printf("(%d, %d)\n", x, ret/B);
//			}
//		}

		Scanner s = new Scanner(System.in);
		int numTests = s.nextInt();
		for(int test = 0; test < numTests; test++) {
			
			long a = s.nextLong();
			long b = s.nextLong();
			long L = s.nextLong(), H = s.nextLong();
			long res = 0;
			long[] eEuclid = eEuclid(a, b);
			System.out.println(Arrays.toString(eEuclid));
			//We know the simplest solution to
			// a*x + b*y = 1 (it's the last 2 elements in the array).
			//We need to know how to change these coefficients so that
			// they still sum to 1. Eventually you should see that
			// x will increase/decrease by B and y will increase/decrease
			// by A. If x is increasing, y is decreasing and vice-versa.
			
			//So to solve the problem, we should find the lowest x value
			// greater than L. Then we can also find the largest x value less
			// than H.
			//Notice that the value for y can be anything so we don't need
			// to do any extra math which is nice or even find the y values.
			
			
			//If the shiftBy value doesn't already make sense, then try
			// and do some math on paper and hopefully it eventually makes sense.
			long shiftBy;
			long diff = eEuclid[1] - L;
			System.out.println(diff + " " + eEuclid[1] + " " + L);
			if(eEuclid[1] >= L) {
				shiftBy = (diff / b);
			}
			else {
				shiftBy = (diff / b) - (diff % b != 0 ? 1 : 0);
			}
			System.out.println(shiftBy);
			long lowestX  = eEuclid[1] - b * shiftBy;
			
			//now we repeat the same process for the highest x
			shiftBy = 0;
			diff = H - eEuclid[1];
			if(eEuclid[1] >= H) {
				shiftBy = (diff / b) - (diff % b != 0 ? 1 : 0);
			}
			else {
				shiftBy = (diff / b);
			}
			long highestX = eEuclid[1] + b*shiftBy;
			
			res = (highestX - lowestX) / b + 1;
			System.out.println(res);
		}
	}
	
	//copied straight from the GitHub hackpack.
	public static long[] eEuclid(long a, long b) {
		if (b == 0) return new long[] { a, 1, 0 };
		long[] ans = eEuclid(b, a % b);
		long temp = ans[1] - ans[2] * (a / b);
		ans[1] = ans[2];  ans[2] = temp;
		return ans;  //// modinverse(a,b) = ((eEuclid(a,b)[1] % b)+b)%b
	}

}
