package srm325;
// BEGIN CUT HERE

// END CUT HERE
import java.util.*;
import static java.lang.Math.min;
public class RGBStreet {
    int[][] cost;
    int[][] r;
	public int estimateCost(String[] houses) {
        r = new int[houses.length][3];
        cost = new int[houses.length][3];
        
        for (int i = 0; i < houses.length; i++) {
			String[] t = houses[i].split(" ");
			for (int j = 0; j < t.length; j++) {
				cost[i][j] = Integer.parseInt(t[j]);
			}
		}
        
        int min = Integer.MAX_VALUE/100;
        int n = houses.length-1;
        min = min(min,cost[n][0]+go(n-1,0));
        min = min(min,cost[n][1]+go(n-1,1));
        min = min(min,cost[n][2]+go(n-1,2));
        return min;
    }
	private int go(int n, int p) {
		
		if(n<0) return 0;
		if(r[n][p]>0) return r[n][p];
		
		int min = Integer.MAX_VALUE/100;
		min = min(min,cost[n][(p+1)%3]+go(n-1,(p+1)%3));
		min = min(min,cost[n][(p+2)%3]+go(n-1,(p+2)%3));
		
		r[n][p] = min;
		return r[n][p];
		
	}

}