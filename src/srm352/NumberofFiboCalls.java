package srm352;
// BEGIN CUT HERE

// END CUT HERE
import java.util.*;
public class NumberofFiboCalls {
    
	int[] r;
	int[] q;
	public int[] fiboCallsMade(int n) {
        
        r = new int[n+1];
        q = new int[n+1];
        
        int[] res = go(n);
        return res;
    }
	
	private int[] go(int n) {
		
		if(r[n]>0 | q[n]>0) return new int[]{r[n],q[n]};
		
		if(n==0) return new int[]{1,0};
		if(n==1) return new int[]{0,1};
		
		int[] cal1 = go(n-1);
		int[] cal2 = go(n-2);
		int[] res = new int[2];
		res[0] = cal1[0]+cal2[0];
		res[1] = cal1[1]+cal2[1];
		
		r[n] = res[0];
		q[n] = res[1];
		return res;
	}

}