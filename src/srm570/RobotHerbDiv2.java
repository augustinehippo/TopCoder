package srm570;
import java.util.*;
public class RobotHerbDiv2 {
    public int getdist(int T, int[] a) {
        int bX = 0;
        int bY = 0;
        int bD = 0;
    	for (int i = 0; i < T; i++) {
			for (int m : a) {
				bX +=   ((bD&1)- (2*(bD>>1))) *(m) * (bD&1);
				bY +=  (m) * ((bD&1)^1) * (((bD%2)^1) - (bD) );
				bD = (bD+m)%4;
			}
		}
        return Math.abs(bX)+Math.abs(bY);
    }

}
