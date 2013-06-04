import java.util.*;
public class PillarsDivTwo {
    double[][] dp;
	public double maximalLength(int[] h, int w) {
        int N = h.length;
    	dp = new double[N][];
    	dp[0]= new double[h[0]+1];
    	
    	for (int i = 1; i < h.length; i++) {
    		dp[i] = new double[h[i]+1];
			for (int j = 1; j <= h[i]; j++) {
				double max = 0;
				for (int k = 1; k <= h[i-1]; k++) {
					max = Math.max(max, dp[i-1][k]+Math.sqrt(w*w+Math.abs((j-k)*(j-k))));
				}
				dp[i][j] = max;
			}
		}
    	double best = 0;
    	for (int i = 1; i <= h[N-1]; i++) {
			best = Math.max(best, dp[N-1][i]);
		}
        return best;
    }

}
