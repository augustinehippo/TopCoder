package srm366;
import java.util.*;
public class ChangingSounds {
	int[] chng;
	int[][] dp;
	int mL;
	
	public int maxFinal(int[] changeIntervals, int beginLevel, int maxLevel){
		chng = changeIntervals;
		mL = maxLevel;
		dp = new int[1001][chng.length];
		for (int[] i : dp) {
			Arrays.fill(i, -2);
		}
		return go(beginLevel,0);
		
	}
	private int go(int bL, int i) {
		if(i>=chng.length) return bL;
		if(dp[bL][i]>-2) return dp[bL][i];
		int max = -1;
		int n = bL+chng[i];
		if(n>=0 && n<=mL){
			max = Math.max(max, go(n,i+1));
		}
		n = bL-chng[i];
		if(n>=0 && n<=mL){
			max = Math.max(max, go(n,i+1));
		}
		dp[bL][i] = max;
		return max;
	}

}


// Powered by FileEdit
// Powered by CodeProcessor
