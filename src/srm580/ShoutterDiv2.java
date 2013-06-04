package srm580;
import java.util.*;
public class ShoutterDiv2 {
    public int count(int[] s, int[] t) {
        int N = s.length;
    	
        int[][] sort = new int[N][2];
        for (int i = 0; i < sort.length; i++) {
			sort[i][0] = s[i];
			sort[i][1] = t[i];
		}
        
        Arrays.sort(sort, new Comparator<int[]>() {
            
            

			public int compare(int[] a0, int[] a1) {
				
				Integer e1 = a0[0];
				Integer e2 = a1[0];
				Integer e3 = a0[1];
				Integer e4 = a1[1];
				if(!e1.equals(e2)) {
					return e3.compareTo(e4);
				}
				return e1.compareTo(e2);
			}
        });

        for (int i = 0; i < sort.length; i++) {
			s[i]= sort[i][0];
			 t[i]= sort[i][1];
		}
       
    	int count = 0;
    	for (int i = 0; i < s.length; i++) {
			int st = s[i];
			int et = t[i];
			for (int j = 0; j < i; j++) {
				if(j==i) continue;
				if((s[j]>=st & s[j] <= et) || (st>=s[j] & st<=t[j] )) {
					//System.out.println("1:"+i+" "+j);
					count++; continue;
				}
				if((t[j] >= st & t[j] <= et) || (et >= s[j] & et <= t[j])) {
					//System.out.println("2: "+i+" "+j);
					count++; continue;
				}
			}
		}
        return count;
    }

}
