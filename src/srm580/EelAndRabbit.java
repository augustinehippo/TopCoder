package srm580;
import java.util.*;
public class EelAndRabbit {
    public int getmax(int[] l, int[] t) {
        
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for (int ti = 0; ti < t.length; ti++) {
			for (int li = t[ti]; li <= t[ti]+l[ti]; li++) {
				if(!map.containsKey(li)){
					map.put(li, 1);
				} else {
					map.put(li, map.get(li)+1);
				}
			}
		}
    	
    	int max = 0;
    	int sum = 0;
    	int index = 0;
    	for (int key : map.keySet()) {
			if(max<map.get(key)) {
				max = map.get(key);
				index = key;
			}
		}
    	
    	sum += max;
    	map = new HashMap<Integer, Integer>();
    	for (int ti = 0; ti < t.length; ti++) {
			if((index >= t[ti]) & (index <= t[ti]+l[ti])) {
				continue;
			}
			
			for (int li = t[ti]; li <= t[ti]+l[ti]; li++) {
				if(!map.containsKey(li)){
					map.put(li, 1);
				} else {
					map.put(li, map.get(li)+1);
				}
			}
			
		}
    	
    	max = 0;
    	for (int val : map.values()) {
			max = Math.max(max,val);
		}
    	return sum+max;
    }

}
